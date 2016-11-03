package client.model;

import java.util.*;

/**
 * The Board contains 16 cells and the user 
 * can get and set the cell
 * 
 * @author Team Pisces
 */
public class Board {
	/** Create the 16 cells */
	ArrayList<Cell> cells = new ArrayList<Cell>(16);
	
	/** Construct the board with a list of cells */
	public Board(ArrayList<Cell> cells) {
		this.cells = new ArrayList<Cell>(cells);
	}
	
	/** Set the cells with the given list of cells */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = new ArrayList<Cell>(cells);
	}
	
	/** Get the cell object */
	public ArrayList<Cell> getCells() {
		return cells;
	}
}
