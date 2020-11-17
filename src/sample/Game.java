package sample;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Game {
    static VBox playRegion = new VBox(10);

    Game() {

        Color[] currentTheme = {Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN};
        CircleObstacle obs = new CircleObstacle(currentTheme, 5, 600, 90, 10);
        Main.gameplayPane.getChildren().add(playRegion);
    }

}
