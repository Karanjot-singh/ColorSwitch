package gamecode;

import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Group;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeLineCap;

import java.util.Random;


public class DiamondObstacle extends Obstacle {

    private transient final RotateTransition rotateTransition;
    transient Group triangleGroup;

    public DiamondObstacle(double posX, double posY, double animationTime, int cycleCount, int scale, boolean scaleAnimate) {
        super(0, 0, 0, 1, 1);

        triangleGroup = new Group();
        Line line = new Line(-98, -57, -157, 25);
        line.setStroke(Settings.currentTheme[0]);
        line.setLayoutX(197);
        line.setLayoutY(46);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        triangleGroup.getChildren().add(line);
        line = new Line(-98, -57, -34, 25);
        line.setStroke(Settings.currentTheme[1]);
        line.setLayoutX(197);
        line.setLayoutY(46);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        triangleGroup.getChildren().add(line);
        line = new Line(-98, 97, -157, 25);
        line.setStroke(Settings.currentTheme[2]);
        line.setLayoutX(197);
        line.setLayoutY(46);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        triangleGroup.getChildren().add(line);
        line = new Line(-98, 97, -34, 25);
        line.setStroke(Settings.currentTheme[3]);
        line.setLayoutX(197);
        line.setLayoutY(46);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        triangleGroup.getChildren().add(line);

        Random ran = new Random();
        int no = ran.nextInt(2);
        int dir = no == 0 ? -1 : 1;
        rotateTransition = GameAnimation.rotate(triangleGroup, 0, dir);
        if (scaleAnimate) {
            SequentialTransition transition = GameAnimation.scaleTransition(triangleGroup, 0, 0);
        }
//        GameAnimation.Ytranslation(triangleGroup,0,1);
    }

    @Override
    public void saveObstacle() {

    }

    public void pauseAnimation() {
        rotateTransition.pause();
    }

    public void playAnimation() {
        rotateTransition.play();
    }

    @Override
    public Group getGroup() {
        return triangleGroup;
    }

    @Override
    public void scaleSize(int scale) {

    }

    public RotateTransition getRotation() {
        return rotateTransition;
    }
}
