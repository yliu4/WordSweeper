package client.model;

/**
 * Each <code>Cell</code> has <code>Location</code> and <code>Letter</code>.
 * 
 * @author Team Pisces
 *
 */
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
	
	/**
	 * Use the row, column, width and height parameters to set the 
	 * 
	 * <code>Location</code> of the <code>Board</code>.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void setCoordinateLocation(int x, int y, int width, int height) {
		this.location.setPanelLocation(x, y, width, height);
	}
	
	public Letter getLetter() {
		return this.letter;
	}
	
	public void setLetter(Letter letter) {
		this.letter = letter;
	}
	
	public boolean equals(Object obj) {
		Cell cell = (Cell) obj;
		return (location.equals(cell.getLocation()) && 
				letter.equals(cell.getLetter()));
	}
}
