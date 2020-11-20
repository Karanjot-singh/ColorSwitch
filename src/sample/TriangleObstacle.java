package sample;

import javafx.scene.paint.Color;

public class TriangleObstacle extends Obstacle {

    public TriangleObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
        super(currentTheme, stroke, duration, angle, velocity);
    }

    @Override
    public void scaleSize(int scale){

    }
}
