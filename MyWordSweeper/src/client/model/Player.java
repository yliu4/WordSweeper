package client.model;

/**
 * The Player class represents the information of a Player
 * 
 * including his/her name, score and original position in the 
 * 
 * global board.
 * 
 * @author Team Pisces
 *
 */
public class Player {
	/** The name of Player. */
	String name = null;
	
	/** The original position of the Player. */
	Location originPosition = null;
	
	/** The score of the Player. */
	long score = 0; 
	
	/** 
	 * Construct the Player with the given name, score and Location.
	 * 
	 * @param name The name of the Player.
	 * @param score The score of the Player.
	 * @param originPosition The original position of the Player.
	 */
	public Player(String name, long score, Location originPosition) {
		this.name = name;
		this.score = score;
		this.originPosition = originPosition;
	}

	/** 
	 * Get the score of the Player.
	 * 
	 * @return A <code>long</code> representing the score of the Player.
	 */
	public long getScore() {
		return score;
	}

	/** 
	 * Set the score of the Player.
	 * 
	 * @param score The score of the Player.
	 */
	public void setScore(long score) {
		this.score = score;
	}

	/** 
	 * Get the original position of the Player.
	 * 
	 * @return A Location representing the original position of the Player.
	 */
	public Location getOriginPosition() {
		return originPosition;
	}

	/** 
	 * Set the original position of the Player with the given Location.
	 * 
	 * @param originPosition The original position of the Player.
	 */
	public void setOriginPosition(Location originPosition) {
		this.originPosition = originPosition;
	}

	/** 
	 * Get the name of Player.
	 * 
	 * @return A String representing the name of the Player.
	 */
	public String getName() {
		return name;
	}
}
