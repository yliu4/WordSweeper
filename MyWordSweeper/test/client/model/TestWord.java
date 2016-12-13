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
		Word word = new Word();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("N");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("D");
		
		word.add(new Cell(location1, letter1));
		word.add(new Cell(location2, letter2));
		word.add(new Cell(location3, letter3));
		
		assertTrue("AND".equals(word.getWord()));
	}

	/** Test the getCells method. */
	public void testGetCells() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Word word = new Word();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("N");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("D");

		cells.add(new Cell(location1, letter1));
		cells.add(new Cell(location2, letter2));
		cells.add(new Cell(location3, letter3));
		word.add(new Cell(location1, letter1));
		word.add(new Cell(location2, letter2));
		word.add(new Cell(location3, letter3));

		ArrayList<Cell> testList = word.getCells();
		
		assertEquals(testList, cells);
	}
	
	/** Test the contains method. */
	public void testContains() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Word word = new Word();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("N");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("D");
		
		Cell cell1 = new Cell(location1, letter1);
		Cell cell2 = new Cell(location2, letter2);
		Cell cell3 = new Cell(location3, letter3);
		cells.add(cell1);
		cells.add(cell2);
		cells.add(cell3);
		word.add(cell1);
		word.add(cell2);
		word.add(cell3);
		
		assertEquals(true, word.contains(cell1));
		assertEquals(true, word.contains(cell2));
		assertEquals(true, word.contains(cell3));
	}
	
	/** Test the clear method. */
	public void testClear() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Word word = new Word();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("N");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("D");
		
		Cell cell1 = new Cell(location1, letter1);
		Cell cell2 = new Cell(location2, letter2);
		Cell cell3 = new Cell(location3, letter3);
		cells.add(cell1);
		cells.add(cell2);
		cells.add(cell3);
		word.add(cell1);
		word.add(cell2);
		word.add(cell3);
		
		word.clear();
		
		assertEquals(0, word.getCells().size());
	}
	
	/** Test the isNew method. */
	public void testIsNew() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Word word = new Word();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		
		Cell cell = new Cell(location1, letter1);
		cells.add(cell);
		word.add(new Cell(location1, letter1));

		assertEquals(true, word.isNew(cell));
	}
	
	/** Test the isClose2Pre method. */
	public void testIsClose2Pre() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Word word = new Word();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("N");
		
		Cell cell1 = new Cell(location1, letter1);
		Cell cell2 = new Cell(location2, letter2);
		cells.add(cell1);
		cells.add(cell2);
		word.add(cell1);
		word.add(cell2);

		assertEquals(true, word.isClose2Pre(cell1));
	}
}
