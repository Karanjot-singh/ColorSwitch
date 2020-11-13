package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("*** Color Switch ***");

        Color[] currentTheme ={Color.BLUE,Color.YELLOW, Color.RED, Color.GREEN};
        CircleObstacle obs = new CircleObstacle(currentTheme,1,1,1,1);
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 300, 275)); //mainScreen
        StackPane layout = new StackPane();

//        layout.getChildren().add();


        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
