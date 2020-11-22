package sample;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PausePopupController {

		static Stage window;
		static Scene scene;

		public Button resumeButton, saveButton, quitButton;
		public Label pauseMsg;

		static Boolean ans = false;

		@FXML
		void resumeClicked()
		{
			window.close();
		}

		@FXML
		void saveClicked()
		{
			Main.window.setScene(Main.homeScene);
			window.close();
		}

		@FXML
		void quitClicked()
		{
			Main.window.setScene(Main.homeScene);
			window.close();
		}

		public static Boolean display() {
			window = new Stage();

			//Block events to other windows
			window.initModality(Modality.APPLICATION_MODAL);
			window.initOwner(Main.window);
			window.setTitle("Pause game");
			window.setWidth(350);
			window.setHeight(300);
			window.centerOnScreen();

			//Display window and wait for it to be closed before returning
			scene = Main.pausePopupScene;
			window.setScene(scene);
			window.showAndWait();

			return ans;
		}

}
