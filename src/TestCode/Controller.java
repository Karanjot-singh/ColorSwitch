package TestCode;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class Controller {

    static boolean direction = true;
    static int angle = 360;
    static int duration = 50;
    @FXML
    static
    Arc arc1;
    @FXML
    static

    Arc arc2;
    @FXML
    static

    Arc arc3;
    @FXML
    static
    Arc arc4;

    public static void rotate(Arc arc) {
        RotateTransition rotation = new RotateTransition(Duration.seconds(duration), arc);

        rotation.setAutoReverse(direction);
        rotation.setDelay(Duration.seconds(0));
        rotation.setCycleCount(500);
//        rotation.setAxis(Rotate.Z_AXIS);
        rotation.setByAngle(angle);
        rotation.setRate(50);

//        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.play();

    }

    @FXML
    public void play() {
        rotate(arc1);
        rotate(arc2);
        rotate(arc3);
        rotate(arc4);


    }

    public static void main() {

        rotate(arc1);
        rotate(arc2);
        rotate(arc3);
        rotate(arc4);
    }
}
