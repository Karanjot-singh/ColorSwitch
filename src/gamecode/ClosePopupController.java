package gamecode;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClosePopupController {

    static Stage window;
    static Scene scene;
    static Boolean ans = false;
    public Button yesButton, noButton;
    public Label confirmMsg;

    public static Boolean display() {
        window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.initOwner(Main.window);
        window.initStyle(StageStyle.TRANSPARENT);
        window.setTitle("Exit program");
        window.setWidth(270);
        window.setHeight(150);
        window.centerOnScreen();
        window.setResizable(false);

        //Display window and wait for it to be closed before returning
        scene = Main.closePopupScene;
        window.setScene(scene);
        window.showAndWait();

        return ans;
    }

    @FXML
    void yesClicked() {
        ans = true;
        window.close();
    }

    @FXML
    void noClicked() {
        ans = false;
        window.close();
    }

}
