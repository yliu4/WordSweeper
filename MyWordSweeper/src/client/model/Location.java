package client.model;

public class Location {
	int row;
	int column;
	
	public Location(int row, int column) {
		this.row = row;
		this.column = column;
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
