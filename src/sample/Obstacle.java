package sample;

import javafx.scene.Node;
import javafx.scene.paint.Color;

public class Obstacle implements Rotation {
	private Color[] currentTheme ={Color.BLUE,Color.YELLOW, Color.RED, Color.GREEN};
	private int stroke;
	private int duration;
	private int angle;
	private int velocity;

	public Obstacle(Color[] currentTheme, int stroke, int duration, int angle, int velocity) {
		this.setCurrentTheme(currentTheme);
		this.setStroke(stroke);
		this.setDuration(duration);
		this.setAngle(angle);
		this.setVelocity(velocity);
	}
	public void scaleSize(int scale){

	}
	public Color[] getCurrentTheme() {
		return currentTheme;
	}

	public void setCurrentTheme(Color[] currentTheme) {
		this.currentTheme = currentTheme;
	}

	public int getStroke() {
		return stroke;
	}

	public void setStroke(int stroke) {
		this.stroke = stroke;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getAngle() {
		return angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	@Override
	public void rotate(Node selectedGroup) {

	}
}
