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
    private int elementCount = 2;

    Game(FXMLLoader fxmlLoader) {

        setGameGrid(fxmlLoader.getRoot());
        setGameColumn(new StackPane());
        setObstacleColumn(new Pane());
        setObstacles(new ArrayList<>());
        setObjects(new ArrayList<>());
        setList(getObstacleColumn().getChildren());

        getObstacleColumn().setCenterShape(true);
        getObstacleColumn().setPrefSize(200, 500);

        setPlayerOrb(new Orb());
        setColorFlag(getPlayerOrb().getColor());
        double initPos = getPlayerOrb().getOrbGroup().getTranslateY();

        initialiseObstacles();

        getGameColumn().getChildren().addAll(getObstacleColumn(), getPlayerOrb().getOrbGroup());
        getGameColumn().getChildren().get(1).setTranslateY(100);
        getGameColumn().setAlignment(Pos.BOTTOM_CENTER);
        getGameColumn().setMinHeight(500);

        getGameGrid().setGridLinesVisible(true);
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
//						System.out.println(list.get(list.size() - 1).getLayoutY());
                        if (getList().get(getList().size() - 1).getTranslateY() > 180) {
                            createSwitcher(90, -90);
                        }
                    } else {
                        if (getList().get(getList().size() - 1).getTranslateY() > 20) {
                            createElement(20, -250);
                        }
                    }
                    removeElement(getList().get(0));

                }
            }
        });
    }

    static void gameLoop() {
        Timeline gameTimeline = new Timeline();
        final Duration fps = Duration.millis(1000 / 60);
        final KeyFrame gameFrame = new KeyFrame(fps, new EventHandler() {
            @Override
            public void handle(Event event) {
//                Main.currentGame.checkObstacleCollision();
                Main.getCurrentGame().obstacleCollision();
                Main.getCurrentGame().otherCollisions();

                if (Main.getCurrentGame().getPlayerOrb().getOrbGroup().getTranslateY() > 150 || Main.getCurrentGame().isGameStop()) {
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

    void initialiseObstacles() {
        //TODO Generalise using spacing variable
        createElement(20, 290);

        createSwitcher(90, 230);
        createElement(20, 20);

        setGameStart(true);
        createSwitcher(90, -40);
        createElement(20, -250);
    }

    public void createElement(double PosX, double PosY) {
        StackPane e1 = addObstacles();
        getList().add(e1);
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
                setElementCount(getElementCount() - 1);
            }
        }
    }

    void createSwitcher(double PosX, double PosY) {
        Circle e2 = new ColorSwitcher().getSwitchGroup();
        getList().addAll(e2);
        getObstacleColumn().setCenterShape(true);
        e2.relocate(PosX, PosY);
    }

    public StackPane addObstacles() {

        Random ran = new Random();
        Star star = new Star();
        Obstacle obstacle = new CircleObstacle(1, 1, 1, 1);

        if (isGameStart()) {
            switch (ran.nextInt(3)) {
                case 0:
                    obstacle = new CircleObstacle(1, 1, 1, 1);
                    break;
                case 1:
                    obstacle = new SquareObstacle(1, 1, 1, 1);
                    break;
                case 2:
                    obstacle = new TriangleObstacle(1, 1, 1, 1);
                    break;
            }
        }
//		CircleObstacle circle1 = new CircleObstacle(1, 1, 1, 1);
//		SquareObstacle square = new SquareObstacle(1, 1, 1, 1);

        getObstacles().add(obstacle.getGroup());
        getObjects().add(obstacle);
        return new StackPane(obstacle.getGroup(), star.getStarShape());
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
        getPlayerOrb().pauseAnimation();
    }

    public void playGame() {
        for (Obstacle element : getObjects()) {
            element.playAnimation();
        }
        getPlayerOrb().playAnimation();
    }

    public boolean isGameStop() {
        return gameStop;
    }

    public void gameOver() {
        Main.getPlayer().addTotalStars(this.getScore());
        if (this.getScore() > Main.getPlayer().getHighscore()) {
            Main.getPlayer().setHighscore(this.getScore());
        }
        try {
            Main.setGameOverScene(new Scene(FXMLLoader.load(getClass().getResource("gameOver.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameOverController.display();
    }

    public void revive() throws InsufficientStarsException {
        if (Main.getPlayer().getTotalStars() >= 5) {
            setGameStop(false);
            setRevived(true);
            Main.getPlayer().subtractStars(5);
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
//        System.out.println("Orb: "+orb.getStroke()+" "+orb.getFill());
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
                        tempPane.getChildren().remove(1);
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
//            removeElement(list.get(0));
            getList().remove(0);
        }
    }

    public void checkObstacleCollision() {
        boolean collisionSafe = false;
        Shape orb = (Shape) getPlayerOrb().getOrbGroup().getChildren().get(0);
//        System.out.println("Orb: "+orb.getStroke()+" "+orb.getFill());
        for (Group elementGroup : getObstacles()) {

            for (Node iterator : elementGroup.getChildren()) {
                Shape shape = (Shape) iterator;
                if ((orb.getStroke()).equals(shape.getStroke())) {
//                    System.out.println("same"+shape.getStroke());
                    collisionSafe = true;
                }
                Shape intersect = Shape.intersect(orb, shape);
                if (intersect.getBoundsInLocal().getWidth() != -1 && (!collisionSafe)) {
                    System.out.println("ColX ");
//                    gameStop = true;
                }
            }
        }
    }

    public void obstacleCollision() {
        boolean collisionSafe = false;
        Shape orb = (Shape) getPlayerOrb().getOrbGroup().getChildren().get(0);
        for (Node element : getList()) {
//            System.out.println(list.size());
            // Collision for Obstacles
            if (element.getClass().getName().equals("javafx.scene.layout.StackPane")) {
                StackPane tempPane = (StackPane) element;
                Group obstacleGroup = (Group) tempPane.getChildren().get(0);
                for (Node sub : obstacleGroup.getChildren()) {
                    Shape shape = (Shape) sub;
                    //                    System.out.println("same"+shape.getStroke());
                    collisionSafe = (orb.getStroke()).equals(shape.getStroke());
                    Shape intersect = Shape.intersect(orb, shape);
                    if ((!collisionSafe) && intersect.getBoundsInLocal().getWidth() != -1) {
                        System.out.println("Collision ");
                        setGameStop(true);
                    }
                }
            }
        }
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

    public void setGameStop(boolean gameStop) {
        this.gameStop = gameStop;
    }

    public void setRevived(boolean revived) {
        this.revived = revived;
    }

    public int getElementCount() {
        return elementCount;
    }

    public void setElementCount(int elementCount) {
        this.elementCount = elementCount;
    }
}
