package client.model;

public class Cell {
	Location location = null;
	Letter letter = null;
	
	public Cell(Location location, Letter letter) {
		this.location = location;
		this.letter = letter; 
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public void setCoordinateLocation(int x, int y, int width, int height) {
		this.location.setPanelLocation(x, y, width, height);
	}
	
	public Letter getLetter() {
		return this.letter;
	}
	
	public void setLetter(Letter letter) {
		this.letter = letter;
	}
}
