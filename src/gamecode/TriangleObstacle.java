package gamecode;

import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;


public class TriangleObstacle extends Obstacle {

    Group triangleGroup;
    private final RotateTransition rotateTransition;

    //    		<Line endX="32.0" endY="54.0" layoutX="122.0" layoutY="29.0" startX="-23.0" startY="-6.0" stroke="#1750e1" strokeLineCap="ROUND" strokeWidth="12.0" />
//		<Line endX="-150.0" endY="32.0" layoutX="201.0" layoutY="55.0" startX="-102.0" startY="-32.0" stroke="#49b244" strokeLineCap="ROUND" strokeWidth="12.0" />
//		<Line endX="-44.0" endY="62.0" layoutX="151.0" layoutY="89.0" startX="-100.0" stroke="#d01212" strokeLineCap="ROUND" strokeWidth="12.0" />
//		<Line endX="-92.0" endY="42.0" layoutX="205.0" layoutY="115.0" startX="-45.0" startY="-26.0" stroke="#e09b19" strokeLineCap="ROUND" strokeWidth="12.0" />
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

        rotateTransition=Rotation.rotate(triangleGroup,0);
    }
    public void pauseAnimation(){
        rotateTransition.pause();
    }
    public void playAnimation(){
        rotateTransition.play();
    }
    @Override
    public Group getGroup() {
        return triangleGroup;
    }

    @Override
    public void scaleSize(int scale){

    }
}
