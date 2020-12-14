package gamecode;

import javafx.scene.Group;


public class CrossObstacle extends Obstacle {

    Group crossGroup;

    public CrossObstacle(int stroke, int duration, int angle, int velocity) {
        super(stroke, duration, angle, velocity);
        Rotation.rotate(crossGroup,0);
    }

    public Group getCrossGroup() {
        return crossGroup;
    }

    @Override
    public void scaleSize(int scale){

    }
}
