package gamecode;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public interface GameAnimation {
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
    static TranslateTransition Xtranslation(Group g, double delay,int speed){
        Duration duration = Duration.millis(3000/speed);
        TranslateTransition transition = new TranslateTransition(duration, g);
        transition.setByX(150);
//        transition.setByY(500);
        transition.setAutoReverse(true);
        transition.setCycleCount(50);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.play();
        return transition;
    }
    static TranslateTransition Ytranslation(Group g, double delay,int speed){
        Duration duration = Duration.millis(3000/speed);
        TranslateTransition transition = new TranslateTransition(duration, g);
        transition.setByY(-60);
        transition.setAutoReverse(true);
        transition.setCycleCount(50);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.play();
        return transition;
    }


}
