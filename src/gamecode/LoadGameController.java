package gamecode;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class LoadGameController {

//	static Stage window;
//	static Scene scene;

	public Button backButton;
	public Label loadLabel;

	@FXML
	void backClicked() {
		Main.window.setScene(Main.homeScene);
	}

//	public static void display() {
//		window = new Stage();
//
//		//Block events to other windows
//		window.initModality(Modality.APPLICATION_MODAL);
//		window.setTitle("Load Game Screen");
//		window.setMinWidth(250);
//		window.setMinHeight(100);
//
//		//Display window and wait for it to be closed before returning
//		scene = Main.loadGameScene;
//		window.setScene(scene);
//		window.showAndWait();
//	}
}
