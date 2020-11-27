package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.io.IOException;

public class CrossObstacle {

    @FXML
    Group crossGrp;

    public static Group get() throws IOException {
        return FXMLLoader.load(CrossObstacle.class.getResource("crossObstacle.fxml"));
    }


//    public CrossObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
//        super(currentTheme, stroke, duration, angle, velocity);
//    }

//    @Override
//    public void scaleSize(int scale){
//
//    }
}
