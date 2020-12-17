package gamecode;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public interface GameAnimation {
    static RotateTransition rotate(Group g, double delay, int direction) {
        RotateTransition rotation = new RotateTransition(Duration.seconds(25), g); //decreases speed

//		rotation.setAutoReverse(direction);
        rotation.setDelay(Duration.seconds(delay));
//		rotation.setAxis(new Point3D(100,100,100));
        rotation.setCycleCount(500);
        rotation.setAxis(Rotate.Z_AXIS);
        rotation.setByAngle(direction * 360);
        rotation.setRate(5); //increases speed
        rotation.setInterpolator(Interpolator.LINEAR);
        rotation.play();
//        rotation.playFrom();
        return rotation;
    }

    static TranslateTransition Xtranslation(Group g, double delay, int speed) {
        Duration duration = Duration.millis(3000 / speed);
        TranslateTransition transition = new TranslateTransition(duration, g);
        transition.setByX(30);
        transition.setDelay(Duration.millis(delay));
        transition.setAutoReverse(true);
        transition.setCycleCount(50);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.play();
        return transition;
    }

    static TranslateTransition Ytranslation(Group g, double delay, int speed) {
        Duration duration = Duration.millis(3000 / speed);
        TranslateTransition transition = new TranslateTransition(duration, g);
        transition.setDelay(Duration.millis(delay));
        transition.setByY(-30);
        transition.setAutoReverse(true);
        transition.setCycleCount(50);
        transition.setInterpolator(Interpolator.LINEAR);
        transition.play();
        return transition;
    }

    static SequentialTransition scaleTransition(Group g, double delay, int scale) {
        Duration duration = Duration.millis(2500);
        ScaleTransition increase = new ScaleTransition(duration, g);
        increase.setByX(0.5);
        increase.setByY(0.5);
        ScaleTransition decrease = new ScaleTransition(duration, g);
        decrease.setByX(-0.2);
        decrease.setByY(-0.2);

        SequentialTransition sequentialTransition = new SequentialTransition(decrease, increase);
        sequentialTransition.setDelay(Duration.millis(delay));
        sequentialTransition.play();
        sequentialTransition.setCycleCount(500);
        return sequentialTransition;
    }


}
