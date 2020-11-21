package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class Main extends Application
{
	static Stage window;
	static Scene homeScene, gameplayScene, loadGameScene, helpScene, settingsScene, closePopupScene;

	//static HBox gameplayPane;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;

		Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
		Parent gameplayRoot = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
		Parent loadGameRoot = FXMLLoader.load(getClass().getResource("loadGame.fxml"));
		Parent helpRoot = FXMLLoader.load(getClass().getResource("help.fxml"));
		Parent settingsRoot = FXMLLoader.load(getClass().getResource("settings.fxml"));
		Parent closePopupRoot = FXMLLoader.load(getClass().getResource("closePopup.fxml"));


    	//new Game();
    	//gameplayPane = new HBox(30);


		homeScene = new Scene(homeRoot); //, 600, 300
		gameplayScene = new Scene(gameplayRoot);
		loadGameScene = new Scene(loadGameRoot);
		helpScene = new Scene(helpRoot);
		settingsScene = new Scene(settingsRoot);
		closePopupScene = new Scene(closePopupRoot);

//		homeScene.getStylesheets().add(getClass().getResource("generalStyle.css").toExternalForm());

		//Scene gameScreen = new Scene(gameplayPane,200,300,Color.BLACK);
        //primaryStage.setScene(gameScreen);

		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});

		window.setTitle("Color Switch");
		window.setScene(homeScene);
		window.centerOnScreen();
		window.show();
	}

	static void closeProgram() {
		Boolean ans = ClosePopupController.display();

		if(ans)
		{
			window.close();
		}

	}


	public static void main(String[] args)
	{
		launch(args);
	}
}
