package client.model;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * The <code>TestBoard</code> class tests the <code>Board</code> class.
 * 
 * @author Team Pisces
 *
 */
public class TestBoard extends TestCase {
	/** Test the constructor. */
	public void testConstructor() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i/4, i%4);
			Letter letter = new Letter("A");
			
			cells.add(new Cell(location, letter));
		}
		
		Board board = new Board(cells);
		
		assertEquals(cells.get(10), board.getCells().get(10));
	}
	
	/** Test the setCells method. */
	public void testSetCells() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i/4, i%4);
			Letter letter = new Letter("A");
			
			cells.add(new Cell(location, letter));
		}
		
		Board board = new Board(cells);
		
		ArrayList<Cell> newCells = new ArrayList<Cell>();
		
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i/4, i%4);
			Letter letter = new Letter("B");
			
			newCells.add(new Cell(location, letter));
		}
		board.setCells(newCells);
		
		assertEquals(newCells.get(10), board.getCells().get(10));
		assertEquals(false, cells.get(10).equals(board.getCells().get(10)));
	}
}
