package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Star {
	@FXML
	ImageView starIcon;

	private int scoreValue;

//	Star(){
//
//	}

	public int getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

	void explodeAnimation(){

	}

	public static ImageView get() throws IOException {
		return FXMLLoader.load(Star.class.getResource("star.fxml"));
	}
}
