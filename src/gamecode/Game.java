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
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Game {

    GridPane gameGrid;
    Pane obstacleColumn;
    StackPane gameColumn;
    ArrayList<Group> obstacles;
    ArrayList<Node> temp;

    ObservableList<Node> list;

    int score;
    float height;
    Orb playerOrb;
    Color[] currentTheme;
    Color colorFlag;
    final double spacing = 70;
    boolean gameStart = false;
    boolean gameStop = false;
    boolean revived = false;

    Game(FXMLLoader fxmlLoader) {

        gameGrid = fxmlLoader.getRoot();
        gameColumn = new StackPane();
        obstacleColumn = new Pane();
        obstacles = new ArrayList<>();
        temp = new ArrayList<Node>();
        list = obstacleColumn.getChildren();

        obstacleColumn.setCenterShape(true);
        obstacleColumn.setPrefSize(200, 500);

        playerOrb = new Orb();
        colorFlag = playerOrb.getColor();
        double initPos = playerOrb.getOrbGroup().getTranslateY();

        initialiseObstacles();

        gameColumn.getChildren().addAll(obstacleColumn, playerOrb.getOrbGroup());
        gameColumn.getChildren().get(1).setTranslateY(100);
        gameColumn.setAlignment(Pos.BOTTOM_CENTER);
        gameColumn.setMinHeight(500);

        gameGrid.setGridLinesVisible(true);
        gameGrid.add(gameColumn, 1, 0, 1, 6);

        Main.gameplayScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
//                moveDown();
//                playerOrb.jump(initPos);

                playerOrb.jump(initPos);
//                checkCollision(obstacles);
                if (playerOrb.getOrbGroup().getTranslateY() <= -40) {

                    for (Node node : list) {
                        moveDown(node);
                    }

                    if (list.get(list.size() - 1).getClass().getName() == "javafx.scene.layout.StackPane") {
//						System.out.println(list.get(list.size() - 1).getLayoutY());
                        if (list.get(list.size() - 1).getTranslateY() > 180) {
                            createSwitcher(90, -90);
                        }
                    } else {
                        if (list.get(list.size() - 1).getTranslateY() > 20) {
                            createElement(20, -250);
                        }
                    }
                    removeElement(list.get(0));

                }
            }
        });
    }

    void initialiseObstacles() {
        //TODO Generalise using spacing variable
        createElement(20, 290);

        createSwitcher(90, 230);
        createElement(20, 20);

        gameStart = true;
        createSwitcher(90, -40);
        createElement(20, -250);
    }

    public void createElement(double PosX, double PosY) {
        StackPane e1 = addObstacles();
        list.add(e1);
        temp.add(e1);
        e1.relocate(PosX, PosY);
    }

    public void removeElement(Node e) {
//        System.out.println(e.getClass().getName() + " " + e.getTranslateY());

        if (e.getTranslateY() > 1000) {
            list.remove(e);
            temp.remove(e);
        }
    }

    void createSwitcher(double PosX, double PosY) {
        Circle e2 = new ColorSwitcher().getSwitchGroup();
        list.addAll(e2);
        obstacleColumn.setCenterShape(true);
        e2.relocate(PosX, PosY);
    }

    public StackPane addObstacles() {

        Random ran = new Random();
        Star star = new Star();
        Obstacle obstacle = new CircleObstacle(1, 1, 1, 1);

        if (gameStart) {
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

        obstacles.add(obstacle.getGroup());
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
        Label score = (Label) gameGrid.getChildren().get(0);
        score.setText("" + newScore);

    }

    void gameplay() {

    }

    public void pauseGame() {

    }

    public boolean isGameStop() {
        return gameStop;
    }

    public void gameOver() {
        Main.player.addTotalStars(this.score);
        if (this.getScore() > Main.player.getHighscore()) {
            Main.player.setHighscore(this.getScore());
        }
        try {
            Main.gameOverScene = new Scene(FXMLLoader.load(getClass().getResource("gameOver.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        GameOverController.display();
    }

    public void revive() {
        gameStop = false;
        revived = true;
        //TODO Reduce stars from player
        //TODO throw insufficient stars exception
        gameColumn.getChildren().get(1).setTranslateY(0);
        gameLoop(Main.currentGame);
    }

    public void otherCollisions() {
        Shape orb = (Shape) playerOrb.getOrbGroup().getChildren().get(0);
        Shape starShape;
        int delete = 0;
//        System.out.println("Orb: "+orb.getStroke()+" "+orb.getFill());
        for (Node element : list) {
            // Collision for Stars
            if (element.getClass().getName().equals("javafx.scene.layout.StackPane")) {
                StackPane tempPane = (StackPane) element;
                if (tempPane.getChildren().size() > 1) {
                    starShape = (Shape) tempPane.getChildren().get(1);
                    Shape intersect = Shape.intersect(orb, starShape);
                    if (intersect.getBoundsInLocal().getWidth() != -1) {
                        starShape.setVisible(false);
                        incrementScore();
                        colorFlag = playerOrb.getColor();
                        tempPane.getChildren().remove(1);
                    }
                }
            }
            //Collision with ColorSwitcher
            else if (element.getClass().getName().equals("javafx.scene.shape.Circle")) {
                Circle elementGroup = (Circle) element;
                Shape intersect = Shape.intersect(orb, elementGroup);
                if (intersect.getBoundsInLocal().getWidth() != -1) {
                    elementGroup.setVisible(false);
                    if (colorFlag.equals(orb.getFill()))
                        playerOrb.switchColor();
                    delete = 1;
                }
            }
        }
        if (delete == 1 && list.get(0).getClass().getName().equals("javafx.scene.shape.Circle")) {
            removeElement(list.get(0));
        }
    }

    public Boolean checkObstacleCollision() {
        boolean collisionSafe = false;

        Shape orb = (Shape) playerOrb.getOrbGroup().getChildren().get(0);
//        System.out.println("Orb: "+orb.getStroke()+" "+orb.getFill());
        for (Group elementGroup : obstacles) {
            for (Node iterator : elementGroup.getChildren()) {
                Shape shape = (Shape) iterator;
                if ((orb.getStroke()).equals(shape.getStroke())) {
//                    System.out.println("same"+shape.getStroke());
                    collisionSafe = true;
                }
                Shape intersect = Shape.intersect(orb, shape);
                if (intersect.getBoundsInLocal().getWidth() != -1 && (!collisionSafe)) {
//                    System.out.print("Collision "+shape.getStroke()+ " ");
                    gameStop = true;
                    return true;
                }
            }
        }
        return false;
    }

    public void checkSwitchCollision() {
        boolean collisionSafe = false;
        Shape orb = (Shape) playerOrb.getOrbGroup().getChildren().get(0);
        System.out.println("Orb: " + orb.getStroke() + " " + orb.getFill());
        for (Group elementGroup : obstacles) {
            for (Node iterator : elementGroup.getChildren()) {
                Shape shape = (Shape) iterator;
                if ((orb.getStroke()).equals(shape.getStroke())) {
//                    System.out.println("same"+shape.getStroke());
                    collisionSafe = true;
                } else {
//                    System.out.println("diff"+shape.getStroke());
                }
                Shape intersect = Shape.intersect(orb, shape);
                if (intersect.getBoundsInLocal().getWidth() != -1 && (!collisionSafe)) {
//                    System.out.print("Collision "+shape.getStroke()+ " ");
                    return;
                }
            }
        }
    }

    static void gameLoop(Game currentGame) {
        Timeline gameTimeline = new Timeline();
        final Duration fps = Duration.millis(1000 / 90);
        final KeyFrame gameFrame = new KeyFrame(fps, new EventHandler() {
            @Override
            public void handle(Event event) {
                Main.currentGame.checkObstacleCollision();
//                currentGame.checkStarCollision();
                Main.currentGame.otherCollisions();

                if (Main.currentGame.playerOrb.getOrbGroup().getTranslateY() > 150 || Main.currentGame.isGameStop()) {
                    System.out.println("GAME OVER");
                    gameTimeline.stop();
                    Main.currentGame.gameOver();
                }
            }
        });


        //// sets the game world's game loop (Timeline)
//        TimelineBuilder.create()
//                .cycleCount(Animation.INDEFINITE)
//                .keyFrames(gameFrame)
//                .build()
//                .play();
        gameTimeline.setCycleCount(Animation.INDEFINITE);
        gameTimeline.getKeyFrames().addAll(gameFrame);
        gameTimeline.play();

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
        return playerOrb;
    }

    public void setOrb(Orb orb) {
        this.playerOrb = orb;
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
}


        /*
		GAME LOOP
            dynamic, one object per FXML
            Array<>=[CO, TO, RO, ]
            for(){
            random index i of above list
            Element e = grid.add(list[i].get(), 1, 1);
            display ColorSwitcher(pos X , posY)
            e.transitionToEndOfScreen();
            e.removeFromScreen();
            }

            root[ orb,sub=[children]]
		*/
