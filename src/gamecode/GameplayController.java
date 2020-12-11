package gamecode;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameplayController implements Initializable {
	//	Orb player = null;
	Scene testScene;
	@FXML
	GridPane grid;

	@FXML
	ImageView pauseIcon;

	@FXML
	Label scoreLabel;

//	static VBox gameColumn;
//	static StackPane gameScreen;
//	//
//	int score;
//	float height;
//	ArrayList<Obstacle> obstacles;
//	Orb playerOrb;
//	Color[] currentTheme;

//	public GameplayController() {
//
//		testScene = new Scene(Main.gameplayRoot);
//	}

	@FXML
	void pauseClicked(MouseEvent mouseEvent) {
		PausePopupController.display();
	}

	@FXML
	void backClicked(MouseEvent mouseEvent) {
		Main.window.setScene(Main.homeScene);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

//		testScene = new Scene(Main.gameplayRoot);

//		playerOrb = new Orb();
//
//		try {
//			addObstacles();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		double initPos = playerOrb.getOrbGroup().getTranslateY();
//		grid.setOnKeyPressed(e -> {
//			if (e.getCode() == KeyCode.SPACE) {
//				System.out.println("A key was pressed");
//				moveDown();
//				playerOrb.jump(initPos);
//			}
//		});
//		Main.testScene.setOnKeyPressed(e -> {
//			if (e.getCode() == KeyCode.SPACE) {
////                System.out.println("A key was pressed");
//				moveDown();
//				playerOrb.jump(initPos);
//			}
//		});

//		Main.getGameScene().setOnKeyPressed(e -> {
//			if (e.getCode() == KeyCode.W) {
////                System.out.println("A key was pressed");
//				moveDown();
//			}
//		});


//		grid.add(gameScreen,1,0,1,6);

	}}

//	static void addElement(Pane p, int i, int i2, int i3, int i4){
//		grid.add(p,1,0,1,6);
//	}

//	Scene getScene(){
//		return this.testScene;
//	}
//
//	public void addObstacles() throws IOException {
////		Group g1 = FXMLLoader.load(getClass().getResource("circleObstacle.fxml"));
//		CircleObstacle circle1 = new CircleObstacle(1, 1, 1, 1);
//		CircleObstacle circle2 = new CircleObstacle(1, 1, 1, 1);
//		ColorSwitcher colorSwitcher = new ColorSwitcher();
//		Star star = new Star();
//		/*
//		GAME LOOP
//		dynamic, one object per FXML
//		Array<>=[CO, TO, RO, ]
//		for(){
//		random index i of above list
//		Element e = grid.add(list[i].get(), 1, 1);
//		display ColorSwitcher(pos X , posY)
//		e.transitionToEndOfScreen();
//		e.removeFromScreen();
//		}
//		*/
//
//		/*
//		root[ orb,sub=[children]]
//		 */
//		gameScreen = new StackPane();
//		gameColumn = new VBox();
//
//		gameColumn.getChildren().addAll(circle1.getArcGroup(), colorSwitcher.getSwitchGroup(), circle2.getArcGroup());
//		gameColumn.setSpacing(40);
//		gameColumn.setAlignment(Pos.CENTER);
//
//		gameScreen.getChildren().addAll(gameColumn, playerOrb.getOrbGroup()); //star.getStarIcon(),
//		gameScreen.getChildren().get(1).setTranslateY(100);
//		gameScreen.setAlignment(Pos.BOTTOM_CENTER);
//
//		grid.add(gameScreen, 1, 0, 1, 6);
//
////		Circle c1 = new Circle(10);
////		c1.setFill(Color.BLUEVIOLET);
////		grid.add(c1,1,7);
//
////		grid.add(g1, 1, 1);
////		grid.add(CircleObstacle.get(), 1, 5);
////		grid.add(ColorSwitcher.get(), 1, 3);
////		grid.add(Star.get(), 1,1);
////		grid.add(Star.get(), 1,5);
//
//
//		//Setting the X,Y,Z coordinates to apply the translation
////		t.setFromY(0);
//
////		b.setOnMouseClicked(new EventHandler<MouseEvent>() {
////			@Override
////			public void handle(MouseEvent mouseEvent) {
////				t.play();
////			}
////		});
//
//
//	}
//
//	void moveDown() {
////		TranslateTransition t = new TranslateTransition(Duration.seconds(1), v);
//
////		t.setToY(10);
////		v.setTranslateY(700);
//		double ty = gameColumn.getTranslateY();
//
//
//		Interpolator interpolator = new Interpolator() {
//			@Override
//			protected double curve(double t) {
//				// t is the fraction of animation completed
//				return t; //rate to change animation speed
//			}
//
//		};
//
//		Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,
//				new KeyValue(gameColumn.translateYProperty(), ty, interpolator)),
//				new KeyFrame(Duration.millis(60),
//						new KeyValue(gameColumn.translateYProperty(), ty + 30, interpolator)));
//
////		timeline.setCycleCount(1);
//		timeline.setAutoReverse(false);
//		timeline.play();
//	}
//
//	void gameplay() {
//
//	}
//
//	public void pauseGame() {
//
//	}
//
//	public void gameOver() {
//
//	}
//
//	public void revive() {
//	}
//
//	public Boolean checkCollision() {
//		return true;
//	}
//
//	public void createElement(int PosX, int PosY) {
//
//	}
//
//	public void removeElement(Elements element) {
//
//	}
//
//	public void createOrb() {
//
//	}
//
//	public int getScore() {
//		return score;
//	}
//
//	public void addScore(int score) {
//		this.score += score;
//	}
//
//	public float getHeight() {
//		return height;
//	}
//
//	public void setHeight(float height) {
//		this.height = height;
//	}
//
//	public ArrayList<Obstacle> getObstacles() {
//		return obstacles;
//	}
//
//	public void setObstacles(ArrayList<Obstacle> obstacles) {
//		this.obstacles = obstacles;
//	}
//
//	public Orb getOrb() {
//		return playerOrb;
//	}
//
//	public void setOrb(Orb orb) {
//		this.playerOrb = orb;
//	}
//
//	public Color[] getCurrentTheme() {
//		return currentTheme;
//	}
//
//	public void setCurrentTheme(Color[] currentTheme) {
//		this.currentTheme = currentTheme;
//	}
//
//}
//
