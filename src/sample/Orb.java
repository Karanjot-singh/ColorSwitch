package sample;

import javafx.scene.Node;

public class Orb implements Rotation{
	private int color;
	private String shape;

	@Override
	public void rotate(Node selectedGroup) {

	}

	private String trail;

	Orb() {

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
