package sample;

import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;


public class CircleObstacle extends Obstacle {
	int stroke;
	int duration;
	int angle;
	int velocity;

	public Group circleGroup;
	@FXML
	static Pane circlePane;
	static HBox test1 = new HBox();
	boolean direction;
	public CircleObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
		super(currentTheme, stroke, duration, angle, velocity);
//		Node temp = circleGroup.getChildren().get(1);
//		Arc tempArc = (Arc) temp;
//		tempArc.setStroke();
		Arc arc1 = new Arc(100, 100, 100, 100, 90, 100);
				arc1.setType(ArcType.OPEN);
				arc1.setStroke(Color.BLUE);
				arc1.setStrokeWidth(10);
				arc1.setFill(Color.TRANSPARENT);
        arc1.setStrokeWidth(stroke);
		test1.getChildren().addAll(circleGroup);

		rotate1(test1);

	}
	public void rotate1(Node selectedGroup) {
		RotateTransition rotation = new RotateTransition(Duration.seconds(duration),selectedGroup);

		rotation.setAutoReverse(direction);
		rotation.setNode(selectedGroup);
		rotation.setCycleCount(500);
		rotation.setAxis(Rotate.Z_AXIS);
		rotation.setByAngle(angle);
		rotation.setRate(3);

		rotation.setDuration(Duration.millis(2000));
		rotation.setInterpolator(Interpolator.LINEAR);
		rotation.setCycleCount(500);
		rotation.play();

	}
}


//        Arc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
//		arc1 = new Arc(100, 100, 100, 100, 90, 100);
//				arc1.setType(ArcType.OPEN);
//				arc1.setStroke(Color.BLUE);
//				arc1.setStrokeWidth(10);
//				arc1.setFill(Color.TRANSPARENT);
////        arc1.setStrokeWidth(stroke);
////        Game.playRegion.getChildren().addAll(arc1);