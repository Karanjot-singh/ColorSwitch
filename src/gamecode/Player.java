package gamecode;

public class Player {
	private String name;
	private int totalStars = 0;
	//private Game currentGame;
	private int highscore;

	Player() {

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

	//public void playGame(Game G1){}




}
