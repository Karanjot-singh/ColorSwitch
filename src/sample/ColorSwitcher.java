package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ColorSwitcher implements Initializable, Rotation {

	@FXML
	Group switchGroup;

	private Color[] currentTheme;

//	ColorSwitcher(){
//
//	}

	public void switchColor()
	{

	}

	public static Group get() throws IOException {
		return FXMLLoader.load(ColorSwitcher.class.getResource("colorSwitcher.fxml"));
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		Rotation.rotate(switchGroup,0);
	}
}
