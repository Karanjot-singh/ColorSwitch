package gamecode;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {
    public static final long serialVersionUID = 1L;
    private int savedGameID;
    private int score;
    private static int count =1;
    private ArrayList<Obstacle> onScreenObstacles;

    public Database() {
        this.onScreenObstacles= new ArrayList<>();
        this.savedGameID= count++;
        this.score=0;
    }

    public static void serialize(Database s1) throws IOException, FileNotFoundException {
        s1.printValue();
        ObjectOutputStream out;
        out = null;
        try {
            out = new ObjectOutputStream(
                    new FileOutputStream("out.txt"));
            out.writeObject(s1);
        } finally {
            out.close();
        }
    }
    public static void deserialize()
            throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream (
                    new FileInputStream("out.txt"));
            Database s1 = (Database) in.readObject();
            s1.printValue();
            SavedGames.addToSavedGames(s1);
        } finally {
            in.close();
        }
    }

    public void printValue(){

        System.out.println(serialVersionUID);
        System.out.println(savedGameID);
        System.out.println(score);

        for(Obstacle node : onScreenObstacles) {
            System.out.println(node.getName());
            System.out.println(node.getPosX());
            System.out.println(node.getPosY());
            System.out.println(node.getAnimationDuration());
            System.out.println(node.getAnimationTime());
        }
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSavedGameID() {
        return savedGameID;
    }

    public void setSavedGameID(int savedGameID) {
        this.savedGameID = savedGameID;
    }

    public ArrayList<Obstacle> getOnScreenObstacles() {
        return onScreenObstacles;
    }

    public void setOnScreenObstacles(ArrayList<Obstacle> onScreenObstacles) {
        this.onScreenObstacles = onScreenObstacles;
    }
}
