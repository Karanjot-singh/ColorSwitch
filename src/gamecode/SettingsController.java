package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {

    static Stage window;
    static Scene scene, colorScene;
    @FXML
    Button orbButton, musicButton, backButton, themeButton;
    @FXML
    Label title;

    public static void display() {
        window = new Stage();
        try {
            colorScene = new Scene (FXMLLoader.load(SettingsController.class.getResource("settingsTheme.fxml")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.initOwner(Main.getWindow());
        window.initStyle(StageStyle.TRANSPARENT);
        window.setTitle("Settings Screen");
        window.setMinWidth(250);
        window.setMinHeight(100);
        window.centerOnScreen();

        //Display window and wait for it to be closed before returning
        scene = Main.getSettingsScene();
        window.setScene(scene);
        window.showAndWait();
    }

    @FXML
    void backClicked(MouseEvent mouseEvent) {
        window.close();
    }

    @FXML
    void testClicked(MouseEvent mouseEvent) {

        if(!Game.isTestMode()) {
            Game.setTestMode(true);
            System.out.println("Test ON");
        }
        else{
            Game.setTestMode(false);
            System.out.println("Test OFF");
        }
    }

    @FXML
    void musicClicked(MouseEvent mouseEvent) {
        if(Music.getInstance().isPlaying()){
            Main.pauseMusic();
            musicButton.setText("Play music");
        }
        else {
            Main.playMusic();
            musicButton.setText("Pause music");
        }
    }

    @FXML
    void themeClicked(MouseEvent mouseEvent) {
        window.setScene(colorScene);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
