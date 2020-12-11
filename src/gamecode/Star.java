package gamecode;

import javafx.scene.image.ImageView;


public class Star extends Elements {
	ImageView starIcon;

	private int scoreValue;

	//TODO Specify height and width for star image
	Star(){
		starIcon = new ImageView("/assets/starIcon.png");
	}

	public int getScoreValue() {
		return scoreValue;
	}

	public ImageView getStarIcon() {
		return starIcon;
	}

	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

	void explodeAnimation(){

	}

}
