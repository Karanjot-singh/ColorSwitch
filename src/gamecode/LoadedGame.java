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
import java.util.ArrayList;
import java.util.Random;

public class LoadedGame {
    static ObstacleFactory factory;
    final transient double switcherX = 85;
    final transient double elementX = 20;
    private transient final double spacing = 70;
    Database savedGame;
    private transient GridPane gameGrid;
    private transient Pane obstacleColumn;
    private transient StackPane gameColumn;
    private transient ArrayList<Group> obstacles;
    private transient ObservableList<Node> list;
    private transient ArrayList<Obstacle> objects;
    private transient int score;
    private transient float height;
    private transient Orb playerOrb;
    private transient Color[] currentTheme;
    private transient Color colorFlag;
    private transient boolean gameStart = false;
    private transient boolean gameStop = false;
    private transient boolean revived = false;
    private transient boolean orbDead = false;
    private transient boolean paused = false;
    private transient int elementCount = 2;
    private transient int levelCount = 0;
    private transient int levelAuxiliary = 0;

    LoadedGame(FXMLLoader fxmlLoader) {

        savedGame = SavedGames.getDatabase();

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
                Main.getCurrentLoadedGame().obstacleCollision();
                Main.getCurrentLoadedGame().otherCollisions();
                getPlayerOrb().jump(initPos);
                Random ran = new Random();
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
                            createElement(ran.nextInt(4), elementX, -250);
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
                Main.getCurrentLoadedGame().obstacleCollision();
                Main.getCurrentLoadedGame().otherCollisions();
//                Main.getCurrentGame().saveState();

                if ((Main.getCurrentLoadedGame().isOrbDead() || Main.getCurrentGame().isGameStop()) && !Main.getCurrentGame().isPaused()) {
                    System.out.println("GAME OVER");
                    gameTimeline.stop();
                    Main.getCurrentLoadedGame().gameOver();
                }
            }
        });
        gameTimeline.setCycleCount(Animation.INDEFINITE);
        gameTimeline.getKeyFrames().addAll(gameFrame);
        gameTimeline.play();

    }

    public double computeAnimationTime(Obstacle o) {
        if (o.getAnimationTime() < o.getAnimationDuration()) {
            return o.getAnimationTime();
        } else {
            return (o.getAnimationTime() / o.getAnimationDuration());
        }
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
        double posy = 600;
//        //TODO Generalise using spacing variable
//        createElement(elementX, 290);
//
//        createSwitcher(switcherX, 230);
//        createElement(elementX, 20);
//
//        setGameStart(true);
//        createSwitcher(switcherX, -40);
//        createElement(elementX, -250);
        setGameStart(true);
        setOrbDead(false);
        setGameStop(false);
        this.setScore(savedGame.getScore());
        Label score = (Label) getGameGrid().getChildren().get(0);
        score.setText("" + savedGame.getScore());
        for (Obstacle node : savedGame.getOnScreenObstacles()) {
            double posX = node.getPosX();
            double posY = node.getPosY();

            System.out.println(posX);
            System.out.println(posY);

            int type = 0;
            if (node.getName().equals("gamecode.CircleObstacle")) {
                type = 0;
            } else if (node.getName().equals("gamecode.DiamondObstacle")) {
                type = 1;
            } else if (node.getName().equals("gamecode.SquareObstacle")) {
                type = 2;
            } else if (node.getName().equals("gamecode.CrossObstacle")) {
                type = 3;
            }
            System.out.println(type);

            createElement(type, elementX, posy);
//            getList().get(getList().size()-1).relocate(posX,posY);
            posy -= 270;
        }
    }

    public void createElement(int type, double PosX, double PosY) {
        StackPane e1 = addObstacles(type);
        getList().add(e1);
        if (levelAuxiliary >= 3) {
            levelCount++;
            levelAuxiliary = 0;
        } else {
            levelAuxiliary++;
        }
//        System.out.println("LA=" + levelAuxiliary + " LC=" + levelCount);
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

    public StackPane addObstacles(int type) {

        Random ran = new Random();
        Star star = new Star(0, 0);
        Obstacle obstacle = factory.createObstacle(type, this.getLevelCount() >= 2);

//        if (isGameStart()) {
//            obstacle = factory.createObstacle(ran.nextInt(4),this.getLevelCount()>=2);
//        }

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

    public void initialiseState() throws IOException {
        Database d = new Database();
        saveState(d);
        Database.serialize(d);
        SavedGames.addToSavedGames(d);
    }

    public void saveState(Database d) {
        d.setScore(this.score);
        boolean except = false;
        Obstacle savedObstacle = null;
        int i = 0, j = 0;
        while (j < getList().size() && i < getObjects().size()) {
            if (getList().get(j).getClass().getName().equals("javafx.scene.layout.StackPane")) {
                Node element = getList().get(j);
                StackPane tempPane = (StackPane) element;
//                try{
                savedObstacle = getObjects().get(i);
                savedObstacle.setPosX(tempPane.getTranslateX());
                savedObstacle.setPosY(tempPane.getTranslateY());
                saveAnimation(savedObstacle, d);
//                }
//                catch (IndexOutOfBoundsException e){
//                    except = true;
//                    break;
//                }
                i++;
            } else {
                j++;
            }

        }
        if (except) {
            saveAnimation(savedObstacle, d);
        }
    }

    private void saveAnimation(Obstacle savedObstacle, Database d) {
        RotateTransition saveTransition = savedObstacle.getRotation();
        savedObstacle.setAnimationTime(saveTransition.getCurrentTime().toSeconds());
        savedObstacle.setAnimationDuration(saveTransition.getDuration().toSeconds());
        savedObstacle.setName(savedObstacle.getClass().getName());
        d.getOnScreenObstacles().add(savedObstacle);
//        if (savedObstacle.getClass().getName() == "CircleObstacle") {
//
//        } else if (savedObstacle.getClass().getName() == "DiamondObstacle") {
//
//        }else if (savedObstacle.getClass().getName() == "CircleObstacle") {
//
//        }else if (savedObstacle.getClass().getName() == "CircleObstacle") {
//
//        }
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
