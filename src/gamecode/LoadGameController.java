package gamecode;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.IOException;


public class LoadGameController {

//	static Stage window;
//	static Scene scene;

    public Button backButton, load;
    public Label loadLabel;

    @FXML
    void backClicked() {
        Main.getWindow().setScene(Main.getHomeScene());
    }

    @FXML
    void loadClicked() {
        try {
            Database.deserialize();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Main.startLoadedGame();
        Main.getWindow().setScene(Main.getGameplayScene());
    }

//	public static void display() {
//		window = new Stage();
//
//		//Block events to other windows
//		window.initModality(Modality.APPLICATION_MODAL);
//		window.setTitle("Load Game Screen");
//		window.setMinWidth(250);
//		window.setMinHeight(100);
//
//		//Display window and wait for it to be closed before returning
//		scene = Main.loadGameScene;
//		window.setScene(scene);
//		window.showAndWait();
//	}
}
