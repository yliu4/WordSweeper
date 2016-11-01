package client.model;

import java.util.*;

/**
 * The <code>Word</code> class contains a List of <code>Cells</code> 
 * 
 * and a <code>String</code> represents the content of those <code>Cells</code>.
 * 
 * @author Team Pisces
 * 
 */
public class Word {
	ArrayList<Cell> cells = null;
	String word = null;
	
	public Word(ArrayList<Cell> cells) {
		this.cells = cells;
		StringBuffer sb = new StringBuffer();
		
		for (Cell cell: cells) {
			sb.append(cell.getLetter().getCharacter());
		}
		
		this.word = sb.toString();
	}

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public String getWord() {
		return word;
	}
}
