package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrossObstacle extends Obstacle {

    Group crossGroup;

    public CrossObstacle(int stroke, int duration, int angle, int velocity) {
        super(stroke, duration, angle, velocity);
        Rotation.rotate(crossGroup,0);
    }

    public Group getCrossGroup() {
        return crossGroup;
    }

    @Override
    public void scaleSize(int scale){

    }
}
