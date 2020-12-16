package gamecode;

import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;


public class ColorSwitcher extends Elements implements Rotation {
    final int radius = 18;
    ImageView colorSwitcher;

    ColorSwitcher() {
        super();
        colorSwitcher = new ImageView("/assets/switcher.png");
        colorSwitcher.setFitWidth(radius);
        colorSwitcher.setFitHeight(radius);
        colorSwitcher.setPreserveRatio(true);
        colorSwitcher.setPickOnBounds(true);

//		Rotation.rotate(switchGroup, 0);
    }

    //	public Group getSwitchGroup() {
//		return switchGroup;
//	}
    public Circle getSwitchGroup() {
        Circle container = new Circle(radius);
        container.setFill(new ImagePattern(colorSwitcher.getImage()));
        return container;
    }
}
