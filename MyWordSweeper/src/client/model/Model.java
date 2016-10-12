package client.model;

/**
 * The <code>Model</code> class is the top-level class for all entity classes.
 * 
 * @author Team Pisces 
 */
public class Model {
	Game game = null;
	Location location = null;

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
