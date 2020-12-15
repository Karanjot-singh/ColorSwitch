package gamecode;

import javafx.scene.image.ImageView;


public class Star extends Elements {
	ImageView starIcon;

	private int scoreValue;

	//TODO Specify height and width for star image
//	<ImageView fitHeight="40.0" fitWidth="40.0" layoutX="280.0" layoutY="70.0" pickOnBounds="true" preserveRatio="true" GridPane.columnIndex="1" GridPane.halignment="CENTER" GridPane.rowIndex="1" GridPane.valignment="CENTER">
//		         <image>
//		            <Image url="@../assets/starIcon.png" />
//		         </image>
//  </ImageView>
	Star() {
		starIcon = new ImageView("/assets/starIcon.png");
		starIcon.setFitWidth(40);
		starIcon.setFitHeight(40);
		starIcon.setPreserveRatio(true);
		starIcon.setPickOnBounds(true);
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

	void explodeAnimation() {

	}

}
