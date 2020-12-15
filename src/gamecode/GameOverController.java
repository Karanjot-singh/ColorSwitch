package gamecode;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GameOverController {

		static Stage window;
		static Scene scene;

		@FXML
		Label pauseMsg;
		@FXML
		ImageView backIcon, replayIcon;

		@FXML
		void replayClicked(MouseEvent mouseEvent)
		{
			
			Main.startNewGame();
			Main.window.setScene(Main.gameplayScene);
			window.close();
		}

		@FXML
		void saveClicked(MouseEvent mouseEvent)
		{
			Main.window.setScene(Main.homeScene);
			window.close();
		}

		@FXML
		void backClicked(MouseEvent mouseEvent)
		{
			Main.window.setScene(Main.homeScene);
			window.close();
		}

		public static void display() {
			window = new Stage();

			//Block events to other windows
			window.initModality(Modality.APPLICATION_MODAL);
			window.initStyle(StageStyle.TRANSPARENT);
			window.initOwner(Main.window);
			window.setTitle("Pause game");
			window.setWidth(350);
			window.setHeight(300);
			window.centerOnScreen();

			//Display window and wait for it to be closed before returning
			scene = Main.gameOverScene;
			window.setScene(scene);
			window.show();
//			window.showAndWait();
		}

}
