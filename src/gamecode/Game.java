package gamecode;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

import java.util.ArrayList;

public class Game {

    GridPane gameGrid;
    VBox obstacleColumn;
    StackPane gameColumn;

    int score;
    float height;
    ArrayList<Group> obstacles= new ArrayList<>();
    ArrayList<Shape> stars= new ArrayList<>();
    ArrayList<Group> colorSwitchers = new ArrayList<>();

    Orb playerOrb;
    Color[] currentTheme;


    Game(FXMLLoader fxmlLoader) {

        gameGrid = fxmlLoader.getRoot();
        gameColumn = new StackPane();
        obstacleColumn = new VBox();


        playerOrb = new Orb();
        double initPos = playerOrb.getOrbGroup().getTranslateY();

        addObstacles();
        gameGrid.add(gameColumn, 1, 0, 1, 6);

        Main.gameplayScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
//                moveDown();
//                playerOrb.jump(initPos);
                playerOrb.jump(initPos);
                checkCollision(obstacles);

                if (playerOrb.getOrbGroup().getTranslateY() <= -40) {
                    moveDown();
                }

            }
        });
    }

    public void addObstacles() {

        CircleObstacle circle1 = new CircleObstacle(1, 1, 1, 1);
        CircleObstacle circle2 = new CircleObstacle(1, 1, 1, 1);
        ColorSwitcher colorSwitcher = new ColorSwitcher();
        Star star = new Star();

        obstacleColumn.getChildren().addAll(circle1.getArcGroup(), colorSwitcher.getSwitchGroup(), circle2.getArcGroup());
        obstacles.add(circle1.getArcGroup());
        colorSwitchers.add(colorSwitcher.getSwitchGroup());
        obstacles.add(circle2.getArcGroup());

        obstacleColumn.setSpacing(40);
        obstacleColumn.setAlignment(Pos.TOP_CENTER);

        gameColumn.getChildren().addAll(obstacleColumn, playerOrb.getOrbGroup()); //star.getStarIcon(),
        gameColumn.getChildren().get(1).setTranslateY(100);
        gameColumn.setAlignment(Pos.BOTTOM_CENTER);

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

    }

    void moveDown() {
        double ty = obstacleColumn.getTranslateY();
        Interpolator interpolator = new Interpolator() {
            @Override
            protected double curve(double t) {
                // t is the fraction of animation completed
                return t; //rate to change animation speed
            }

        };

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,
                new KeyValue(obstacleColumn.translateYProperty(), ty, interpolator)),
                new KeyFrame(Duration.millis(60),
                        new KeyValue(obstacleColumn.translateYProperty(), ty + 30, interpolator)));

//		timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();
    }

    void pauseClicked(MouseEvent mouseEvent) {
        PausePopupController.display();
    }

    void backClicked(MouseEvent mouseEvent) {
        Main.window.setScene(Main.homeScene);
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
        boolean collisionSafe =false;
        for (T element : list) {
            Group elementGroup = (Group) element;
            for ( Node iterator : elementGroup.getChildren()) {
                Shape shape = (Shape) iterator;
                Shape orb = (Shape) playerOrb.getOrbGroup().getChildren().get(0);
                if((orb.getFill()).equals(shape.getStroke())){
//                    System.out.println("same"+shape.getStroke());
                    collisionSafe=true;
                }
                else{
//                    System.out.println("diff"+shape.getStroke());
                }
                Shape intersect = Shape.intersect(orb, shape);
                if (intersect.getBoundsInLocal().getWidth() != -1 && (!collisionSafe)){
                    System.out.println("Collision");
                    return true;
                }
            }
        }
        return false;
    }


    public void createElement(int PosX, int PosY) {

    }

    public void removeElement(Elements element) {

    }

    public void createOrb() {

    }

    public int getScore() {
        return score;
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
