package sample;

import javafx.scene.paint.Color;

public class CrossObstacle extends Obstacle {


    public CrossObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
        super(currentTheme, stroke, duration, angle, velocity);
    }

    @Override
    public void scaleSize(int scale){

    }
}
