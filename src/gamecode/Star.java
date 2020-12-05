package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Star extends Elements {
	//TODO Replace image with shape
	ImageView starIcon;

	private int scoreValue;

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
