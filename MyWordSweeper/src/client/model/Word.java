package client.model;

import java.util.*;

/**
 * The Word class contains a List of Cells and a String represents the content of 
 * 
 * those Cells.
 * 
 * @author Team Pisces
 * 
 */
public class Word {
	/** A List of Cells for the word. */
	ArrayList<Cell> cells = null;
	
	/** A String represents the word. */
	String word = null;
	
	/** 
	 * Construct a Word with a list of Cells.
	 * 
	 * @param cells The List of Cells
	 */
	public Word(ArrayList<Cell> cells) {
		this.cells = cells;
		
		StringBuffer sb = new StringBuffer();
		
		for (Cell cell: cells) {
			sb.append(cell.getLetter().getCharacter());
		}
		this.word = sb.toString();
	}

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
		return word;
	}
}
