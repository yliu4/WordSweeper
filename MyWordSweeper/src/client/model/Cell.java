package client.model;

import client.view.CellDrawer;

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
	
	/** The drawer that draws this cell. */
	CellDrawer drawer;
	
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
	
	/**
	 * Get the celldrawer.
	 * 
	 * @return The celldrawer.
	 */
	public CellDrawer getDrawer() {
		return drawer;
	}

	/**
	 * Set the celldrawer.
	 * 
	 * @param drawer The celldrawer.
	 */
	public void setDrawer(CellDrawer drawer) {
		this.drawer = drawer;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		
		Cell cell = (Cell) obj;
		
		return (location.equals(cell.getLocation()) && 
				letter.equals(cell.getLetter()) &&
				drawer.equals(cell.getDrawer()));
	}
}
