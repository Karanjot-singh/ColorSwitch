package gamecode;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.HashMap;

public class Settings {
    static HashMap<String, Image> orbShape = new HashMap<>();
    static HashMap<String, Color[]> themes = new HashMap<>();
//	static Color [] currentTheme = new Color[4];

    static Color[] currentTheme = new Color[]{
            Color.web("#f6df0e"), //yellow
            Color.web("#8c13fb"), //purple
            Color.web("#ff0080"), //pink
            Color.web("#35e2f2")}; //blue

    Settings() {
//        currentTheme = new Color[]{Color.web("#9711ae"),
//                Color.web("#32d0d0"),
//                Color.web("#eb0d4c"),
//                Color.web("#e4e42c")};

    }

    void changeTheme() {

    }

}
