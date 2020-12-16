package gamecode;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public interface Rotation {
    static RotateTransition rotate(Group g, double delay) {
        RotateTransition rotation = new RotateTransition(Duration.seconds(25), g); //decreases speed

//		rotation.setAutoReverse(direction);
        rotation.setDelay(Duration.seconds(delay));
//		rotation.setAxis(new Point3D(100,100,100));
        rotation.setCycleCount(500);
        rotation.setAxis(Rotate.Z_AXIS);
        rotation.setByAngle(360);
        rotation.setRate(5); //increases speed
        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.play();
        return rotation;
    }


}
