package gamecode;

import java.io.Serializable;

public abstract class Elements implements Serializable {
    public static final long serialVersionUID = 1L;

    protected double posX;
    protected double posY;

    public Elements(double posX, double posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
}
