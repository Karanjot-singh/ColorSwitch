package gamecode;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController implements Initializable {

    static Stage window;
    static Scene scene;

    @FXML
    VBox vbox;

    @FXML
    Label gameOverMsg, scoreMsg, highscoreMsg, score, highscore;

    @FXML
    ImageView backIcon, replayIcon;

    @FXML
    Button backButton, replayButton, reviveButton;

    public static void display() {
        window = new Stage();

        //Block events to other windows
        window.initModality(Modality.APPLICATION_MODAL);
        window.initStyle(StageStyle.TRANSPARENT);
        window.initOwner(Main.window);
        window.setTitle("Game Over");
        window.setWidth(350);
        window.setHeight(250);
        window.centerOnScreen();


        //Display window and wait for it to be closed before returning
        scene = Main.gameOverScene;
        window.setScene(scene);
        window.show();
//			window.showAndWait();
    }

    @FXML
    void replayClicked(MouseEvent mouseEvent) {
        Main.startNewGame();
        Main.window.setScene(Main.gameplayScene);
        window.close();
    }

    @FXML
    void backClicked(MouseEvent mouseEvent) {
        Main.window.setScene(Main.homeScene);
        window.close();
    }

    @FXML
    void reviveClicked(MouseEvent mouseEvent) {
        try {
            Main.currentGame.revive();
            window.close();
        } catch (InsufficientStarsException e) {
            e.getMessage();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        score.setText(Main.currentGame.getScore() + "");
        highscore.setText(Main.player.getHighscore() + "");
        reviveButton.setText("Revive     " + (char) 9734 + "5");

        if (Main.currentGame.isRevived()) {
            vbox.getChildren().remove(reviveButton);
//			reviveButton.setVisible(false);
        }
    }
}
