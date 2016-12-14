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

	/** 
	 * Construct the Location with the given row and column.
	 * 
	 * @param row The row number.
	 * @param column The column number.
	 */
	public Location(int row, int column) {
		this.row = row;
		this.column = column;
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
