package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SquareObstacle extends Obstacle {

    @FXML
    Group squareGroup;

    public SquareObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
        super(currentTheme, stroke, duration, angle, velocity);
    }


    @Override
    public void scaleSize(int scale){

    }

    @Override
    public Group getFXML() throws IOException {
        return FXMLLoader.load(SquareObstacle.class.getResource("squareObstacle.fxml"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rotation.rotate(squareGroup,0);
    }
}
