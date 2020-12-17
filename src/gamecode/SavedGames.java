package gamecode;

import java.util.ArrayList;

public class SavedGames {
    private static final ArrayList<Database> allSavedGames = new ArrayList<>();

    public static void addToSavedGames(Database d) {
        allSavedGames.add(d);
    }

    public static Database getDatabase() {
        return allSavedGames.get(allSavedGames.size() - 1);
    }
//    public static ArrayList<Database> getAllSavedGames() {
//        return allSavedGames;
//    }
}
