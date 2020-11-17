package sample;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class GameplayController {

    public Button backButton;
    public Label gameMsg;

    public void backClicked()
    {
        Main.window.setScene(Main.homeScene);
    }

    public void msgHover()
    {
        gameMsg.setText("GAME OVER!");
    }


}
