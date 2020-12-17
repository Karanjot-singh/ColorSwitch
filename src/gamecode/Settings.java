package gamecode;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.HashMap;

public final class Settings {
    static HashMap<String, Image> orbShape = new HashMap<>();
    static HashMap<Integer, Color[]> themes = new HashMap<>();

    static {
        themes.put(1, new Color[]{
                Color.web("#f6df0e"), //yellow
                Color.web("#8c13fb"), //purple
                Color.web("#ff0080"), //pink
                Color.web("#35e2f2")});
        themes.put(2, new Color[]{
                Color.web("#ff931e"), //yellow
                Color.web("#2e3192"), //purple
                Color.web("#c1272d"), //pink
                Color.web("#39b54a")});
    }

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

    static void changeTheme(int i) {
        System.out.println("Theme"+i);
        currentTheme = themes.get(i);
    }

}
