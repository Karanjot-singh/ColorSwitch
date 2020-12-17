package gamecode;

import javafx.animation.*;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Serializable {

    static ObstacleFactory factory;
    private final double spacing = 70;
    private GridPane gameGrid;
    private Pane obstacleColumn;
    private StackPane gameColumn;
    private ArrayList<Group> obstacles;
    private ObservableList<Node> list;
    private ArrayList<Obstacle> objects;
    private int score;
    private float height;
    private Orb playerOrb;
    private Color[] currentTheme;
    private Color colorFlag;
    private boolean gameStart = false;
    private boolean gameStop = false;
    private boolean revived = false;
    private boolean orbDead = false;
    private boolean paused = false;
    private int elementCount = 2;
    private int levelCount = 0;
    private int levelAuxiliary = 0;
    final double switcherX = 85;
    final double elementX = 20;


    Game(FXMLLoader fxmlLoader) {

        setGameGrid(fxmlLoader.getRoot());
        setGameColumn(new StackPane());
        setObstacleColumn(new Pane());
        setObstacles(new ArrayList<>());
        setObjects(new ArrayList<>());
        setList(getObstacleColumn().getChildren());
        factory = new ObstacleFactory();

        getObstacleColumn().setCenterShape(true);
        getObstacleColumn().setPrefSize(200, 500);

        setPlayerOrb(new Orb(0, 0));
        setColorFlag(getPlayerOrb().getColor());
        double initPos = getPlayerOrb().getOrbGroup().getTranslateY();

        initialiseObstacles();

        getGameColumn().getChildren().addAll(getObstacleColumn(), getPlayerOrb().getOrbGroup());
        getGameColumn().getChildren().get(1).setTranslateY(100);
        getGameColumn().setAlignment(Pos.BOTTOM_CENTER);
        getGameColumn().setMinHeight(500);

        getGameGrid().setGridLinesVisible(false);
        getGameGrid().add(getGameColumn(), 1, 0, 1, 6);

        Main.getGameplayScene().setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                Main.getCurrentGame().obstacleCollision();
                Main.getCurrentGame().otherCollisions();
                getPlayerOrb().jump(initPos);
//                checkCollision(obstacles);
                if (getPlayerOrb().getOrbGroup().getTranslateY() <= -40) {

                    for (Node node : getList()) {
                        moveDown(node);
                    }

                    if (getList().get(getList().size() - 1).getClass().getName() == "javafx.scene.layout.StackPane") {
                        if (getList().get(getList().size() - 1).getTranslateY() > 180) {
                            createSwitcher(switcherX, -90);
                        }
                    } else {
                        if (getList().get(getList().size() - 1).getTranslateY() > 20) {
                            createElement(elementX, -250);
                        }
                    }
                    removeElement(getList().get(0));

                }
            }
        });
    }

    static void gameLoop() {
        //TODO  make fps 60 after testing
        Timeline gameTimeline = new Timeline();
        final Duration fps = Duration.millis(1000 / 1);
        final KeyFrame gameFrame = new KeyFrame(fps, new EventHandler() {
            @Override
            public void handle(Event event) {
                Main.getCurrentGame().obstacleCollision();
                Main.getCurrentGame().otherCollisions();
//                Main.getCurrentGame().saveState();

                if ((Main.getCurrentGame().isOrbDead() || Main.getCurrentGame().isGameStop()) && !Main.getCurrentGame().isPaused()) {
                    System.out.println("GAME OVER");
                    gameTimeline.stop();
                    Main.getCurrentGame().gameOver();
                }
            }
        });
        gameTimeline.setCycleCount(Animation.INDEFINITE);
        gameTimeline.getKeyFrames().addAll(gameFrame);
        gameTimeline.play();

    }

    public int getLevelCount() {
        return levelCount;
    }

    public boolean isOrbDead() {
        orbDead = this.getPlayerOrb().getOrbGroup().getTranslateY() > 150;
        return orbDead;
    }

    public void setOrbDead(boolean orbDead) {
        this.orbDead = orbDead;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    void initialiseObstacles() {
        //TODO Generalise using spacing variable
        createElement(elementX, 290);

        createSwitcher(switcherX, 230);
        createElement(elementX, 20);

        setGameStart(true);
        createSwitcher(switcherX, -40);
        createElement(elementX, -250);
    }

    public void createElement(double PosX, double PosY) {
        StackPane e1 = addObstacles();
        getList().add(e1);
        if (levelAuxiliary >= 3) {
            levelCount++;
            levelAuxiliary = 0;
        } else {
            levelAuxiliary++;
        }
        System.out.println("LA=" + levelAuxiliary + " LC=" + levelCount);
        e1.relocate(PosX, PosY);
    }

    public void removeElement(Node e) {
//        System.out.println(e.getClass().getName() + " " + e.getTranslateY());


        int pos;

        if (getElementCount() == 2) {
            pos = 400;
        } else if (getElementCount() == 1) {
            pos = 600;
        } else {
            pos = 1000;
        }
        if (e.getTranslateY() > pos) {
            getList().remove(e);
            if (e.getClass().getName().equals("javafx.scene.layout.StackPane")) {
                getObstacles().remove(e);
                getObjects().remove(0);
                setElementCount(getElementCount() - 1);
            }
        }
    }

    void createSwitcher(double PosX, double PosY) {
        Circle e2 = new ColorSwitcher(0, 0).getSwitchGroup();
        getList().addAll(e2);
        getObstacleColumn().setCenterShape(true);
        e2.relocate(PosX, PosY);
    }

    public StackPane addObstacles() {

        Random ran = new Random();
        Star star = new Star(0, 0);
        Obstacle obstacle = factory.createObstacle(0, this.getLevelCount()>=2);

        if (isGameStart()) {
            obstacle = factory.createObstacle(ran.nextInt(4),this.getLevelCount()>=2);
        }

        getObstacles().add(obstacle.getGroup());
        getObstacles().add(obstacle.getGroup());
        getObjects().add(obstacle);
        StackPane temp = new StackPane(obstacle.getGroup(), star.getStarShape());
        if (obstacle.checkCross()) {
//            Group crossGroup = obstacle.getGroup();
//            crossGroup.setLayoutX(15);
//            crossGroup.setLayoutY(200);
            temp.getChildren().get(0).setTranslateX(-20);
            temp.getChildren().get(1).setTranslateY(-25);
            temp.getChildren().get(1).setTranslateX(23);
//            temp.setAlignment(obstacle.getGroup(), Pos.TOP_LEFT);
//            temp.setAlignment(star.getStarShape(), Pos.CENTER_RIGHT);
        }
        return temp;
    }

    void moveDown(Node x) {

        double ty = x.getTranslateY();
        Interpolator interpolator = new Interpolator() {
            @Override
            protected double curve(double t) {
                // t is the fraction of animation completed
                return t; //rate to change animation speed
            }

        };

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(x.translateYProperty(), ty, interpolator)),
                new KeyFrame(Duration.millis(150),
                        new KeyValue(x.translateYProperty(), ty + 30, interpolator)));

//		timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();
    }

    public void incrementScore() {
        int newScore = this.getScore() + 1;
        this.setScore(newScore);
        Label score = (Label) getGameGrid().getChildren().get(0);
        score.setText("" + newScore);

    }

    void gameplay() {

    }

    public void pauseGame() {
        for (Obstacle element : getObjects()) {
            element.pauseAnimation();
        }
        setOrbDead(false);
        getPlayerOrb().pauseAnimation();
        getPlayerOrb().getOrbGroup().setTranslateY(100);
    }

    public void playGame() {
        for (Obstacle element : getObjects()) {
            element.playAnimation();
        }
        getPlayerOrb().playAnimation();
    }

    public void saveStatus() {
        setOrbDead(false);
        for (Obstacle element : getObjects()) {
            element.saveObstacle();
        }
    }

    public boolean isGameStop() {
        return gameStop;
    }

    public void setGameStop(boolean gameStop) {
        this.gameStop = gameStop;
    }

    public void gameOver() {
        Player.getInstance().addTotalStars(this.getScore());
        if (this.getScore() > Player.getInstance().getHighscore()) {
            Player.getInstance().setHighscore(this.getScore());
        }
        try {
            Main.setGameOverScene(new Scene(FXMLLoader.load(getClass().getResource("gameOver.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameOverController.display();
    }

    public void revive() throws InsufficientStarsException {
        if (Player.getInstance().getTotalStars() >= 5) {
            setGameStop(false);
            setRevived(true);
            Player.getInstance().subtractStars(5);
            getGameColumn().getChildren().get(1).setTranslateY(0);
            gameLoop();
        } else {
            throw new InsufficientStarsException("Not enough stars");
        }

    }

    public void otherCollisions() {
        Shape orb = (Shape) getPlayerOrb().getOrbGroup().getChildren().get(0);
        Shape starShape;
        int delete = 0;
        //TODO implement iterator
        for (Node element : getList()) {
            // Collision for Stars
            if (element.getClass().getName().equals("javafx.scene.layout.StackPane")) {
                StackPane tempPane = (StackPane) element;
                if (tempPane.getChildren().size() > 1) {
                    starShape = (Shape) tempPane.getChildren().get(1);
                    Shape intersect = Shape.intersect(orb, starShape);
                    if (intersect.getBoundsInLocal().getWidth() != -1) {
                        starShape.setVisible(false);
                        incrementScore();
                        setColorFlag(getPlayerOrb().getColor());
                        tempPane.getChildren().remove(1); //remove star
                    }
                }
            }
            //Collision with ColorSwitcher
            else if (element.getClass().getName().equals("javafx.scene.shape.Circle") && element.isVisible()) {
                Circle elementGroup = (Circle) element;
                Shape intersect = Shape.intersect(orb, elementGroup);
                if (intersect.getBoundsInLocal().getWidth() != -1) {
                    elementGroup.setVisible(false);
                    if (getColorFlag().equals(orb.getFill()))
                        getPlayerOrb().switchColor();
                    delete = 1;
                }
            }
        }
        if (delete == 1 && getList().get(0).getClass().getName().equals("javafx.scene.shape.Circle")) {
            getList().remove(0);
        }
    }

    public void obstacleCollision() {
        boolean collisionSafe = false;
        Shape orb = (Shape) getPlayerOrb().getOrbGroup().getChildren().get(0);
        //TODO implement iterator
        for (Node element : getList()) {
            // Collision for Obstacles
            if (element.getClass().getName().equals("javafx.scene.layout.StackPane")) {
                StackPane tempPane = (StackPane) element;
                Group obstacleGroup = (Group) tempPane.getChildren().get(0);
                for (Node sub : obstacleGroup.getChildren()) {
                    Shape shape = (Shape) sub;
                    collisionSafe = (orb.getStroke()).equals(shape.getStroke());
                    Shape intersect = Shape.intersect(orb, shape);
                    if ((!collisionSafe) && intersect.getBoundsInLocal().getWidth() != -1) {
//                        System.out.println("Collision ");
                        //TODO enable collisions
//                        setGameStop(true);
                    }
                }
            }
        }
    }

    public void saveState() {
        boolean collisionSafe = false;
        Shape orb = (Shape) getPlayerOrb().getOrbGroup().getChildren().get(0);
        //TODO implement iterator
        int i =0;
        while(i< getList().size()){
            if (getList().get(i).getClass().getName().equals("javafx.scene.layout.StackPane")) {


                i++;
            }

            }
        for (Node element : getList()) {
            // Collision for Obstacles
            if (element.getClass().getName().equals("javafx.scene.layout.StackPane")) {
                StackPane tempPane = (StackPane) element;
//                System.out.println(tempPane.getLayoutY() + " " + tempPane.getTranslateY());

                Group obstacleGroup = (Group) tempPane.getChildren().get(0);
            }
        }
//        System.out.println("------------------");


    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public ArrayList<Group> getObstacles() {
        return obstacles;
    }

    public void setObstacles(ArrayList<Group> obstacles) {
        this.obstacles = obstacles;
    }

    public Orb getOrb() {
        return getPlayerOrb();
    }

    public void setOrb(Orb orb) {
        this.setPlayerOrb(orb);
    }

    public Color[] getCurrentTheme() {
        return currentTheme;
    }

    public void setCurrentTheme(Color[] currentTheme) {
        this.currentTheme = currentTheme;
    }

    public boolean isRevived() {
        return revived;
    }

    public void setRevived(boolean revived) {
        this.revived = revived;
    }

    public double getSpacing() {
        return spacing;
    }

    public GridPane getGameGrid() {
        return gameGrid;
    }

    public void setGameGrid(GridPane gameGrid) {
        this.gameGrid = gameGrid;
    }

    public Pane getObstacleColumn() {
        return obstacleColumn;
    }

    public void setObstacleColumn(Pane obstacleColumn) {
        this.obstacleColumn = obstacleColumn;
    }

    public StackPane getGameColumn() {
        return gameColumn;
    }

    public void setGameColumn(StackPane gameColumn) {
        this.gameColumn = gameColumn;
    }

    public ObservableList<Node> getList() {
        return list;
    }

    public void setList(ObservableList<Node> list) {
        this.list = list;
    }

    public ArrayList<Obstacle> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<Obstacle> objects) {
        this.objects = objects;
    }

    public Orb getPlayerOrb() {
        return playerOrb;
    }

    public void setPlayerOrb(Orb playerOrb) {
        this.playerOrb = playerOrb;
    }

    public Color getColorFlag() {
        return colorFlag;
    }

    public void setColorFlag(Color colorFlag) {
        this.colorFlag = colorFlag;
    }

    public boolean isGameStart() {
        return gameStart;
    }

    public void setGameStart(boolean gameStart) {
        this.gameStart = gameStart;
    }

    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }
}
