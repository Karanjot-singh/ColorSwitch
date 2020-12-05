package gamecode;

import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;

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

	void jump() {

	}
}
