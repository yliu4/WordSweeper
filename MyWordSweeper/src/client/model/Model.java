package client.model;

/**
 * Model is the top-level entity class which has access to all entity classes.
 * 
 * @author Team Pisces
 *
 */
public class Model {
	/**  Reference Game for easy navigation. */
	Game game = null;

	/** Constructor for the Model. */
	public Model() {
		
	}

	/** 
	 * Set the Game with the given Game object.
	 * 
	 * @param game The Game.
	 */
	public void setGame(Game game) {
		this.game = game;
	}
	
	/** 
	 * Get the Game object.
	 * 
	 * @return A Game object of the current game.
	 */
	public Game getGame() {
		return this.game;
	}
}
