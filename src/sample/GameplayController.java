package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
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
    Arc arc11,arc12,arc13,arc14,arc21,arc22,arc23,arc24,arc212,arc222,arc232,arc242;
    @FXML
    Group arcGrp1,arcGrp2,switchGroup;

    public void backClicked() {
        Main.window.setScene(Main.homeScene);
    }

    public void msgHover() {
        gameMsg.setText("GAME OVER!");
    }

    public void rotate(Group g) {
        RotateTransition rotation = new RotateTransition(Duration.seconds(25), g);

//		rotation.setAutoReverse(direction);
        rotation.setDelay(Duration.seconds(0));
//		rotation.setAxis(new Point3D(100,100,100));
        rotation.setCycleCount(500);
        rotation.setAxis(Rotate.Z_AXIS);
        rotation.setByAngle(360);
        rotation.setRate(5);
//        rotation.

        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.play();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        arc212.setFill(Color.web("#e4e42c"));
        arc222.setFill(Color.web("#9711ae"));
        arc232.setFill(Color.web("#32d0d0"));
        arc242.setFill(Color.web("#eb0d4c"));
        rotate(arcGrp1);


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