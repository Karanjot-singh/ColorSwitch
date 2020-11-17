package sample;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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
