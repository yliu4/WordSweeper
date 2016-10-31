package client.model;

import java.util.*;

/**
 * The <code>Board</code> contains 16 <code>Cell</code>s. 
 * 
 * User can get and set <code>Cell</code>s.
 * 
 * @author Team Pisces
 *
 */
public class Board {
	ArrayList<Cell> cells = new ArrayList<Cell>(16);
	
	public Board(ArrayList<Cell> cells) {
		this.cells = new ArrayList<Cell>(cells);
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = new ArrayList<Cell>(cells);
	}
	
	public ArrayList<Cell> getCells() {
		return cells;
	}
}
