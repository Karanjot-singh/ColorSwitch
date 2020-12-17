package gamecode;

import javafx.animation.RotateTransition;
import javafx.scene.Group;


public class LineObstacle extends Obstacle {

    private final RotateTransition rotateTransition;
    int numLines;
    Group lineGroup;

    //    		<Line endX="32.0" endY="54.0" layoutX="33.0" layoutY="33.0" startX="-13.0" startY="54.0" stroke="#1750e1" strokeLineCap="ROUND" strokeWidth="12.0" />
//      <Line endX="32.0" endY="54.0" layoutX="92.0" layoutY="33.0" startX="-13.0" startY="54.0" stroke="#09c909" strokeLineCap="ROUND" strokeWidth="12.0" />
//      <Line endX="32.0" endY="54.0" layoutX="156.0" layoutY="33.0" startX="-13.0" startY="54.0" stroke="#e08219" strokeLineCap="ROUND" strokeWidth="12.0" />
//      <Line endX="32.0" endY="54.0" layoutX="219.0" layoutY="33.0" startX="-13.0" startY="54.0" stroke="#e01969" strokeLineCap="ROUND" strokeWidth="12.0" />
    public LineObstacle(int stroke, int duration, int angle, int velocity) {
        super(stroke, duration, angle, velocity);
        rotateTransition = GameAnimation.rotate(lineGroup, 0);
    }

    @Override
    public void saveObstacle() {

    }

    @Override

    public void pauseAnimation() {
        rotateTransition.pause();
    }

    @Override

    public void playAnimation() {
        rotateTransition.play();
    }

    @Override
    public Group getGroup() {
        return lineGroup;
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
