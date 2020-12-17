package gamecode;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {
    public static final long serialVersionUID = 1L;
    private int savedGameID;
    private static int count =1;
    private ArrayList<Obstacle> onScreenObstacles;

    public Database() {
        this.onScreenObstacles= new ArrayList<>();
        this.savedGameID= count++;
    }

    public static void serialize(Database s1) throws IOException, FileNotFoundException {
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
        } finally {
            in.close();
        }
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
