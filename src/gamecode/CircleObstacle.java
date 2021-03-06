package gamecode;

import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

import java.util.Random;


public class CircleObstacle extends Obstacle {
    private final transient RotateTransition rotateTransition;
    private transient Group arcGroup;

    public CircleObstacle(double posX, double posY, double animationTime, int cycleCount, int scale, boolean scaleAnimate) {
        super(0, 0, 0, 1, 1);

        setArcGroup(new Group());
//        Arc( double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
        for (int i = 1; i <= 4; i++) {
            Arc arc = new Arc(150, 150, 75, 75, 90 * i, 90);
            arc.setFill(Color.TRANSPARENT);
            arc.setStroke(Settings.currentTheme[i - 1]);
            arc.setType(ArcType.OPEN);
            arc.setStrokeWidth(12);
            getArcGroup().getChildren().add(arc);
        }
        Random ran = new Random();
        int no = ran.nextInt(2);
        int dir = no == 0 ? -1 : 1;
        rotateTransition = GameAnimation.rotate(getArcGroup(), 0, dir);
        if (scaleAnimate) {
            SequentialTransition transition = GameAnimation.scaleTransition(getArcGroup(), 0, 0);
        }
    }

    @Override
    public void saveObstacle() {
//        rotateTransition.get
        double a = getRotateTransition().getDuration().toSeconds();
        double b = getRotateTransition().getCurrentTime().toSeconds();
    }

    public RotateTransition getRotation() {
        return getRotateTransition();
    }

    @Override

    public void pauseAnimation() {
        getRotateTransition().pause();
    }

    @Override

    public void playAnimation() {
        getRotateTransition().play();
    }

    @Override
    public Group getGroup() {
        return getArcGroup();
    }

    public RotateTransition getRotateTransition() {
        return rotateTransition;
    }

    public Group getArcGroup() {
        return arcGroup;
    }

    public void setArcGroup(Group arcGroup) {
        this.arcGroup = arcGroup;
    }
}
