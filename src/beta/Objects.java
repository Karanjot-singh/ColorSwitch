package beta;

import javafx.animation.*;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.util.Random;

public class Objects extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Group circle = new Group();
//        Arc( double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
        Color colorTheme[] = {Color.web("#9711ae"), Color.web("#32d0d0"), Color.web("#eb0d4c"), Color.web("#e4e42c")};
        for (int i = 1; i <= 4; i++) {
            Arc arc = new Arc(150, 150, 75, 75, 90 * i, 90);
            arc.setFill(Color.TRANSPARENT);
            arc.setStroke(colorTheme[i - 1]);
            arc.setType(ArcType.OPEN);
            arc.setStrokeWidth(12);
            circle.getChildren().add(arc);
        }

        //Color Switcher
        Group colorSwitcher = new Group();
//        Arc( double centerX, double centerY, double radiusX, double radiusY, double startAngle, double length)
        for (int i = 1; i <= 3; i++) {
            Arc arc = new Arc(150, 150, 10, 10, 90 * i, 90);
            arc.setFill(colorTheme[i - 1]);
            arc.setStroke(colorTheme[i - 1]);
            arc.setType(ArcType.ROUND);
            colorSwitcher.getChildren().add(arc);
        }
        //Orb
        Group orb = new Group();
        Circle player = new Circle(300, 560, 10);
        Random ran = new Random();
        int x = ran.nextInt(4);
        player.setFill(colorTheme[x]);
        player.setStrokeType(StrokeType.INSIDE);
        orb.getChildren().add(player);
        //Triangle obstacle
        //        Line(double startX, double startY, double endX, double endY)

        Group triangle = new Group();
        Line line = new Line(-105, 0, 25, 0);
        line.setStroke(colorTheme[0]);
        line.setLayoutX(152);
        line.setLayoutY(250);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        triangle.getChildren().add(line);
        line = new Line(-108, 1, -28, -142);
        line.setStroke(colorTheme[1]);
        line.setLayoutX(154);
        line.setLayoutY(250);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        triangle.getChildren().add(line);
        line = new Line(44, -9, -38, -152);
        line.setStroke(colorTheme[3]);
        line.setLayoutX(164);
        line.setLayoutY(259);
        line.setStrokeWidth(12);
        line.setStrokeLineCap(StrokeLineCap.ROUND);
        triangle.getChildren().add(line);

        //Square Obstacle
//        Line(double startX, double startY, double endX, double endY)
        Group square = new Group();
//        Line line = new Line(-100, 0, 25, 0);
        line.setStroke(colorTheme[0]);
        line.setLayoutX(337);
        line.setLayoutY(308);
        line.setStrokeWidth(12);
        square.getChildren().add(line);
        line = new Line(-100, 0, 25, 0);
        line.setStroke(colorTheme[1]);
        line.setLayoutX(337);
        line.setLayoutY(428);
        line.setStrokeWidth(12);
        square.getChildren().add(line);
        line = new Line(-116, -10, -116, 110);
        line.setStroke(colorTheme[2]);
        line.setLayoutX(347);
        line.setLayoutY(318);
        line.setStrokeWidth(12);
        square.getChildren().add(line);
        line = new Line(-116, -10, -116, 110);
        line.setStroke(colorTheme[3]);
        line.setLayoutX(484);
        line.setLayoutY(318);
        line.setStrokeWidth(12);
        square.getChildren().add(line);

        Scene scene = new Scene(triangle, 1024, 768);
//        scene.setFill(Color.BLACK);
        primaryStage.setTitle("SamarthTraitor XD");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}