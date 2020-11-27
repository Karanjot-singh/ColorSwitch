package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameplayController implements Initializable {

	@FXML
	GridPane grid;

	@FXML
	ImageView pauseIcon;

	@FXML
	Label score;

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

		try {
			addObstacles();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addObstacles() throws IOException {
//		Group g1 = FXMLLoader.load(getClass().getResource("circleObstacle.fxml"));
		grid.add(CircleObstacle.get(), 1, 1);
		grid.add(CircleObstacle.get(), 1, 5);
		grid.add(ColorSwitcher.get(), 1, 3);
		grid.add(Star.get(), 1,1);
		grid.add(Star.get(), 1,5);
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