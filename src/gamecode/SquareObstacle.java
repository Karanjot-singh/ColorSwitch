package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SquareObstacle extends Obstacle {

    Group squareGroup;

    public SquareObstacle(int stroke, int duration, int angle, int velocity) {
        super(stroke, duration, angle, velocity);
        Rotation.rotate(squareGroup,0);
    }

    public Group getSquareGroup() {
        return squareGroup;
    }

    @Override
    public void scaleSize(int scale){

    }

}
