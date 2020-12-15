package gamecode;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.*;
import javafx.util.Duration;

import java.io.IOException;

public class Main extends Application {
    static Stage window;
    static Scene homeScene, gameplayScene, loadGameScene, helpScene, settingsScene, pausePopupScene, closePopupScene, gameOverScene;
    static Parent gameplayRoot;
    static MediaPlayer mediaPlayer;
    static Game currentGame;
    static FXMLLoader fxmlLoader;
    static Player player;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
//		Parent gameplayRoot = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
//        fxmlLoader = new FXMLLoader(getClass().getResource("gameplay.fxml"));

//		this.controller = fxmlLoader.getController();

//        gameplayRoot = fxmlLoader.load();
        Parent loadGameRoot = FXMLLoader.load(getClass().getResource("loadGame.fxml"));
        Parent helpRoot = FXMLLoader.load(getClass().getResource("help.fxml"));
        Parent settingsRoot = FXMLLoader.load(getClass().getResource("settings.fxml"));
        Parent pausePopupRoot = FXMLLoader.load(getClass().getResource("pausePopup.fxml"));
        Parent closePopupRoot = FXMLLoader.load(getClass().getResource("closePopup.fxml"));
//        Parent gameOverRoot = FXMLLoader.load(getClass().getResource("gameOver.fxml"));


        homeScene = new Scene(homeRoot); //, 600, 300
//        gameplayScene = new Scene(gameplayRoot);
        loadGameScene = new Scene(loadGameRoot);
        helpScene = new Scene(helpRoot);
        settingsScene = new Scene(settingsRoot);
        closePopupScene = new Scene(closePopupRoot);
        pausePopupScene = new Scene(pausePopupRoot);
//        gameOverScene = new Scene(gameOverRoot);

        player = new Player();

        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

//      startGameMusic();
//		window.initStyle(StageStyle.TRANSPARENT);
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
    static void gameLoop(Game currentGame){
        Timeline gameTimeline = new Timeline();
        final Duration fps = Duration.millis(1000 / 60);
        final KeyFrame gameFrame = new KeyFrame(fps, new EventHandler() {
            @Override
            public void handle(Event event) {
                currentGame.checkObstacleCollision();
                currentGame.checkStarCollision();

                if(currentGame.playerOrb.getOrbGroup().getTranslateY()>150){
                    System.out.println("GAME OVER");
                    gameTimeline.stop();
                    currentGame.gameOver();
                }
            }
        });

        //// sets the game world's game loop (Timeline)
//        TimelineBuilder.create()
//                .cycleCount(Animation.INDEFINITE)
//                .keyFrames(gameFrame)
//                .build()
//                .play();
        gameTimeline.setCycleCount(Animation.INDEFINITE);
        gameTimeline.getKeyFrames().addAll(gameFrame);
        gameTimeline.play();

    }
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
        gameLoop(currentGame);
    }

    public static void main(String[] args) {
        launch(args);
    }
}