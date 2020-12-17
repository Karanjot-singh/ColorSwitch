package gamecode;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.EventListener;

public class PausePopupController {

    static Stage window;
    static Scene scene;

    @FXML
    VBox vbox;
    @FXML
    Button resumeButton, saveButton, quitButton;
    @FXML
    Label pauseMsg;

    public static void display() {
        window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.initOwner(Main.getWindow());
        window.initStyle(StageStyle.TRANSPARENT);
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
        Main.getCurrentGame().setPaused(false);
        Main.getCurrentGame().setOrbDead(false);
        Main.getCurrentGame().playGame();
        window.close();
    }

    @FXML
    void saveClicked(MouseEvent mouseEvent) {
        Label label = new Label("Game saved successfully!");
        vbox.getChildren().remove(saveButton);
        label.setStyle("-fx-text-fill: #37b884; ");
        vbox.getChildren().add(label);
//        Popup popup = new Popup();
//        popup.getContent().add(label);
//        popup.setHideOnEscape(true);
//        popup.setX();
//        popup.setY(0);
//        popup.setAutoHide(true);
//        label.setStyle("-fx-text-fill: #37b884; " +
//                "-fx-font-family:\"Ubuntu Light\";" +
//                "-fx-background-color: #1a1a1a");
////        alert.styltylesheets("@/stylesheets/generalStyle.css");
//        if (!popup.isShowing())
//            popup.show(window);

//        Main.getWindow().setScene(Main.getHomeScene());
//        window.close();
    }

    @FXML
    void quitClicked(MouseEvent mouseEvent) {
        Main.getWindow().setScene(Main.getHomeScene());
        window.close();
    }

}
