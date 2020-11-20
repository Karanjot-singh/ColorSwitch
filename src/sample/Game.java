package sample;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Game {
    static VBox playRegion = new VBox(10);
    int score;
    float height;
    ArrayList<Obstacle> obstacles;
    Orb orb;
    Color[] currentTheme;


    Game() {

        currentTheme = new Color[]{Color.BLUE, Color.YELLOW, Color.RED, Color.GREEN};
        CircleObstacle obs = new CircleObstacle(currentTheme, 5, 600, 90, 10);
//        Main.gameplayPane.getChildren().add(playRegion);
    }

    void gameplay() {

    }

    public void pauseGame() {

    }

    public void gameOver() {

    }

    public void revive() {
    }

    public Boolean checkCollision() {
        return true;
    }

    public void createElement(int PosX, int PosY) {

    }

    public void removeElement(Elements element) {

    }

    public void createOrb() {

    }

    public int getScore() {
        return score;
    }

    public void addScore(int score) {
        this.score += score;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public ArrayList<Obstacle> getObstacles() {
        return obstacles;
    }

    public void setObstacles(ArrayList<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public Orb getOrb() {
        return orb;
    }

    public void setOrb(Orb orb) {
        this.orb = orb;
    }

    public Color[] getCurrentTheme() {
        return currentTheme;
    }

    public void setCurrentTheme(Color[] currentTheme) {
        this.currentTheme = currentTheme;
    }
}
