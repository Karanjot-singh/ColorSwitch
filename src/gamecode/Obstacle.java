package gamecode;


import javafx.animation.RotateTransition;
import javafx.scene.Group;

import java.io.Serializable;

public abstract class Obstacle extends Elements implements Serializable {
    public static final long serialVersionUID = 1L;
    double posX,posY,animationTime,animationDuration;
    private String name;
    int scale;

    public Obstacle(double posX, double posY, double animationTime, double animationDuration, int scale) {
        super(posX,posY);
        this.animationTime=animationTime;
        this.animationDuration= animationDuration;
        this.scale= scale;
    }

    public abstract void saveObstacle();

    public abstract void pauseAnimation();

    public abstract void playAnimation();

    abstract public Group getGroup();

    public void scaleSize(int scale) {

    }
    public RotateTransition getRotation(){
        return new RotateTransition();
    }

    public boolean checkCross() {
        return false;
    }

    @Override
    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    @Override
    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getAnimationTime() {
        return animationTime;
    }

    public void setAnimationTime(double animationTime) {
        this.animationTime = animationTime;
    }
    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public double getAnimationDuration() {
        return animationDuration;
    }

    public void setAnimationDuration(double animationDuration) {
        this.animationDuration = animationDuration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
