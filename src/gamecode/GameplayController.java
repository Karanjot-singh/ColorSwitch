package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameplayController implements Initializable {

    @FXML
    GridPane grid;

    @FXML
    ImageView pauseIcon;

    @FXML
    Label scoreLabel;

    @FXML
    void pauseClicked(MouseEvent mouseEvent) {
        Main.getCurrentGame().setPaused(true);
        Main.getCurrentGame().pauseGame();
        PausePopupController.display();
    }

    @FXML
    void backClicked(MouseEvent mouseEvent) {
        Main.getWindow().setScene(Main.getHomeScene());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
