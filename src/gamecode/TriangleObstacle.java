package gamecode;

import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;


public class TriangleObstacle extends Obstacle {

    Group triangleGroup;

    public TriangleObstacle(int stroke, int duration, int angle, int velocity) {
        super(stroke, duration, angle, velocity);

        triangleGroup = new Group();
        Line line = new Line(-105, 0, 25, 0);
        line.setStroke(Settings.currentTheme[0]);
        line.setLayoutX(152);
        line.setLayoutY(250);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        triangleGroup.getChildren().add(line);
        line = new Line(-108, 1, -28, -142);
        line.setStroke(Settings.currentTheme[1]);
        line.setLayoutX(154);
        line.setLayoutY(250);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        triangleGroup.getChildren().add(line);
        line = new Line(44, -9, -38, -152);
        line.setStroke(Settings.currentTheme[3]);
        line.setLayoutX(164);
        line.setLayoutY(259);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        triangleGroup.getChildren().add(line);

        Rotation.rotate(triangleGroup,0);
    }

    @Override
    public void scaleSize(int scale){

    }
}
