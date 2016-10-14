package client.model;

import java.util.*;

/**
 * The board contains 16 cells. User can get and set cells
 * @author team Pisces
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
