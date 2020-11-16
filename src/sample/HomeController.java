package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeController {

    public Button newGameButton, loadGameButton;
    public Label homeLabel;

    @FXML
    void newGameClicked()
    {
//      coolButton.setText("Hehehe");
        Main.window.setScene(Main.gameplay);
    }

    @FXML
    void loadGameClicked()
    {
//      coolButton.setText("Hehehe");
        loadGameController.display("Load Game Screen", "You have no saved games.");

    }

    @FXML
    void textHover()
    {
        homeLabel.setText("WELCOME TO COLOR SWITCH!");
    }


}
