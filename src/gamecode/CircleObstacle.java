package gamecode;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;


public class CircleObstacle extends Obstacle {

	Group arcGroup;

	public CircleObstacle(int stroke, int duration, int angle, int velocity) {
		super(stroke, duration, angle, velocity);

		arcGroup = new Group();
//        Arc( double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
		for (int i = 1; i <= 4; i++) {
			Arc arc = new Arc(150, 150, 75, 75, 90 * i, 90);
			arc.setFill(Color.TRANSPARENT);
			arc.setStroke(Settings.currentTheme[i - 1]);
			arc.setType(ArcType.OPEN);
			arc.setStrokeWidth(12);
			arcGroup.getChildren().add(arc);
		}
		Rotation.rotate(arcGroup,0);
	}

	@Override
	public Group getGroup() {
		return arcGroup;
	}
}
