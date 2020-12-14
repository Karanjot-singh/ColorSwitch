package gamecode;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.ArrayList;

public class Game{

    GridPane gameGrid;
    VBox obstacleColumn;
    StackPane gameColumn;

    int score;
    float height;
    ArrayList<Obstacle> obstacles;
    Orb playerOrb;
    Color[] currentTheme;


    Game(FXMLLoader fxmlLoader) {

        gameGrid = fxmlLoader.getRoot() ;
        gameColumn = new StackPane();
        obstacleColumn = new VBox();


        playerOrb = new Orb();
        double initPos = playerOrb.getOrbGroup().getTranslateY();

//        addObstacles();
		createElement(1,1);

		gameColumn.getChildren().addAll(obstacleColumn, playerOrb.getOrbGroup());
		gameColumn.getChildren().get(1).setTranslateY(100);
		gameColumn.setAlignment(Pos.BOTTOM_CENTER);
//		gameGrid.add(gameColumn, 1, 0, 1, 6);
		gameGrid.setGridLinesVisible(true);
        gameGrid.add(gameColumn, 1, 0, 1, 6);

        Main.gameplayScene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.SPACE) {

//                moveDown();
//                playerOrb.jump(initPos);

                playerOrb.jump(initPos);
                if (playerOrb.getOrbGroup().getTranslateY() <= -40){
					createElement(1,1);
					createSwitcher();
//					if(obstacleColumn.getChildren().get(0).getTranslateY()>0)
//					{
//						obstacleColumn.getChildren().remove(0);
//					}
					for (Node node: obstacleColumn.getChildren()) {
						moveDown(node);
//						removeElement(node);
					}
                }

            }
        });
    }

	public void createElement(int PosX, int PosY) {
		StackPane e1 = addObstacles();
		obstacleColumn.getChildren().add(e1);
		obstacleColumn.setAlignment(Pos.TOP_CENTER);
		obstacleColumn.setSpacing(40);


	}

	public void removeElement(Node e) {
		System.out.println(e.getClass().getName()+" " +e.getTranslateY());
		if(e.getTranslateY()>0)
		{
			obstacleColumn.getChildren().remove(e);
		}

	}

	void createOrb() {

	}

	void createSwitcher() {
		obstacleColumn.getChildren().add( new ColorSwitcher().getSwitchGroup());
	}

    public StackPane addObstacles() {

		CircleObstacle circle1 = new CircleObstacle(1, 1, 1, 1);
//		CircleObstacle circle2 = new CircleObstacle(1, 1, 1, 1);
//		ColorSwitcher colorSwitcher = new ColorSwitcher();
		Star star = new Star();

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

    public Boolean checkCollision() {
        return true;
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
