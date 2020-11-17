package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class Main extends Application {
    static Stage window;
    static Scene home, gameplay;
    static HBox gameplayPane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        Parent homeDisp = FXMLLoader.load(getClass().getResource("home.fxml"));
        Parent gameDisp = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
        home = new Scene(homeDisp); //, 600, 300
        gameplay = new Scene(gameDisp);
        gameplayPane = new HBox(30);

        primaryStage.setTitle("Color Switch");
//        primaryStage.setScene(home);

        new Game();
        Scene gameScreen = new Scene(gameplayPane,200,300,Color.BLACK);
        primaryStage.setScene(gameScreen);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
