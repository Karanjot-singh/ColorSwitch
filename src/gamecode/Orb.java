package gamecode;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;

import java.util.Random;

public class Orb extends Elements implements Rotation{
	private int color;
	private String shape;
	private String trail;

	Group orbGroup = new Group();

	Orb() {
		Circle orb = new Circle(300, 560, 10);
		Random ran = new Random();
		int x = ran.nextInt(4);
		orb.setFill(Settings.currentTheme[x]);
		orb.setStrokeType(StrokeType.INSIDE);
		orbGroup.getChildren().add(orb);

		Rotation.rotate(orbGroup,0);
	}

	public Group getOrbGroup() {
		return orbGroup;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
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
			double mid = pos-180;
			double bound = Math.max(mid,ty-40);
			// quadratic interpolation to simulate gravity
			Interpolator interpolator = new Interpolator() {
				@Override
				protected double curve(double t) {
					// t is the fraction of animation completed
					return t * (2 - t); //rate to change animation speed
				}

			};
			Interpolator linear = new Interpolator() {
				@Override
				protected double curve(double t) {
					// t is the fraction of animation completed
					return t ; //rate to change animation speed
				}

			};
			Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,
					new KeyValue(orbGroup.translateYProperty(), ty, interpolator)),
					new KeyFrame(Duration.seconds(0.3),
							new KeyValue(orbGroup.translateYProperty(), bound, interpolator)),
					new KeyFrame(Duration.seconds(0.75),
							new KeyValue(orbGroup.translateYProperty(), pos, linear)));

			timeline.play();
	}
}
