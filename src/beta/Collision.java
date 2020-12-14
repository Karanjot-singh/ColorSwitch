package beta;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class Collision extends Application {

    private ArrayList<Shape> nodes;

    public static void main(String[] args) { launch(args); }

    @Override public void start(Stage primaryStage) {
        primaryStage.setTitle("Drag circles around to see collisions");
        Group root = new Group();
        Scene scene = new Scene(root, 400, 400);

        nodes = new ArrayList<>();
        nodes.add(new Circle(15, 15, 30));
        nodes.add(new Circle(90, 60, 30));
        nodes.add(new Circle(40, 60, 30));
        root.getChildren().addAll(nodes);
        checkShapeIntersection(nodes.get(nodes.size() - 1));

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void checkShapeIntersection(Shape block) {
        boolean collisionDetected = false;
        for (Shape static_bloc : nodes) {
            if (static_bloc != block) {
                static_bloc.setFill(Color.GREEN);

                Shape intersect = Shape.intersect(block, static_bloc);
                if (intersect.getBoundsInLocal().getWidth() != -1) {
                    collisionDetected = true;
                }
            }
        }
//        public Boolean checkCollision() {
//            for (Node element : obstacleColumn.getChildren()) {
//                Group elementGroup = (Group) element;
//                for (Node iterator : elementGroup.getChildren()) {
//                    Shape shape = (Shape) iterator;
//                    Shape orb = (Shape) playerOrb.getOrbGroup().getChildren().get(0);
//                    Shape intersect = Shape.intersect(orb, shape);
//                    if (intersect.getBoundsInLocal().getWidth() != -1) {
//                        System.out.println("Collision");
//                        return true;
//                    }
//                }
//            }
//            return false;
//        }

        if (collisionDetected) {
            block.setFill(Color.BLUE);
        } else {
            block.setFill(Color.GREEN);
        }
    }

    class Delta { double x, y; }


}

