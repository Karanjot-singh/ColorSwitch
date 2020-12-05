package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CrossObstacle extends Obstacle {

    @FXML
    Group crossGroup;

    public CrossObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
        super(currentTheme, stroke, duration, angle, velocity);
    }

    @Override
    public Group getFXML() throws IOException {
        return FXMLLoader.load(CrossObstacle.class.getResource("crossObstacle.fxml"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rotation.rotate(crossGroup,0);
    }

//    @Override
//    public void scaleSize(int scale){
//
//    }
}
