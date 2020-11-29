package gamecode;

import javafx.scene.paint.Color;

public class SquareObstacle extends Obstacle {

    public SquareObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
        super(currentTheme, stroke, duration, angle, velocity);
    }


    @Override
    public void scaleSize(int scale){

    }
}
