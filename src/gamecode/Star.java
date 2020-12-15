package gamecode;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


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

    public Rectangle getStarShape() {
//        Rectangle(double x, double y, double width, double height)
        Rectangle container = new Rectangle();
        container.setWidth(40);
        container.setHeight(40);
        container.setFill(new ImagePattern(starIcon.getImage()));
//        container.setStroke(Color.WHITE);
//        container.setStrokeWidth(5);
        return container;
    }

//    public ImageView getStarIcon() {
//        return starIcon;
//    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    void explodeAnimation() {

    }

}
