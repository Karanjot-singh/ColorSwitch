package gamecode;

import javafx.scene.Group;
import javafx.scene.shape.Line;


public class SquareObstacle extends Obstacle {

    Group squareGroup;

    public SquareObstacle(int stroke, int duration, int angle, int velocity) {
        super(stroke, duration, angle, velocity);

//        Line(double startX, double startY, double endX, double endY)
        squareGroup = new Group();
        Line line = new Line(-100, 0, 25, 0);
        line.setStroke(Settings.currentTheme[0]);
        line.setLayoutX(337);
        line.setLayoutY(308);
        line.setStrokeWidth(12);
        squareGroup.getChildren().add(line);
        line = new Line(-100, 0, 25, 0);
        line.setStroke(Settings.currentTheme[1]);
        line.setLayoutX(337);
        line.setLayoutY(428);
        line.setStrokeWidth(12);
        squareGroup.getChildren().add(line);
        line = new Line(-116, -10, -116, 110);
        line.setStroke(Settings.currentTheme[2]);
        line.setLayoutX(347);
        line.setLayoutY(318);
        line.setStrokeWidth(12);
        squareGroup.getChildren().add(line);
        line = new Line(-116, -10, -116, 110);
        line.setStroke(Settings.currentTheme[3]);
        line.setLayoutX(484);
        line.setLayoutY(318);
        line.setStrokeWidth(12);
        squareGroup.getChildren().add(line);

        Rotation.rotate(squareGroup,0);
    }

    public Group getSquareGroup() {
        return squareGroup;
    }

    @Override
    public void scaleSize(int scale){

    }

}
