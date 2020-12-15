package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController implements Initializable{

		static Stage window;
		static Scene scene;

		@FXML
		Label gameOverMsg, scoreMsg, highscoreMsg, score, highscore;

		@FXML
		ImageView backIcon, replayIcon;

		@FXML
		Button backButton, replayButton;

		@FXML
		void replayClicked(MouseEvent mouseEvent)
		{
			Main.startNewGame();
			Main.window.setScene(Main.gameplayScene);
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
			window.setTitle("Game Over");
			window.setWidth(350);
			window.setHeight(300);
			window.centerOnScreen();


			//Display window and wait for it to be closed before returning
			scene = Main.gameOverScene;
			window.setScene(scene);
			window.show();
//			window.showAndWait();
		}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		score.setText(Main.currentGame.getScore() +"");
		highscore.setText(Main.player.getHighscore() + "");

	}
}
