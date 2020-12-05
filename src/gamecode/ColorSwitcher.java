package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ColorSwitcher extends Elements implements Rotation {

	Group switchGroup;

	ColorSwitcher() {
		super();

		switchGroup = new Group();
//        Arc( double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
		for (int i = 1; i <= 4; i++) {
			Arc arc = new Arc(150, 150, 10, 10, 90 * i, 90);
			arc.setFill(Settings.currentTheme[i - 1]);
			arc.setStroke(Settings.currentTheme[i - 1]);
			arc.setType(ArcType.ROUND);
			switchGroup.getChildren().add(arc);
		}

		Rotation.rotate(switchGroup, 0);
	}

	public void switchColor() {

	}

	public Group getSwitchGroup() {
		return switchGroup;
	}
}
