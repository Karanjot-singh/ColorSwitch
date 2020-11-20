package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;

public class HomeController {

	public Button newGameButton, loadGameButton, exitButton;
	public Label homeLabel;


	@FXML
	void textHover()
	{
		homeLabel.setText("WELCOME TO COLOR SWITCH!");
	}

	@FXML
	void newGameClicked()
	{
		Main.window.setScene(Main.gameplayScene);
	}

	@FXML
	void loadGameClicked()
	{
		LoadGameController.display();
//        Main.window.setScene
	}

	@FXML
	void exitClicked()
	{
		Main.closeProgram();
	}



}
