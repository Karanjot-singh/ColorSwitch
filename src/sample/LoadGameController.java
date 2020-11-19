package sample;

import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*; //rem


public class LoadGameController {

	static Stage window;
	static Scene scene;

	public Button closeButton;
	public Label loadLabel;

	@FXML
	void closeClicked()
	{
		window.close();
	}

	public static void display() {
		window = new Stage();

		//Block events to other windows
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Load Game Screen");
		window.setMinWidth(250);
		window.setMinHeight(100);

		//Display window and wait for it to be closed before returning
		scene = Main.loadGameScene;
		window.setScene(scene);
		window.showAndWait();
	}
}
