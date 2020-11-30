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

public class OrbMovement extends Application {
	Button JumpBtn = new Button("Jump");
	Rectangle player = new Rectangle(450, 420, 50, 100);


	public static void main(String[] args) {
		launch(args);
	}

	private void JumpOnClick(double pos) {
		double ty = player.getTranslateY();
		double mid = pos-180;
		double bound = Math.max(mid,ty-40);
		// quadratic interpolation to simulate gravity
		Interpolator interpolator = new Interpolator() {
			@Override
			protected double curve(double t) {
				// t is the fraction of animation completed
				return t * (2 - t); //rate to change animation speed
			}

		};
		Interpolator linear = new Interpolator() {
			@Override
			protected double curve(double t) {
				// t is the fraction of animation completed
				return t ; //rate to change animation speed
			}

		};
		Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO,
				new KeyValue(player.translateYProperty(), ty, interpolator)),
				new KeyFrame(Duration.seconds(0.3),
						new KeyValue(player.translateYProperty(), bound, interpolator)),
				new KeyFrame(Duration.seconds(0.75),
						new KeyValue(player.translateYProperty(), pos, linear)));

		timeline.play();
	}

	public void start(Stage primaryStage) {
		Rectangle screen = new Rectangle(20, 20, 986, 500);
		player.setFill(Color.RED);
		Group root = new Group(screen, JumpBtn, player);
		Scene scene = new Scene(root, 1024, 768);
		scene.setFill(Color.GREY);
		double init = player.getTranslateY();
		scene.setOnKeyPressed(e -> {
			if (e.getCode() == KeyCode.W) {
				JumpOnClick(init);
			}
		});
		primaryStage.setTitle("GUIPractice");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}