package beta;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class OrbMovement extends Application {
    Button JumpBtn = new Button("Jump");
    Rectangle player = new Rectangle(450, 420, 50, 100);


    public static void main(String[] args) {
        launch(args);
    }

    private void JumpOnClick() {
        double ty = player.getTranslateY();

// quadratic interpolation to simulate gravity
        Interpolator interpolator = new Interpolator() {
            @Override
            protected double curve(double t) {
                // t is the fraction of animation completed
                return t * (2 - t); //rate to change animation speed
            }

        };
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,
                new KeyValue(player.translateYProperty(), ty, interpolator)),
                new KeyFrame(Duration.seconds(1),
                        new KeyValue(player.translateYProperty(), ty - 40, interpolator)));

// play forward once, then play backward once
        timeline.setCycleCount(2);
        timeline.setAutoReverse(true);

        JumpBtn.setDisable(true);
        timeline.setOnFinished(evt -> JumpBtn.setDisable(false));

        timeline.play();
    }

    public void start(Stage primaryStage) {
        Rectangle screen = new Rectangle(20, 20, 986, 500);
        JumpBtn.setLayoutX(410);
        JumpBtn.setLayoutY(530);
        JumpBtn.setMinWidth(200);
        JumpBtn.setMinHeight(100);
        player.setFill(Color.RED);

//        Path path = new Path();

        JumpBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
//                player.setTranslateY(-40);
                  JumpOnClick();
            }

        });

        Group root = new Group(screen, JumpBtn, player);

        Scene scene = new Scene(root, 1024, 768);
        scene.setFill(Color.GREY);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.W) {
//                System.out.println("A key was pressed");
            JumpOnClick();
            }
        });
        primaryStage.setTitle("GUIPractice");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}