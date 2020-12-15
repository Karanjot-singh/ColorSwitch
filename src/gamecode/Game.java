package gamecode;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
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
	ObservableList<Node> list;

	Orb playerOrb;
	Color[] currentTheme;
	final double spacing = 70;

	Game(FXMLLoader fxmlLoader) {

		gameGrid = fxmlLoader.getRoot();
		gameColumn = new StackPane();
		obstacleColumn = new Pane();
		list = obstacleColumn.getChildren();

		obstacleColumn.setCenterShape(true);
		obstacleColumn.setPrefSize(200, 500);

		playerOrb = new Orb();
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

				playerOrb.jump(initPos);
				checkCollision(obstacles);
				if (playerOrb.getOrbGroup().getTranslateY() <= -40) {

					for (Node node : list) {
						moveDown(node);
					}

					if (list.get(list.size() - 1).getClass().getName() == "javafx.scene.layout.StackPane") {
						System.out.println(list.get(list.size() - 1).getLayoutY());
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

		createSwitcher(90, -40);
		createElement(20, -250);
	}

	public void createElement(double PosX, double PosY) {
		StackPane e1 = addObstacles();
		list.add(e1);
		e1.relocate(PosX, PosY);
	}

	public void removeElement(Node e) {
		System.out.println(e.getClass().getName() + " " + e.getTranslateY());

		if (e.getTranslateY() > 1000) {
			list.remove(e);
		}
	}

	void createSwitcher(double PosX, double PosY) {
		Group e2 = new ColorSwitcher().getSwitchGroup();
		list.addAll(e2);
		obstacleColumn.setCenterShape(true);
		e2.relocate(PosX, PosY);
	}

	public StackPane addObstacles() {

		CircleObstacle circle1 = new CircleObstacle(1, 1, 1, 1);
//		SquareObstacle square = new SquareObstacle(1, 1, 1, 1);
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
