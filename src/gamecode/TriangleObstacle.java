package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TriangleObstacle extends Obstacle {

    Group triangleGroup;

    public TriangleObstacle(int stroke, int duration, int angle, int velocity) {
        super(stroke, duration, angle, velocity);
        Rotation.rotate(triangleGroup,0);
    }

    @Override
    public void scaleSize(int scale){

    }
}
