package client.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestWord extends TestCase {

	public void testgetWord() {
		ArrayList<Cell> cells = new ArrayList<Cell>();

		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		cells.add(new Cell(location1, letter1));

		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("N");
		cells.add(new Cell(location2, letter2));

		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("D");
		cells.add(new Cell(location3, letter3));

		Word w = new Word(cells);
		assertTrue("AND".equals(w.getWord()));
	}

	public void testgetCells() {
		ArrayList<Cell> cells = new ArrayList<Cell>();

		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		cells.add(new Cell(location1, letter1));

		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("N");
		cells.add(new Cell(location2, letter2));

		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("D");
		cells.add(new Cell(location3, letter3));

		Word w = new Word(cells);

		ArrayList<Cell> arr = w.getCells();
		assertEquals(arr, cells);
	}
}
