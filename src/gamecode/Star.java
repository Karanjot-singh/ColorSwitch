package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class Star extends Elements implements FXMLLoading{
	//TODO Replace image with shape
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

	@Override
	public Group getFXML() throws IOException {
		return FXMLLoader.load(Star.class.getResource("star.fxml"));
	}
}
