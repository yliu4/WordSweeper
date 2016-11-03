package client.model;

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
	
	/** Test the setLetter method. */
	public void testSetLetter() {
		Location location = new Location(1, 2);
		Letter letter = new Letter("A");
		Cell cell = new Cell(location, letter);
		Letter newLetter = new Letter("B");
		
		cell.setLetter(newLetter);
		
		assertEquals(newLetter, cell.getLetter());
		assertEquals(false, letter.equals(cell.getLetter()));
	}
}
