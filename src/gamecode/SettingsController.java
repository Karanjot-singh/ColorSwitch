package gamecode;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SettingsController {

	@FXML
	Button orbButton, trailButton, backButton, themeButton;

	@FXML
	Label title;

	static Stage window;
	static Scene scene;

	@FXML
	void backClicked(MouseEvent mouseEvent) {
		window.close();
	}

	public static void display() {
		window = new Stage();

		//Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.initOwner(Main.window);
		window.setTitle("Settings Screen");
		window.setMinWidth(250);
		window.setMinHeight(100);
		window.centerOnScreen();

		//Display window and wait for it to be closed before returning
		scene = Main.settingsScene;
		window.setScene(scene);
		window.showAndWait();
	}
}
