package client.model;

/**
 * Each Cell has Location and Letter.
 * 
 * @author Team Pisces
 */
public class Cell {
	/** The Location for the Cell. */
	Location location = null;
	
	/** The Letter in this Cell. */
	Letter letter = null;
	
	/** 
	 * Construct the Cell base on the Location and Letter.
	 * 
	 * @param location The Location of this Cell.
	 * @param letter The Letter in this Cell.
	 */
	public Cell(Location location, Letter letter) {
		this.location = location;
		this.letter = letter; 
	}
	
	/** 
	 * Get the Location object.
	 * 
	 * @return The Location of this Cell.
	 */
	public Location getLocation() {
		return this.location;
	}
	
	/**
	 * Use the row, column, width and height parameters to set the 
	 * Location of the Board.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void setCoordinateLocation(int x, int y, int width, int height) {
		this.location.setPanelLocation(x, y, width, height);
	}
	
	/** 
	 * Get the Letter object.
	 * 
	 * @return The Letter in this Cell.
	 */
	public Letter getLetter(){
		return this.letter;
	}
	
	/** 
	 * Set the Letter.
	 * 
	 * @param letter The Letter.
	 */
	public void setLetter(Letter letter) {
		this.letter = letter;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Cell cell = (Cell) obj;
		
		return (location.equals(cell.getLocation()) && 
				letter.equals(cell.getLetter()));
	}
}
