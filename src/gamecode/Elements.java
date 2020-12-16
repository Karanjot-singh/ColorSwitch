package gamecode;

import java.io.Serializable;

public abstract class Elements implements Serializable {
	protected int posX;
	protected int posY;

	Elements(){}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	void moveDown()
	{

	}
}
