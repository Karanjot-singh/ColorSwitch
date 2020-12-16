package gamecode;

public class Player {
    private static Player player = null;
    private String name;
    private int totalStars;
    private int highscore;

    private Player() {
        name = "ProGamer";
        totalStars = 0;
        highscore = 0;
    }

    //Design pattern: SINGLETON
    public static Player getInstance(){
        if(player==null){
            player = new Player();
        }
        return player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(int highscore) {
        this.highscore = highscore;
    }

    public int getTotalStars() {
        return totalStars;
    }

    public void addTotalStars(int totalStars) {
        this.totalStars += totalStars;
    }

    public void subtractStars(int num) {
        this.totalStars -= num;
    }

    //public void playGame(Game G1){}


}
