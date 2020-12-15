package gamecode;

public class Player {
	private String name;
	private int totalStars;
	//private Game currentGame;
	private int highscore;

	Player() {
		name="ProGamer";
		totalStars = 0;
		highscore = 0;
	}

	public String getName() {
		return name;
	}

	public int getHighscore(){
		return highscore;
	}

	public int getTotalStars() {
		return totalStars;
	}



	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addTotalStars(int totalStars) {
		this.totalStars += totalStars;
	}

	public void subtractStars(int num){
		this.totalStars-=num;
	}

	//public void playGame(Game G1){}




}
