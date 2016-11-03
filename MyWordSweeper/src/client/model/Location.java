package client.model;

/**
 * The location contains the positional information of a board
 * 
 * @author Team Pisces
 *
 */
public class Location {
	/** Row for tracking the location */
	int row;
	
	/** Column for tracking the location later */
	int column;
	
	/** The coordinate x of the location */
	int coordinateX;
	
	/** The coordinate y of the location */
	int coordinateY;
	
	/** The width of the panel*/
	int width;
	
	/** The height of the panel*/
	int height;

	/** Construct the location with the given row and column */
	public Location(int row, int column) {
		this.row = row;
		this.column = column;
		this.coordinateX = 0;
		this.coordinateY = 0;
		this.width = 0;
		this.height = 0;
	}

	/** 
	 * Set the panel with the x, y, width and height
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 */
	public void setPanelLocation(int x, int y, int width, int height) {
		this.coordinateX = x;
		this.coordinateY = y;
		this.width = width;
		this.height = height;
	}
	
	/** Get the coordinate of x of the panel */
	public int getCoordinateX() {
		return coordinateX;
	}
	
	/** Get the coordinate of y of the panel */
	public int getCoordinateY() {
		return coordinateY;
	}
	
	/** Get the width of the panel */
	public int getWidth() {
		return width;
	}
	
	/** Get the height of the panel */
	public int getHeight() {
		return height;
	}

	/** Get the row of the board */
	public int getRow() {
		return row;
	}

	/** Get the column of the board */
	public int getColumn() {
		return column;
	}

	/** Check if the two locations are the same */
	public boolean equals(Object arg0) {
		Location lo = (Location) arg0;
		return (this.getColumn()==lo.getColumn())&&
				(this.getRow()==lo.getRow());
	}
}
