package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.*;

public class Main extends Application
{
    static Stage window;
    static Scene home,gameplay;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        window = primaryStage;
        Parent homeDisp = FXMLLoader.load(getClass().getResource("home.fxml"));
        Parent gameDisp = FXMLLoader.load(getClass().getResource("gameplay.fxml"));
        home = new Scene(homeDisp); //, 600, 300
        gameplay = new Scene(gameDisp);


        primaryStage.setTitle("Color Switch");
        primaryStage.setScene(home);
        primaryStage.show();
    }


    public static void main(String[] args)
    {
        launch(args);
    }
}
