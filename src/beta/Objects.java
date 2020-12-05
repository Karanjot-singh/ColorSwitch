package beta;

import javafx.animation.*;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Objects extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage) {

        Rectangle screen = new Rectangle(20, 20, 986, 500);
        Group root = new Group(screen);
        Scene scene = new Scene(root, 1024, 768);
        scene.setFill(Color.BLACK);
        primaryStage.setTitle("SamarthTraitor XD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}