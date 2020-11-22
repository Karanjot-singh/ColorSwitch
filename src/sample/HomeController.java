package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class HomeController {

    @FXML
    Button newGameButton, loadGameButton, exitButton;

    @FXML
    ImageView titleLogo, helpIcon, settingsIcon;

    @FXML
    void newGameClicked() {
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

}
