package client.model;

import java.util.*;

/**
 * The Board contains 16 Cells.
 * 
 * @author Team Pisces
 */
public class Board {
	/** The List holding the 16 Cells. */
	ArrayList<Cell> cells = new ArrayList<Cell>(16);
	
	/** 
	 * Construct the Board with a List of Cells.
	 * 
	 * @param cells The List of Cells.
	 */
	public Board(ArrayList<Cell> cells) {
		this.cells = new ArrayList<Cell>(cells);
	}
	
	/** 
	 * Set the Cells with the given List of Cells. 
	 * 
	 * @param cells The List of Cells.
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = new ArrayList<Cell>(cells);
	}
	
	/** 
	 * Get the object of the List of Cells.
	 * 
	 * @return A List of Cells.
	 */
	public ArrayList<Cell> getCells() {
		return cells;
	}

	@Override
	public boolean equals(Object obj) {
		Board other = (Board) obj;
		for(int i=0;i<this.getCells().size();i++){
			if (!this.getCells().get(i).equals(other.getCells().get(i))){
				return false;
			}
		}
		return true;
	}
	
}
