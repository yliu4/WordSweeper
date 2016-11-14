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
	
	public void testEquals(){
		ArrayList<Cell> cells1 = new ArrayList<Cell>();
		ArrayList<Cell> cells2 = new ArrayList<Cell>();
		
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i/4, i%4);
			Letter letter = new Letter("A");
			
			cells1.add(new Cell(location, letter));
		}
		
		Board board1 = new Board(cells1);
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i/4, i%4);
			Letter letter = new Letter("B");
			
			cells2.add(new Cell(location, letter));
		}
		
		Board board2 = new Board(cells2);
		assertFalse(board1.equals(board2));
		Board board3 = new Board(cells1);
		assertTrue(board1.equals(board3));
		
	}
}
