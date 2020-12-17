package gamecode;

import java.io.*;
import java.util.ArrayList;

public class Database implements Serializable {
    public static final long serialVersionUID = 1L;
    private int savedGameID;
    private ArrayList<Obstacle> onScreenObstacles;

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

}
