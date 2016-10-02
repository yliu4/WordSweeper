package client.model;

public class Player {
	String name = null;
	long score = 0; // long is used in XML
	Location originPosition = null;
	
	// for current player
	public Player(String name) {
		this.name = name;
	}
	
	// for others, including managing player
	public Player(String name, long score, Location originPosition) {
		this.name = name;
		this.score = score;
		this.originPosition = originPosition;
	}

	public long getScore() {
		return score;
	}

	public void setScore(long score) {
		this.score = score;
	}

	public Location getOriginPosition() {
		return originPosition;
	}

	public void setOriginPosition(Location originPosition) {
		this.originPosition = originPosition;
	}
}
