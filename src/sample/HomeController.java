package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeController {

    public Button coolButton;
    public Label homeLabel;

    public void clicked()
    {
//        coolButton.setText("Hehehe");
        Main.window.setScene(Main.gameplay);
    }

    public void textHover()
    {
        homeLabel.setText("WELCOME TO HOMESCREEN");
    }


}
