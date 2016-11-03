package client.model;

import java.util.*;

/**
 * The class contains a List of cells and represents 
 * the content of those cells
 * 
 * @author Team Pisces
 * 
 */
public class Word {
	/** A list of cells for the word */
	ArrayList<Cell> cells = null;
	
	/** Initialize a word */
	String word = null;
	
	/** Construct a word with a list of cells */
	public Word(ArrayList<Cell> cells) {
		this.cells = cells;
		
		/** String buffer to append character */
		StringBuffer sb = new StringBuffer();

		/** Iterate all the cells and append the letters in these
		 *  cells into string buffer
		 */
		for (Cell cell: cells) {
			sb.append(cell.getLetter().getCharacter());
		}

		/** Convert word to string */
		this.word = sb.toString();
	}

	/** Get the cell object */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	/** Get the word object */
	public String getWord() {
		return word;
	}
}
