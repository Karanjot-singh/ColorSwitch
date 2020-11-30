package gamecode;

import javafx.animation.*;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.awt.geom.AffineTransform;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameplayController implements Initializable {

//	static Scene gameplayScene;
	@FXML
	GridPane grid;

	@FXML
	ImageView pauseIcon;

	@FXML
	Label score;

	static VBox gameColumn;

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

//		gameplayScene = new Scene(Main.gameplayRoot);

		try {
			addObstacles();
		} catch (IOException e) {
			e.printStackTrace();
		}



//		Main.getGameScene().setOnKeyPressed(e -> {
//			if (e.getCode() == KeyCode.W) {
////                System.out.println("A key was pressed");
//				moveDown();
//			}
//		});

	}

	public void addObstacles() throws IOException {
		Group g1 = FXMLLoader.load(getClass().getResource("circleObstacle.fxml"));
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
		gameColumn = new VBox();
		gameColumn.getChildren().addAll(g1,ColorSwitcher.get(),CircleObstacle.get());
		gameColumn.setSpacing(40);
		gameColumn.setAlignment(Pos.CENTER);

		grid.add(gameColumn, 1, 0, 1, 6);

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
		double ty = gameColumn.getTranslateY();


		Interpolator interpolator = new Interpolator() {
			@Override
			protected double curve(double t) {
				// t is the fraction of animation completed
				return t ; //rate to change animation speed
			}

		};

		Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,
				new KeyValue(gameColumn.translateYProperty(),ty, interpolator)),
				new KeyFrame(Duration.millis(60),
						new KeyValue(gameColumn.translateYProperty(), ty + 30, interpolator)));

//		timeline.setCycleCount(1);
		timeline.setAutoReverse(false);
		timeline.play();
	}

}



//
//    public void rotate(Arc arc) {
//        RotateTransition rotation = new RotateTransition(Duration.seconds(Duration.INDEFINITE.toMinutes()), arc);
//
////		rotation.setAutoReverse(direction);
//        rotation.setDelay(Duration.seconds(0));
////		rotation.setAxis(new Point3D(100,100,100));
//        rotation.setCycleCount(500);
////        rotation.setAxis(Rotate.Z_AXIS);
//        rotation.setAxis(new Point3D(80,80,80));
//        rotation.setByAngle(90);
//        rotation.setRate(30);
////        rotation.
//
//        rotation.setInterpolator(Interpolator.LINEAR);
//        rotation.play();
//
//    }