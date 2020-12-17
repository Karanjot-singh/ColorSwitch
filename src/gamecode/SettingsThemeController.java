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

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsThemeController extends SettingsController implements Initializable {

    @FXML
    Button  backButton, theme1Button, theme2Button;
    @FXML
    Label title;

    @FXML
    void backClicked(MouseEvent mouseEvent) {
        window.setScene(scene);
    }

    @FXML
    void oneClicked(){
        Settings.changeTheme(1);
    }

    @FXML
    void twoClicked(){
        Settings.changeTheme(2);
    }
}
