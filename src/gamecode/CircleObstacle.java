package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CircleObstacle implements Initializable, Rotation {

	@FXML
	Arc arc11,arc12,arc13,arc14;
	@FXML
	Group arcGrp1;

//	public CircleObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
//		super(currentTheme, stroke, duration, angle, velocity);
//	}

	public static Group get() throws IOException {
		return FXMLLoader.load(CircleObstacle.class.getResource("circleObstacle.fxml"));
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		arc11.setFill(Color.TRANSPARENT);
		arc12.setFill(Color.TRANSPARENT);
		arc13.setFill(Color.TRANSPARENT);
		arc14.setFill(Color.TRANSPARENT);

		Rotation.rotate(arcGrp1,0);
	}

}


//	int stroke;
//	int duration;
//	int angle;
//	int velocity;
//
//	public Group circleGroup;
//	@FXML
//	static Pane circlePane;
//	static HBox test1 = new HBox();
//	boolean direction;
//	public CircleObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
//		super(currentTheme, stroke, duration, angle, velocity);
////		Node temp = circleGroup.getChildren().get(1);
////		Arc tempArc = (Arc) temp;
////		tempArc.setStroke();
//		Arc arc1 = new Arc(100, 100, 100, 100, 90, 100);
//		arc1.setType(ArcType.OPEN);
//		arc1.setStroke(Color.BLUE);
//		arc1.setStrokeWidth(10);
//		arc1.setFill(Color.TRANSPARENT);
//		arc1.setStrokeWidth(stroke);
//		test1.getChildren().addAll(circleGroup);
//
//		rotate1(test1);
//
//	}
//	public void rotate1(Node selectedGroup) {
//		RotateTransition rotation = new RotateTransition(Duration.seconds(duration),selectedGroup);
//
//		rotation.setAutoReverse(direction);
//		rotation.setNode(selectedGroup);
//		rotation.setCycleCount(500);
//		rotation.setAxis(Rotate.Z_AXIS);
//		rotation.setByAngle(angle);
//		rotation.setRate(3);
//
//		rotation.setDuration(Duration.millis(2000));
//		rotation.setInterpolator(Interpolator.LINEAR);
//		rotation.setCycleCount(500);
//		rotation.play();
//
//	}



//        Arc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
//		arc1 = new Arc(100, 100, 100, 100, 90, 100);
//				arc1.setType(ArcType.OPEN);
//				arc1.setStroke(Color.BLUE);
//				arc1.setStrokeWidth(10);
//				arc1.setFill(Color.TRANSPARENT);
////        arc1.setStrokeWidth(stroke);
////        Game.playRegion.getChildren().addAll(arc1);

//package sample;
//
//import javafx.scene.paint.Color;
//import javafx.scene.shape.Arc;
//import javafx.scene.shape.ArcType;
//
//
//public class CircleObstacle extends Obstacle {
//	Arc arc1, arc2, arc3, arc4;
//
//	public CircleObstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
//		super(currentTheme, stroke, duration, angle, velocity);
////        Arc(double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
//		arc1 = new Arc(100, 100, 100, 100, 90, 100);
//		arc1.setType(ArcType.OPEN);
//		arc1.setStroke(Color.BLUE);
//		arc1.setStrokeWidth(10);
//		arc1.setFill(Color.TRANSPARENT);
////        arc1.setStrokeWidth(stroke);
////        Game.playRegion.getChildren().addAll(arc1);
//	}
//}
