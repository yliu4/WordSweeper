package client.model;

/**
 * The Location contains the positional information.
 * 
 * @author Team Pisces
 *
 */
public class Location {
	/** Row number. */
	int row;
	
	/** Column number. */
	int column;
	
	/** The coordinate x of the location */
	int coordinateX;
	
	/** The coordinate y of the location */
	int coordinateY;
	
	/** The width of the panel*/
	int width;
	
	/** The height of the panel*/
	int height;

	/** 
	 * Construct the Location with the given row and column.
	 * 
	 * @param row The row number.
	 * @param column The colun number
	 */
	public Location(int row, int column) {
		this.row = row;
		this.column = column;
		this.coordinateX = 0;
		this.coordinateY = 0;
		this.width = 0;
		this.height = 0;
	}

	/** 
	 * Set the panel with the x, y, width and height.
	 * 
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
	
	/** 
	 * Get the coordinate of x of the panel.
	 * 
	 * @return
	 */
	public int getCoordinateX() {
		return coordinateX;
	}
	
	/** 
	 * Get the coordinate of y of the panel.
	 * 
	 * @return
	 */
	public int getCoordinateY() {
		return coordinateY;
	}
	
	/** 
	 * Get the width of the panel.
	 * 
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	
	/** 
	 * Get the height of the panel.
	 * 
	 * @return
	 */
	public int getHeight() {
		return height;
	}

	/** 
	 * Get the row number.
	 * 
	 * @return An <code>int</code> indicating the row number.
	 */
	public int getRow() {
		return row;
	}

	/** 
	 * Get the column number.
	 * 
	 * @return An <code>int</code>representing the column number.
	 */
	public int getColumn() {
		return column;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		Location lo = (Location) arg0;
		
		return (this.getColumn()==lo.getColumn())&&
				(this.getRow()==lo.getRow());
	}
}
