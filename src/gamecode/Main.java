package gamecode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
    static Stage window;
    static Scene homeScene, gameplayScene, loadGameScene, helpScene, settingsScene, playerInfoScene, pausePopupScene, closePopupScene, gameOverScene;
    static Parent gameplayRoot;
    static Game currentGame;
    static FXMLLoader fxmlLoader;
    static Player player;
    static PlayMusic music;

    static void closeProgram() {
        Boolean ans = ClosePopupController.display();

        if (ans) {
            window.close();
        }

    }

    static void startNewGame() {
        fxmlLoader = new FXMLLoader(Main.class.getResource("gameplay.fxml"));
        try {
            gameplayRoot = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        gameplayScene = new Scene(gameplayRoot);
        currentGame = new Game(fxmlLoader);
        Game.gameLoop();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        player = new Player();
        Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
//		Parent gameplayRoot = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
//        fxmlLoader = new FXMLLoader(getClass().getResource("gameplay.fxml"));

//		this.controller = fxmlLoader.getController();

//        gameplayRoot = fxmlLoader.load();
        Parent loadGameRoot = FXMLLoader.load(getClass().getResource("loadGame.fxml"));
        Parent helpRoot = FXMLLoader.load(getClass().getResource("help.fxml"));
        Parent settingsRoot = FXMLLoader.load(getClass().getResource("settings.fxml"));
//        Parent playerInfoRoot = FXMLLoader.load(getClass().getResource("playerInfo.fxml"));
        Parent pausePopupRoot = FXMLLoader.load(getClass().getResource("pausePopup.fxml"));
        Parent closePopupRoot = FXMLLoader.load(getClass().getResource("closePopup.fxml"));
//        Parent gameOverRoot = FXMLLoader.load(getClass().getResource("gameOver.fxml"));


        homeScene = new Scene(homeRoot); //, 600, 300
//        gameplayScene = new Scene(gameplayRoot);
        loadGameScene = new Scene(loadGameRoot);
        helpScene = new Scene(helpRoot);
        settingsScene = new Scene(settingsRoot);
//        playerInfoScene = new Scene(playerInfoRoot);
        closePopupScene = new Scene(closePopupRoot);
        pausePopupScene = new Scene(pausePopupRoot);
//        gameOverScene = new Scene(gameOverRoot);


        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
//		window.initStyle(StageStyle.TRANSPARENT);
        window.setTitle("Color Switch");
        window.setScene(homeScene);
        window.centerOnScreen();
        window.show();
        playMusic();
    }

    public void playMusic() {
        Thread t1 = new Thread();
        music = new PlayMusic();
        t1.start();
    }

    public void pauseMusic() {
        music.stopMusic();
    }
}

class PlayMusic implements Runnable {

    static MediaPlayer mediaPlayer;

    public PlayMusic() {
        Media backgroundMusic = new Media(getClass().getResource("/assets/music.wav").toString());
        mediaPlayer = new MediaPlayer(backgroundMusic);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(30));
    }

    void stopMusic() {
        mediaPlayer.stop();
    }

    void startGameMusic() {
        mediaPlayer.play();
    }

    @Override
    public void run() {
        startGameMusic();
    }
}
