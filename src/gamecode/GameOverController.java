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
        window.initOwner(Main.getWindow());
        window.setTitle("Game Over");
        window.setWidth(350);
        window.setHeight(250);
        window.centerOnScreen();


        //Display window and wait for it to be closed before returning
        scene = Main.getGameOverScene();
        window.setScene(scene);
        window.show();
//			window.showAndWait();
    }

    @FXML
    void replayClicked(MouseEvent mouseEvent) {
        Main.startNewGame();
        Main.getWindow().setScene(Main.getGameplayScene());
        window.close();
    }

    @FXML
    void backClicked(MouseEvent mouseEvent) {
        Main.getWindow().setScene(Main.getHomeScene());
        window.close();
    }

    @FXML
    void reviveClicked(MouseEvent mouseEvent) {
        try {
            Main.getCurrentGame().revive();
            window.close();
        } catch (InsufficientStarsException e) {
            Label label = new Label(e.getMessage());
            if(vbox.getChildren().get(vbox.getChildren().size()-1).getClass().getName() != "javafx.scene.control.Label") {
//            vbox.getChildren().remove(saveButton);
                label.setStyle("-fx-text-fill: #e75023; ");
                vbox.getChildren().add(label);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        score.setText(Main.getCurrentGame().getScore() + "");
        highscore.setText(Player.getInstance().getHighscore() + "");
        reviveButton.setText("Revive     " + (char) 9734 + "5");

        if (Main.getCurrentGame().isRevived()) {
            vbox.getChildren().remove(reviveButton);
//			reviveButton.setVisible(false);
        }
    }
}
