package gamecode;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController {
    @FXML
    Button newGameButton, loadGameButton, exitButton;

    @FXML
    ImageView titleLogo, helpIcon, settingsIcon, userIcon;

    @FXML
    void newGameClicked() {
        Main.startNewGame();
        Main.getWindow().setScene(Main.getGameplayScene());
    }

    @FXML
    void loadGameClicked() throws IOException, ClassNotFoundException {
//        LoadGameController.display();

        Main.getWindow().setScene(Main.getLoadGameScene());
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
    void userClicked() {
        try {
            Main.setPlayerInfoScene(new Scene(FXMLLoader.load(getClass().getResource("playerInfo.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        PlayerInfoController.display();
    }
}
