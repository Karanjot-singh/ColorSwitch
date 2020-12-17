package gamecode;


import javafx.scene.Group;

import java.io.Serializable;

public abstract class Obstacle extends Elements implements Serializable {
    public static final long serialVersionUID = 1L;
    double posX,posY,animationTime;
    int cycleCount,scale;

    public Obstacle(double posX, double posY, double animationTime, int cycleCount, int scale) {
        super(posX,posY);
        this.animationTime=animationTime;
        this.cycleCount=cycleCount;
        this.scale= scale;
    }

    public abstract void saveObstacle();

    public abstract void pauseAnimation();

    public abstract void playAnimation();

    abstract public Group getGroup();

    public void scaleSize(int scale) {

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

    public int getCycleCount() {
        return cycleCount;
    }

    public void setCycleCount(int cycleCount) {
        this.cycleCount = cycleCount;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }
}
