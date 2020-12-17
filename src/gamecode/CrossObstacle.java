package gamecode;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;


public class CrossObstacle extends Obstacle {

    private final RotateTransition rotateTransition;
    Group crossGroup;

    public CrossObstacle(int stroke, int duration, int angle, int velocity) {
        super(stroke, duration, angle, velocity);
        GameAnimation.rotate(crossGroup, 0);

        crossGroup = new Group();
//      <Group layoutX="15.0" layoutY="200.0">
//                		<Line endX="-54.0" endY="39.0" layoutX="159.0" layoutY="64.0" startX="-17.0" startY="-2.0" stroke="#1750e1" strokeLineCap="ROUND" strokeWidth="12.0" />
//          		<Line endX="-150.0" endY="32.0" layoutX="204.0" layoutY="124.0" startX="-110.70709228515625" startY="-10.70709228515625" stroke="#49b244" strokeLineCap="ROUND" strokeWidth="12.0" />
//          		<Line endX="-54.0" endY="39.0" layoutX="147.0" layoutY="63.0" startX="-100.0" stroke="#d01212" strokeLineCap="ROUND" strokeWidth="12.0" />
//          		<Line endX="-54.0" endY="39.0" layoutX="205.0" layoutY="115.0" startX="-100.0" stroke="#e09b19" strokeLineCap="ROUND" strokeWidth="12.0" />
//      </Group>
        crossGroup = new Group();
        Line line = new Line(-17,-2,-54, 39);
        line.setStroke(Settings.currentTheme[0]);
        line.setLayoutX(159);
        line.setLayoutY(64);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        crossGroup.getChildren().add(line);
        line = new Line(-150,32,-110, -10);
        line.setStroke(Settings.currentTheme[1]);
        line.setLayoutX(204);
        line.setLayoutY(115);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        crossGroup.getChildren().add(line);
        line = new Line(-54, 39, -100,-2);
        line.setStroke(Settings.currentTheme[2]);
        line.setLayoutX(147);
        line.setLayoutY(63);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        crossGroup.getChildren().add(line);
        line = new Line(-100,0,-54,-39);
        line.setStroke(Settings.currentTheme[3]);
        line.setLayoutX(205);
        line.setLayoutY(115);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        crossGroup.getChildren().add(line);
        rotateTransition = GameAnimation.rotate(crossGroup, 0);
    }

    @Override
    public void saveObstacle() {

    }
    @Override
    public boolean checkCross(){
        return true;
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
        return crossGroup;
    }

    @Override
    public void scaleSize(int scale) {

    }
}
