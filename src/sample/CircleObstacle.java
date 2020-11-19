package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;


public class CircleObstacle extends Obstacle {
	Arc arc1, arc2, arc3, arc4;

	public CircleObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
		super(currentTheme, stroke, duration, angle, velocity);
//        Arc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
		arc1 = new Arc(100, 100, 100, 100, 90, 100);
		arc1.setType(ArcType.OPEN);
		arc1.setStroke(Color.BLUE);
		arc1.setStrokeWidth(10);
		arc1.setFill(Color.TRANSPARENT);
//        arc1.setStrokeWidth(stroke);
//        Game.playRegion.getChildren().addAll(arc1);
	}
}
