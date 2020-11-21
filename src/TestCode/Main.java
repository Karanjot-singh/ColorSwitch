package TestCode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Controller.fxml"));
        primaryStage.setTitle("Hello World");
        Scene gameScreen = new Scene(root);
        primaryStage.setScene(gameScreen);
//        new Controller();
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
