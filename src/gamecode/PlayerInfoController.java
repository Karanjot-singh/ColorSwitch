package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayerInfoController implements Initializable {

    static Stage window;
    static Scene scene;
    @FXML
    Button backButton;
    @FXML
    Label title, nameMsg, name, starsMsg, stars, highscoreMsg, highscore;

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
        scene = Main.playerInfoScene;
        window.setScene(scene);
        window.showAndWait();
    }

    @FXML
    void backClicked(MouseEvent mouseEvent) {
        window.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(Main.player.getName());
        stars.setText(Main.player.getTotalStars() + "");
        highscore.setText(Main.player.getHighscore() + "");
    }
}
