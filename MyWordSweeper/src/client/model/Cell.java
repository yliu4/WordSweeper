package client.model;

public class Cell {
	Location location = null;
	Letter letter = null;
	
	public Cell(int row, int column, Letter letter) {
		this.location = new Location(row, column);
		this.letter = letter; 
		// i think we should have Letter as a parameter
	}
	
	public Location getLocation() {
		return this.location;
	}
	
	public Letter getLetter() {
		return this.letter;
	}
	
	public void setLetter(Letter letter) {
		this.letter = letter;
	}
}
