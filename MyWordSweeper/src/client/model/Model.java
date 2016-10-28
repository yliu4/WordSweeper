package client.model;

/**
 * Model describes the complete information of a game session
 * Including the game information and the subset of the board 
 * assigned to the player
 * @author team Pisces
 */

public class Model {
	Game game = null;
	Location location = null;

	
	
	public Model() {
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public Game getGame() {
		return this.game;
	}
	
	public void setFilledBoard(int x, int y, int width, int height) {
		if(x == -1 && y == -1) {
			this.location = null;
		} else {
			this.location = new Location(0,0);
			this.location.setPanelLocation(x, y, width, height);
		}	
	}
	
	public Location getFilledBoard() {
		return location;
	}
}
