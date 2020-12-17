package gamecode;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

import java.util.Random;

public class Orb extends Elements implements GameAnimation {
    private final RotateTransition rotateTransition;
    Group orbGroup = new Group();
    Circle orb;
    private Color color;
    private String shape;
    private String trail;
    private Timeline timeline;

    Orb() {
        orb = new Circle(300, 560, 10);
        Random ran = new Random();
        int x = ran.nextInt(4);
        orb.setFill(Settings.currentTheme[x]);
        orb.setStroke(Settings.currentTheme[x]);
        orb.setStrokeType(StrokeType.INSIDE);
        orbGroup.getChildren().add(orb);
        timeline = new Timeline();
        rotateTransition = GameAnimation.rotate(orbGroup, 0);
    }

    public Group getOrbGroup() {
        return orbGroup;
    }

    public Color getColor() {
        return Color.web(String.valueOf(orb.getFill()));
    }

    public void switchColor() {
        Color[] currentTheme = Settings.currentTheme;
        Random ran = new Random();
        int index = ran.nextInt(4);
        Color newColor = currentTheme[index];
        orb.setFill(newColor);
        orb.setStroke(newColor);

    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getTrail() {
        return trail;
    }

    public void setTrail(String trail) {
        this.trail = trail;
    }

    void explodeAnimation() {

    }

    void jump(double pos) {

        double ty = orbGroup.getTranslateY();
        double mid = -100;
//			double bound = Math.max(mid,ty-40);
        double bound = (ty - 25) < -100 ? mid : ty - 25;
        // quadratic interpolation to simulate gravity
        Interpolator interpolator = new Interpolator() {
            @Override
            protected double curve(double t) {
                // t is the fraction of animation completed
                return t * (2 - t);
//                return (t>0.8? -t * (2 - t) : t);
                //rate to change animation speed
            }

        };
        Interpolator linear = new Interpolator() {
            @Override
            protected double curve(double t) {
                // t is the fraction of animation completed
                return t; //rate to change animation speed
            }

        };
        Interpolator end = new Interpolator() {
            @Override
            protected double curve(double t) {
                // t is the fraction of animation completed
                return t * 1.3; //rate to change animation speed
            }

        };


//			System.out.println("ty=" + ty + " bound=" + bound + " pos="+ pos + " mid=" +mid);

        timeline = new Timeline(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(orbGroup.translateYProperty(), ty, interpolator)),
                new KeyFrame(Duration.seconds(0.4),
                        new KeyValue(orbGroup.translateYProperty(), bound, interpolator)),
//                new KeyFrame(Duration.seconds(0.75),
//                        new KeyValue(orbGroup.translateYProperty(), orbGroup.getTranslateY(), linear)),
                new KeyFrame(Duration.seconds(1.5),
                        new KeyValue(orbGroup.translateYProperty(), 200, end)));

        timeline.play();
    }

    public void pauseAnimation() {
        timeline.pause();
        rotateTransition.pause();
    }

    public void playAnimation() {
        timeline.play();
        rotateTransition.play();
    }
}
