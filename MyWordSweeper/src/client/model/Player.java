package client.model;

/**
 * The player class represents the information of a player
 * including his/her name, score and original position in the 
 * global board
 * 
 * @author Team Pisces
 *
 */
public class Player {
	/** The name of player */
	String name = null;
	
	/** The score of the player */
	long score = 0; 
	
	/** The original position of the player */
	Location originPosition = null;
	
	/** Construct the player with the given name, score and location */
	public Player(String name, long score, Location originPosition) {
		this.name = name;
		this.score = score;
		this.originPosition = originPosition;
	}

	/** Get the score of the player */
	public long getScore() {
		return score;
	}

	/** Set the score of the player */
	public void setScore(long score) {
		this.score = score;
	}

	/** Get the original position of the player */
	public Location getOriginPosition() {
		return originPosition;
	}

	/** Set position for the player with the given location */
	public void setOriginPosition(Location originPosition) {
		this.originPosition = originPosition;
	}

	/** Get the name of player */
	public String getName() {
		return name;
	}
}
