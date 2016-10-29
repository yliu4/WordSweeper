package client.model;

/**
 * The <code>Location</code> contains the positional information of a <code>Board</code>.
 * 
 * @author Team Pisces
 *
 */
public class Location {
	int row;
	int column;
	int coordinateX;
	int coordinateY;
	int width;
	int height;

	public Location(int row, int column) {
		this.row = row;
		this.column = column;
		this.coordinateX = 0;
		this.coordinateY = 0;
		this.width = 0;
		this.height = 0;
	}
	
	
	public void setPanelLocation(int x, int y, int width, int height) {
		this.coordinateX = x;
		this.coordinateY = y;
		this.width = width;
		this.height = height;
	}
	
	public int getCoordinateX() {
		return coordinateX;
	}
	
	public int getCoordinateY() {
		return coordinateY;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public boolean equals(Object arg0) {
		Location lo = (Location) arg0;
		
		return (this.getColumn()==lo.getColumn())&&
				(this.getRow()==lo.getRow());
	}
}
