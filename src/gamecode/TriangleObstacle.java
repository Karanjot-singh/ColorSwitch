package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TriangleObstacle extends Obstacle {

    @FXML
    Group triangleGroup;

    public TriangleObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
        super(currentTheme, stroke, duration, angle, velocity);
    }

    @Override
    public void scaleSize(int scale){

    }

    @Override
    public Group getFXML() throws IOException {
        return FXMLLoader.load(TriangleObstacle.class.getResource("triangleObstacle.fxml"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rotation.rotate(triangleGroup,0);
    }
}
