package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeController {

    public Button newGameButton, loadGameButton;
    public Label homeLabel;


    @FXML
    void textHover()
    {
        homeLabel.setText("WELCOME TO COLOR SWITCH!");
    }

    @FXML
    void newGameClicked()
    {
//      coolButton.setText("Hehehe");
        Main.window.setScene(Main.gameplayScene);
    }

    @FXML
    void loadGameClicked()
    {
//      coolButton.setText("Hehehe");
        loadGameController.display();
//        Main.window.setScene
    }


}
