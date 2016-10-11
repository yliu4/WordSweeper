package client.model;

public class Location {
	int row;
	int column;
	public int CoordinateX;
	public int CoordinateY;
	public int width;
	public int height;

	public Location(int row, int column) {
		this.row = row;
		this.column = column;
		this.CoordinateX = 0;
		this.CoordinateY = 0;
	}
	
	public void setPanelLocation(int x, int y, int width, int height) {
		this.CoordinateX = x;
		this.CoordinateY = y;
		this.width = width;
		this.height = height;
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
