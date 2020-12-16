package gamecode;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameplayController implements Initializable {

	@FXML
	GridPane grid;

	@FXML
	ImageView pauseIcon;

	@FXML
	Label scoreLabel;

	@FXML
	void pauseClicked(MouseEvent mouseEvent) {
		Main.currentGame.pauseGame();
		PausePopupController.display();
	}

	@FXML
	void backClicked(MouseEvent mouseEvent) {
		Main.window.setScene(Main.homeScene);
	}

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

	}

}
