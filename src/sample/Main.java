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
	static Scene homeScene, gameplayScene, loadGameScene, closePopupScene;  
  static HBox gameplayPane;

	@Override
	public void start(Stage primaryStage) throws Exception
	{
		window = primaryStage;

		Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
		Parent gameplayRoot = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
		Parent loadGameRoot = FXMLLoader.load(getClass().getResource("loadGame.fxml"));
		Parent closePopupRoot = FXMLLoader.load(getClass().getResource("closePopup.fxml"));
    
    primaryStage.setTitle("Color Switch");
    
    new Game();
    gameplayPane = new HBox(30);
		homeScene = new Scene(homeRoot); //, 600, 300
		gameplayScene = new Scene(gameplayRoot);
		loadGameScene = new Scene(loadGameRoot);
		closePopupScene = new Scene(closePopupRoot);
            Scene gameScreen = new Scene(gameplayPane,200,300,Color.BLACK);
        primaryStage.setScene(gameScreen);

        primaryStage.show();
		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});

		window.setTitle("Color Switch");
		window.setScene(homeScene);
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
