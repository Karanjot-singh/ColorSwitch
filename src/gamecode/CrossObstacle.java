package gamecode;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;


public class CrossObstacle extends Obstacle {

    Group crossGroup;

    public CrossObstacle(int stroke, int duration, int angle, int velocity) {
        super(stroke, duration, angle, velocity);
        Rotation.rotate(crossGroup,0);

        crossGroup = new Group();
//        		<Line endX="-54.0" endY="39.0" layoutX="159.0" layoutY="64.0" startX="-17.0" startY="-2.0" stroke="#1750e1" strokeLineCap="ROUND" strokeWidth="12.0" />
//		<Line endX="-150.0" endY="32.0" layoutX="204.0" layoutY="124.0" startX="-110.70709228515625" startY="-10.70709228515625" stroke="#49b244" strokeLineCap="ROUND" strokeWidth="12.0" />
//		<Line endX="-54.0" endY="39.0" layoutX="147.0" layoutY="63.0" startX="-100.0" stroke="#d01212" strokeLineCap="ROUND" strokeWidth="12.0" />
//		<Line endX="-54.0" endY="39.0" layoutX="205.0" layoutY="115.0" startX="-100.0" stroke="#e09b19" strokeLineCap="ROUND" strokeWidth="12.0" />
//        Arc( double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
        for (int i = 1; i <= 4; i++) {
            Arc arc = new Arc(150, 150, 75, 75, 90 * i, 90);
            arc.setFill(Color.TRANSPARENT);
            arc.setStroke(Settings.currentTheme[i - 1]);
            arc.setType(ArcType.OPEN);
            arc.setStrokeWidth(12);
            crossGroup.getChildren().add(arc);
        }
        Rotation.rotate(crossGroup,0);
    }

    @Override
    public Group getGroup() {
        return crossGroup;
    }

    @Override
    public void scaleSize(int scale){

    }
}
