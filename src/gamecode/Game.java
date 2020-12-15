package gamecode;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;

public class Game {

    GridPane gameGrid;
    Pane obstacleColumn;
    StackPane gameColumn;

    int score;
    float height;
    ArrayList<Group> obstacles = new ArrayList<>();
    ArrayList<Shape> stars = new ArrayList<>();
    ArrayList<Group> colorSwitchers = new ArrayList<>();

    Orb playerOrb;
    Color[] currentTheme;
    final double spacing = 70;


    Game(FXMLLoader fxmlLoader) {

        gameGrid = fxmlLoader.getRoot();
        gameColumn = new StackPane();
        obstacleColumn = new Pane();


        obstacleColumn.setCenterShape(true);
        obstacleColumn.setPrefSize(200, 500);

        playerOrb = new Orb();
        double initPos = playerOrb.getOrbGroup().getTranslateY();

        //TODO Generalise using spacing variable
        createElement(20, 300);

        createSwitcher(90, 228);
        createElement(20, 20);

//		createSwitcher(90,-90);
//		createElement(20,-20);


        gameColumn.getChildren().addAll(obstacleColumn, playerOrb.getOrbGroup());
        gameColumn.getChildren().get(1).setTranslateY(100);
        gameColumn.setAlignment(Pos.BOTTOM_CENTER);
        gameColumn.setMinHeight(500);

        gameGrid.setGridLinesVisible(true);
        gameGrid.add(gameColumn, 1, 0, 1, 6);

        //	Timeline timeline2 = new Timeline();
//	KeyValue end = new KeyValue(bullet.translateYProperty(), -800, new Interpolator() {
//		@Override
//		protected double curve(double t) {
//			return t;
//		}
//	});
//	KeyFrame endF = new KeyFrame(Duration.seconds(10), end);
//
//    timeline2.getKeyFrames().addAll(endF);

        Main.gameplayScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
                incrementScore();
//                moveDown();
//                playerOrb.jump(initPos);

                playerOrb.jump(initPos);
                checkCollision(obstacles);
                if (playerOrb.getOrbGroup().getTranslateY() <= -40) {
//					createElement(1,1);
//					createSwitcher();
//					if(obstacleColumn.getChildren().get(0).getTranslateY()>0)
//					{
//						obstacleColumn.getChildren().remove(0);
//					}
                    for (Node node : obstacleColumn.getChildren()) {
                        moveDown(node);
                    }
                    //TODO Fix incoming object positions
                    System.out.println(obstacleColumn.getChildren().get(0).getLayoutY());
                    if (obstacleColumn.getChildren().get(0).getTranslateY() > 350) {
                        System.out.println(obstacleColumn.getChildren().get(0).getClass().getName() + " " + obstacleColumn.getChildren().get(0).getTranslateY());
                        if (obstacleColumn.getChildren().get(0).getClass().getName() == "javafx.scene.layout.StackPane") {
                            createSwitcher(90, 228);
                            createElement(20, 20);
                        }
                        obstacleColumn.getChildren().remove(0);
                    }

                }
            }
        });
    }


    public void createElement(double PosX, double PosY) {

        StackPane e1 = addObstacles();
//		Group e2 = createSwitcher();

        obstacleColumn.getChildren().add(e1);
        e1.relocate(PosX, PosY);
//		obstacleColumn.setTopAnchor(e1, Top);
//		obstacleColumn.setLeftAnchor(e1, Left);
//		obstacleColumn.setRightAnchor(e1, 50.0);

//		obstacleColumn.getChildren().add( new ColorSwitcher().getSwitchGroup());
//		obstacleColumn.setTopAnchor(e2, 200.0);
//		obstacleColumn.setLeftAnchor(e2, 122.0);
//		obstacleColumn.setRightAnchor(e2, 40.0);
//		obstacleColumn.setAlignment(Pos.TOP_CENTER);
//		obstacleColumn.setSpacing(40);
    }

    public void removeElement(Node e) {
        System.out.println(e.getClass().getName() + " " + e.getTranslateY());

        if (e.getTranslateY() > 600) {
            obstacleColumn.getChildren().remove(e);
//			createSwitcher();
        }
    }

    void createOrb() {

    }

    void createSwitcher(double PosX, double PosY) {
//		obstacleColumn.getChildren().add( new ColorSwitcher().getSwitchGroup());
        Group e2 = new ColorSwitcher().getSwitchGroup();
        obstacleColumn.getChildren().addAll(e2);
        obstacleColumn.setCenterShape(true);
        e2.relocate(PosX, PosY);
//		obstacleColumn.setTopAnchor(e2, Top);
//		obstacleColumn.setLeftAnchor(e2, Left);

//		return new ColorSwitcher().getSwitchGroup();
    }

    public StackPane addObstacles() {

        CircleObstacle circle1 = new CircleObstacle(1, 1, 1, 1);
//		SquareObstacle square = new SquareObstacle(1, 1, 1, 1);
//		ColorSwitcher colorSwitcher = new ColorSwitcher();
        Star star = new Star();
        obstacles.add(circle1.getArcGroup());

        return new StackPane(circle1.getArcGroup(), star.getStarIcon());
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

    public void gameOver() {

    }

    public void revive() {
    }

    public <T> Boolean checkCollision(ArrayList<T> list) {
        boolean collisionSafe = false;
        for (T element : list) {
            Group elementGroup = (Group) element;
            for (Node iterator : elementGroup.getChildren()) {
                Shape shape = (Shape) iterator;
                Shape orb = (Shape) playerOrb.getOrbGroup().getChildren().get(0);
                if ((orb.getFill()).equals(shape.getStroke())) {
//                    System.out.println("same"+shape.getStroke());
                    collisionSafe = true;
                } else {
//                    System.out.println("diff"+shape.getStroke());
                }
                Shape intersect = Shape.intersect(orb, shape);
                if (intersect.getBoundsInLocal().getWidth() != -1 && (!collisionSafe)) {
                    System.out.println("Collision");
                    return true;
                }
            }
        }
        return false;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addScore(int score) {
        this.score += score;
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
