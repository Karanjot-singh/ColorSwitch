package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class HomeController {
    @FXML
    Button newGameButton, loadGameButton, exitButton;

    @FXML
    ImageView titleLogo, helpIcon, settingsIcon, userIcon;

    @FXML
    void newGameClicked() {
		Main.startNewGame();
		Main.window.setScene(Main.gameplayScene);
    }

    @FXML
    void loadGameClicked() {
//        LoadGameController.display();
        Main.window.setScene(Main.loadGameScene);
    }

    @FXML
    void exitClicked() {
        Main.closeProgram();
    }

	@FXML
	void settingsClicked() {
		SettingsController.display();
    }

	@FXML
	void helpClicked() {
		HelpController.display();
    }

	@FXML
	void userClicked(){
		try {
			Main.playerInfoScene = new Scene(FXMLLoader.load(getClass().getResource("playerInfo.fxml")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		PlayerInfoController.display();
	}

}
