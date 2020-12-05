package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LineObstacle extends Obstacle {

    int numLines;
    Group lineGroup;

    public LineObstacle(int stroke, int duration, int angle, int velocity) {
        super(stroke, duration, angle, velocity);
        Rotation.rotate(lineGroup,0);
    }

    @Override
    public void scaleSize(int scale) {

    }

    public int getNumLines() {
        return numLines;
    }

    public void setNumLines(int numLines) {
        this.numLines = numLines;
    }

    public Group getLineGroup() {
        return lineGroup;
    }

}
