package client.model;

/**
 * Model is the top-level entity class which has access to all entity classes.
 * 
 * @author Team Pisces
 *
 */
public class Model {
	/**  Reference Game for easy navigation */
	Game game = null;
	
	/** Reference Location for easy navigation */ 
	Location location = null;

	/** Constructor for the model */
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
	
	/** 
	 * Set the board with the given x, y, width and height. 
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void setFilledBoard(int x, int y, int width, int height) {
		if(x == -1 && y == -1) {
			this.location = null;
		} 
		else {
			this.location = new Location(0,0);
			this.location.setPanelLocation(x, y, width, height);
		}	
	}
	
	/** 
	 * Get the Location of the Board?
	 * 
	 * @return
	 */
	public Location getFilledBoard() {
		return location;
	}
}
