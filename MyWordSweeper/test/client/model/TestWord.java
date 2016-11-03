package client.model;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * The <code>TestWord</code> class tests the <code>Word</code> class.
 * 
 * @author Team Pisces
 *
 */
public class TestWord extends TestCase {
	/** Test the getWord method. */
	public void testGetWord() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("N");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("D");
		
		cells.add(new Cell(location1, letter1));
		cells.add(new Cell(location2, letter2));
		cells.add(new Cell(location3, letter3));
		Word word = new Word(cells);
		
		assertTrue("AND".equals(word.getWord()));
	}

	/** Test the getCells method. */
	public void testGetCells() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("N");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("D");
		
		cells.add(new Cell(location1, letter1));
		cells.add(new Cell(location2, letter2));
		cells.add(new Cell(location3, letter3));
		Word word = new Word(cells);

		ArrayList<Cell> testList = word.getCells();
		
		assertEquals(testList, cells);
	}
}
