package gamecode;

import java.util.ArrayList;

public class SavedGames {
    private static ArrayList<Database> allSavedGames = new ArrayList<>();

    public static void addToSavedGames(Database d) {
        allSavedGames.add(d);
    }























    public static ArrayList<Database> getAllSavedGames() {
        return allSavedGames;
    }
}
