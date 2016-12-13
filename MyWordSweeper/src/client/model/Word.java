package client.model;

import java.util.*;

/**
 * The Word class contains a List of Cells and a String represents the 
 * 
 * content of those Cells.
 * 
 * @author Team Pisces
 * 
 */
public class Word {
	/** A List of Cells for the word. */
	ArrayList<Cell> cells = new ArrayList<Cell>();
	
	/** A StringBuffer that builds the word. */
	StringBuffer word = new StringBuffer();

	/** 
	 * Get the object of the List of Cells.
	 * 
	 * @return A List of Cells.
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	/** 
	 * Get the String representation of the Word.
	 * 
	 * @return A String representing the Word.
	 */
	public String getWord() {
		return word.toString().toUpperCase();
	}
	
	/**
	 * Add a cell to the word.
	 * 
	 * @param cell The cell.
	 */
	public void add(Cell cell) {
		if (!cells.contains(cell)) {
			cells.add(cell);
			word.append(cell.getLetter().getCharacter());
		}
	}
	
	/**
	 * Check if the word contains this cell.
	 * 
	 * @param cell The cell.
	 * @return <code>true</code> if the cell exists in the word,
	 * <code>false</code> if not. 
	 */
	public boolean contains(Cell cell) {
		return cells.contains(cell);
	}
	
	/**
	 * Clear the word.
	 */
	public void clear() {
		cells.clear();
		word.delete(0, word.length());
	}
	
	/**
	 * Check if this cell is a newly added cell.
	 * 
	 * @param cell The cell.
	 * @return <code>true</code> if the cell is the latest added cell,
	 * <code>false</code> if not. 
	 */
	public boolean isNew(Cell cell) {
		if (cells.size() == 0) return false;
		
		return cells.get(cells.size()-1).equals(cell);
	}
	
	/**
	 * Check if the cell is close to the previously added cell.
	 * 
	 * @param cell The cell. 
	 * @return <code>true</code> if the cell is close to the previously added cell,
	 * <code>false</code> if not.
	 */
	public boolean isClose2Pre(Cell cell) {
		if (cells.size() == 0) return true;
		
		Location cur = cell.getLocation();
		Location pre = cells.get(cells.size()-1).getLocation();
		
		return Math.abs(cur.getColumn() - pre.getColumn()) <= 1 &&
				Math.abs(cur.getRow() - pre.getRow()) <= 1;
	}
}
