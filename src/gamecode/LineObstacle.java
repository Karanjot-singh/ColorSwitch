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

    @FXML
    Group lineGroup;

    public LineObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
        super(currentTheme, stroke, duration, angle, velocity);
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


    @Override
    public Group getFXML() throws IOException {
        return FXMLLoader.load(LineObstacle.class.getResource("lineObstacle.fxml"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rotation.rotate(lineGroup,0);
    }
}
