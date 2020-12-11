package gamecode;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;

public class Game{
//    static VBox gameColumn;
//    static StackPane gameScreen;

    int score;
    float height;
    ArrayList<Obstacle> obstacles;
    Orb playerOrb;
    Color[] currentTheme;


    Game() {

//        currentTheme = new Color[]{Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN};
//        CircleObstacle obs = new CircleObstacle(currentTheme, 5, 600, 90, 10);
//        Main.gameplayPane.getChildren().add(playRegion);

        playerOrb = new Orb();
        double initPos = playerOrb.getOrbGroup().getTranslateY();
        try {
            addObstacles();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.gameplayScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {
//                System.out.println("A key was pressed");
                moveDown();
                playerOrb.jump(initPos);
            }
        });
    }

    public void addObstacles() throws IOException {
//		Group g1 = FXMLLoader.load(getClass().getResource("circleObstacle.fxml"));
        CircleObstacle circle1 = new CircleObstacle(1,1,1,1);
        CircleObstacle circle2 = new CircleObstacle(1,1,1,1);
        ColorSwitcher colorSwitcher = new ColorSwitcher();
        Star star = new Star();
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
		*/

		/*
		root[ orb,sub=[children]]
		 */
//        GameplayController.gameScreen = new StackPane();
//        GameplayController.gameColumn = new VBox();
        GameplayController.gameColumn.getChildren().addAll(circle1.getArcGroup(), colorSwitcher.getSwitchGroup(),circle2.getArcGroup());
        GameplayController.gameColumn.setSpacing(40);
        GameplayController.gameColumn.setAlignment(Pos.CENTER);

        GameplayController.gameScreen.getChildren().addAll(GameplayController.gameColumn,  playerOrb.getOrbGroup()); //star.getStarIcon(),
        GameplayController.gameScreen.getChildren().get(1).setTranslateY(100);
        GameplayController.gameScreen.setAlignment(Pos.BOTTOM_CENTER);

//        GameplayController.grid.add(gameScreen,1,0,1,6);
//        GameplayController.addElement(gameScreen,1,0,1,6);

//		Circle c1 = new Circle(10);
//		c1.setFill(Color.BLUEVIOLET);
//		grid.add(c1,1,7);

//		grid.add(g1, 1, 1);
//		grid.add(CircleObstacle.get(), 1, 5);
//		grid.add(ColorSwitcher.get(), 1, 3);
//		grid.add(Star.get(), 1,1);
//		grid.add(Star.get(), 1,5);


        //Setting the X,Y,Z coordinates to apply the translation
//		t.setFromY(0);

//		b.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent mouseEvent) {
//				t.play();
//			}
//		});



    }

    void moveDown()
    {
//		TranslateTransition t = new TranslateTransition(Duration.seconds(1), v);

//		t.setToY(10);
//		v.setTranslateY(700);
        double ty = GameplayController.gameColumn.getTranslateY();


        Interpolator interpolator = new Interpolator() {
            @Override
            protected double curve(double t) {
                // t is the fraction of animation completed
                return t ; //rate to change animation speed
            }

        };

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,
                new KeyValue(GameplayController.gameColumn.translateYProperty(),ty, interpolator)),
                new KeyFrame(Duration.millis(60),
                        new KeyValue(GameplayController.gameColumn.translateYProperty(), ty + 30, interpolator)));

//		timeline.setCycleCount(1);
        timeline.setAutoReverse(false);
        timeline.play();
    }

    void gameplay() {

    }

    public void pauseGame() {

    }

    public void gameOver() {

    }

    public void revive() {
    }

    public Boolean checkCollision() {
        return true;
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

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(ArrayList<Obstacle> obstacles) {
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
