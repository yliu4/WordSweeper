package client.model;

/**
 * The <code>Player</code> class represents the information of a player,
 * 
 * including his/her name, score and original position in the global board.
 * 
 * @author Team Pisces
 * 
 */
public class Player {
	String name = null;
	long score = 0; 
	Location originPosition = null;
	
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

	public String getName() {
		return name;
	}
}
