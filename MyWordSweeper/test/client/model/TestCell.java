package client.model;

import client.view.CellDrawer;
import junit.framework.TestCase;

/**
 * The <code>TestCell</code> class tests the <code>Cell</code> class.
 * 
 * @author Team Pisces
 *
 */
public class TestCell extends TestCase {
	/** Test the constructor. */
	public void testConstructor() {
		Location location = new Location(1, 2);
		Letter letter = new Letter("A");
		Cell cell = new Cell(location, letter);
		
		assertEquals(location, cell.getLocation());
		assertEquals(letter, cell.getLetter());
	}
	
	/** Test the equals method. */
	public void testEquals() {
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Cell cell1 = new Cell(location1, letter1);
		
		Location location2 = new Location(1, 2);
		Letter letter2 = new Letter("A");
		Cell cell2 = new Cell(location2, letter2);
		
		assertEquals(cell1, cell2);
		assertFalse(cell1.equals(null));
	}
	
	/** Test the setDrawer and getDrawer method. */
	public void testDrawer() {
		Location location = new Location(1, 2);
		Letter letter = new Letter("A");
		Cell cell = new Cell(location, letter);
		
		CellDrawer setDrawer = new CellDrawer();
		cell.setDrawer(setDrawer);
	
		assertEquals(setDrawer, cell.getDrawer());
	}
	
	/** Test the setCounter and getCounter method. */
	public void testCounter() {
		Location location = new Location(1, 2);
		Letter letter = new Letter("A");
		Cell cell = new Cell(location, letter);
		int counter = 10;

		cell.setCounter(counter);
		
		assertEquals(counter, cell.getCounter());
	}
}
