package gamecode;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.shape.Line;

import java.util.Random;


public class SquareObstacle extends Obstacle {

    private transient final RotateTransition rotateTransition;
    transient Group squareGroup;

    public SquareObstacle(double posX, double posY, double animationTime, int cycleCount, int scale, boolean scaleAnimate) {
        super(0, 0, 0, 1, 1);

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

        Random ran = new Random();
        int no = ran.nextInt(2);
        int dir = no == 0 ? -1 : 1;
        rotateTransition = GameAnimation.rotate(squareGroup, 0, dir);
        if (scaleAnimate) {
            TranslateTransition transition = GameAnimation.Xtranslation(squareGroup, 0, 4);
        }
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
        return squareGroup;
    }

    @Override
    public void scaleSize(int scale) {

    }

    public RotateTransition getRotation() {
        return rotateTransition;
    }

}
