package client.model;
/**
 * Model is the top-level entity class which has access to all entity classes
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

	/** Set a game with the given game object */
	public void setGame(Game game) {
		this.game = game;
	}
	
	/** Get the game object */
	public Game getGame() {
		return this.game;
	}
	
	/** Set the board with the given x, y, width and height */
	public void setFilledBoard(int x, int y, int width, int height) {
		/** Check if the x and y for the board are valid. */
		if(x == -1 && y == -1) {
			this.location = null;
		} else {
			/** Set the initial location */
			this.location = new Location(0,0);
			
			/** Set the location for the panel */
			this.location.setPanelLocation(x, y, width, height);
		}	
	}
	
	/** Get the location of the board */
	public Location getFilledBoard() {
		return location;
	}
}
