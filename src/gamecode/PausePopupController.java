package gamecode;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PausePopupController {

    static Stage window;
    static Scene scene;

    public Button resumeButton, saveButton, quitButton;
    public Label pauseMsg;

    public static void display() {
        window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.initOwner(Main.getWindow());
        window.setTitle("Pause game");
        window.setWidth(350);
        window.setHeight(300);
        window.centerOnScreen();

        //Display window and wait for it to be closed before returning
        scene = Main.getPausePopupScene();
        window.setScene(scene);
        window.showAndWait();
    }

    @FXML
    void resumeClicked(MouseEvent mouseEvent) {
        Main.getCurrentGame().playGame();
        window.close();
    }

    @FXML
    void saveClicked(MouseEvent mouseEvent) {
        Main.getWindow().setScene(Main.getHomeScene());
        window.close();
    }

    @FXML
    void quitClicked(MouseEvent mouseEvent) {
        Main.getWindow().setScene(Main.getHomeScene());
        window.close();
    }

}
