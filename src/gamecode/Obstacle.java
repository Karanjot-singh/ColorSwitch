package gamecode;


import javafx.scene.Group;

public abstract class Obstacle extends Elements{
    private int stroke;
    private int duration;
    private int angle;
    private int velocity;

    public Obstacle(int stroke, int duration, int angle, int velocity) {
        this.setStroke(stroke);
        this.setDuration(duration);
        this.setAngle(angle);
        this.setVelocity(velocity);
    }

    public void pauseAnimation() {
    }

    public void playAnimation() {

    }

    abstract public Group getGroup();

    public void scaleSize(int scale) {

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
}
