package client.model;

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
		if(width != 0 && height != 0) {
			this.location = new Location(0,0);
			this.location.setPanelLocation(x, y, width, height);
		}
	}
	
	public Location getFilledBoard() {
		return location;
	}
}
