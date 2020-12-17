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
    private static Stage window;
    private static Scene homeScene;
    private static Scene gameplayScene;
    private static Scene loadGameScene;
    private static Scene helpScene;
    private static Scene settingsScene;
    private static Scene playerInfoScene;
    private static Scene pausePopupScene;
    private static Scene closePopupScene;
    private static Scene gameOverScene;
    private static Parent gameplayRoot;
    private static Game currentGame;
    private static FXMLLoader fxmlLoader;

    static void closeProgram() {
        Boolean ans = ClosePopupController.display();

        if (ans) {
            getWindow().close();
        }

    }

    static void startNewGame() {
        setFxmlLoader(new FXMLLoader(Main.class.getResource("gameplay.fxml")));
        try {
            setGameplayRoot(getFxmlLoader().load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        setGameplayScene(new Scene(getGameplayRoot()));
        setCurrentGame(new Game(getFxmlLoader()));
        Game.gameLoop();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Stage getWindow() {
        return window;
    }

    public static void setWindow(Stage window) {
        Main.window = window;
    }

    public static Scene getHomeScene() {
        return homeScene;
    }

    public static void setHomeScene(Scene homeScene) {
        Main.homeScene = homeScene;
    }

    public static Scene getGameplayScene() {
        return gameplayScene;
    }

    public static void setGameplayScene(Scene gameplayScene) {
        Main.gameplayScene = gameplayScene;
    }

    public static Scene getLoadGameScene() {
        return loadGameScene;
    }

    public static void setLoadGameScene(Scene loadGameScene) {
        Main.loadGameScene = loadGameScene;
    }

    public static Scene getHelpScene() {
        return helpScene;
    }

    public static void setHelpScene(Scene helpScene) {
        Main.helpScene = helpScene;
    }

    public static Scene getSettingsScene() {
        return settingsScene;
    }

    public static void setSettingsScene(Scene settingsScene) {
        Main.settingsScene = settingsScene;
    }

    public static Scene getPlayerInfoScene() {
        return playerInfoScene;
    }

    public static void setPlayerInfoScene(Scene playerInfoScene) {
        Main.playerInfoScene = playerInfoScene;
    }

    public static Scene getPausePopupScene() {
        return pausePopupScene;
    }

    public static void setPausePopupScene(Scene pausePopupScene) {
        Main.pausePopupScene = pausePopupScene;
    }

    public static Scene getClosePopupScene() {
        return closePopupScene;
    }

    public static void setClosePopupScene(Scene closePopupScene) {
        Main.closePopupScene = closePopupScene;
    }

    public static Scene getGameOverScene() {
        return gameOverScene;
    }

    public static void setGameOverScene(Scene gameOverScene) {
        Main.gameOverScene = gameOverScene;
    }

    public static Parent getGameplayRoot() {
        return gameplayRoot;
    }

    public static void setGameplayRoot(Parent gameplayRoot) {
        Main.gameplayRoot = gameplayRoot;
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        Main.currentGame = currentGame;
    }

    public static FXMLLoader getFxmlLoader() {
        return fxmlLoader;
    }

    public static void setFxmlLoader(FXMLLoader fxmlLoader) {
        Main.fxmlLoader = fxmlLoader;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        setWindow(primaryStage);

        Player.getInstance();
        Parent homeRoot = FXMLLoader.load(getClass().getResource("home.fxml"));
        Parent loadGameRoot = FXMLLoader.load(getClass().getResource("loadGame.fxml"));
        Parent helpRoot = FXMLLoader.load(getClass().getResource("help.fxml"));
        Parent settingsRoot = FXMLLoader.load(getClass().getResource("settings.fxml"));
        Parent pausePopupRoot = FXMLLoader.load(getClass().getResource("pausePopup.fxml"));
        Parent closePopupRoot = FXMLLoader.load(getClass().getResource("closePopup.fxml"));

        setHomeScene(new Scene(homeRoot));
        setLoadGameScene(new Scene(loadGameRoot));
        setHelpScene(new Scene(helpRoot));
        setSettingsScene(new Scene(settingsRoot));
        setClosePopupScene(new Scene(closePopupRoot));
        setPausePopupScene(new Scene(pausePopupRoot));

        getWindow().setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });

//		window.initStyle(StageStyle.TRANSPARENT);
        getWindow().setTitle("Color Switch");
        getWindow().setScene(getHomeScene());
        getWindow().centerOnScreen();
        getWindow().setResizable(false);
        getWindow().show();
        initialiseMusic();
    }

    public static void initialiseMusic() {
        Thread t1 = new Thread();
        Music.getInstance();
        t1.start();
    }

    public static void playMusic() {
        Music.getInstance().startMusic();
    }

    public static void pauseMusic() {
        Music.getInstance().stopMusic();
    }
}

class Music implements Runnable {

    private static Music music = null;
    static MediaPlayer mediaPlayer;
    static boolean playing;

    private Music() {
        Media backgroundMusic = new Media(getClass().getResource("/assets/music.wav").toString());
        mediaPlayer = new MediaPlayer(backgroundMusic);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(30));
        playing = true;
    }

    //Design pattern: SINGLETON
    public static Music getInstance(){
        if(music==null){
            music = new Music();
        }
        return music;
    }

    void stopMusic() {
        mediaPlayer.stop();
        setPlaying(false);
    }

    void startMusic() {
        mediaPlayer.play();
        setPlaying(true);
    }

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean isPlaying) {
        Music.playing = isPlaying;
    }

    @Override
    public void run() {
        startMusic();
    }
}
