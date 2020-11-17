package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

public class Main extends Application
{
	static Stage window;
	static Scene homeScene, gameplayScene, loadGameScene;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;

		Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
		Parent gameplayRoot = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
		Parent loadGameRoot = FXMLLoader.load(getClass().getResource("loadGame.fxml"));

		homeScene = new Scene(homeRoot); //, 600, 300
		gameplayScene = new Scene(gameplayRoot);
		loadGameScene = new Scene(loadGameRoot);

		window.setTitle("Color Switch");
		window.setScene(homeScene);
		window.show();
	}


	public static void main(String[] args)
	{
		launch(args);
	}
}
