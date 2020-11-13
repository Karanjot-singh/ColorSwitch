package sample;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.animation.RotateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.paint.Color;

public class CircleObstacle extends Obstacle {

    public CircleObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
        super(currentTheme, stroke, duration, angle, velocity);
    }
}
