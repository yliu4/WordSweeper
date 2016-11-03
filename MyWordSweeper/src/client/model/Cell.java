package client.model;

/**
 * Each cell has location and letter
 * 
 * @author Team Pisces
 */
public class Cell {
	/** The location for the cell */
	Location location = null;
	
	/** The letter on this cell */
	Letter letter = null;
	
	/** Construct the Cell base on the location and letter */
	public Cell(Location location, Letter letter) {
		this.location = location;
		this.letter = letter; 
	}
	
	/** Get the location object */
	public Location getLocation() {
		return this.location;
	}
	
	/**
	 * Use the row, column, width and height parameters to set the 
	 * location of the board
	 */
	public void setCoordinateLocation(int x, int y, int width, int height) {
		this.location.setPanelLocation(x, y, width, height);
	}
	
	/** Get the letter object */
	public Letter getLetter(){
		return this.letter;
	}
	
	/** Set the letter */
	public void setLetter(Letter letter) {
		this.letter = letter;
	}
	
	/** Return the letter and location that belong to that cell */
	public boolean equals(Object obj) {
		Cell cell = (Cell) obj;
		return (location.equals(cell.getLocation()) && 
				letter.equals(cell.getLetter()));
	}
}
