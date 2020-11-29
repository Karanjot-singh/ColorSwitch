package gamecode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.*;
import javafx.util.Duration;

public class Main extends Application {
	static Stage window;
	static Scene homeScene, gameplayScene, loadGameScene, helpScene, settingsScene, pausePopupScene, closePopupScene;
	static MediaPlayer mediaPlayer;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
		Parent gameplayRoot = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
		Parent loadGameRoot = FXMLLoader.load(getClass().getResource("loadGame.fxml"));
		Parent helpRoot = FXMLLoader.load(getClass().getResource("help.fxml"));
		Parent settingsRoot = FXMLLoader.load(getClass().getResource("settings.fxml"));
		Parent pausePopupRoot = FXMLLoader.load(getClass().getResource("pausePopup.fxml"));
		Parent closePopupRoot = FXMLLoader.load(getClass().getResource("closePopup.fxml"));

		homeScene = new Scene(homeRoot); //, 600, 300
		gameplayScene = new Scene(gameplayRoot);
		loadGameScene = new Scene(loadGameRoot);
		helpScene = new Scene(helpRoot);
		settingsScene = new Scene(settingsRoot);
		closePopupScene = new Scene(closePopupRoot);
		pausePopupScene = new Scene(pausePopupRoot);

		window.setOnCloseRequest(e -> {
			e.consume();
			closeProgram();
		});

//        startGameMusic();
		window.initStyle(StageStyle.TRANSPARENT);
		window.setTitle("Color Switch");
		window.setScene(homeScene);
		window.centerOnScreen();
		window.show();
	}

	void startGameMusic() {
		Media backgroundMusic = new Media(getClass().getResource("/assets/music.wav").toString());
		mediaPlayer = new MediaPlayer(backgroundMusic);
		mediaPlayer.setAutoPlay(true);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlayer.setStartTime(Duration.seconds(0));
		mediaPlayer.setStopTime(Duration.seconds(30));
		mediaPlayer.play();
	}

	static void closeProgram() {
		Boolean ans = ClosePopupController.display();

		if (ans) {
			window.close();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}