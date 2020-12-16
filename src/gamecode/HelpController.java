package gamecode;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class HelpController {
    static Stage window;
    static Scene scene;

    public static void display() {
        window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.initOwner(Main.window);
        window.setTitle("Help Screen");
        window.setMinWidth(250);
        window.setMinHeight(100);
        window.centerOnScreen();

        //Display window and wait for it to be closed before returning
        scene = Main.helpScene;
        window.setScene(scene);
        window.showAndWait();
    }

    public void backClicked(ActionEvent actionEvent) {
        window.close();
    }
}
