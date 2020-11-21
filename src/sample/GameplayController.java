package sample;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class GameplayController implements Initializable {

	public Button backButton;
	public Label gameMsg;
	@FXML
	Arc arc1, arc2, arc3, arc4;
	@FXML
	Group arcGrp;

	static boolean direction = true;
	static int angle = 360;
	static int duration = 50;

	public void backClicked()
	{
		Main.window.setScene(Main.homeScene);
	}

	public void msgHover()
	{
		gameMsg.setText("GAME OVER!");
	}

	public static void rotate(Arc arc) {
		RotateTransition rotation = new RotateTransition(Duration.seconds(duration), arc);

		rotation.setAutoReverse(direction);
		rotation.setDelay(Duration.seconds(0));
		rotation.setCycleCount(500);
        rotation.setAxis(Rotate.Z_AXIS);
		rotation.setByAngle(angle);
		rotation.setRate(50);

//        rotation.setInterpolator(Interpolator.LINEAR);
		rotation.play();

	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
//		rotate(arcGrp);
		rotate(arc1);
		rotate(arc2);
		rotate(arc3);
		rotate(arc4);
	}
}
