package client.model;

import junit.framework.TestCase;
import client.model.*;

public class TestCell extends TestCase {
	public void testConstructor() {
		Location lo = new Location(1, 2);
		Letter le = new Letter("A");
		
		Cell cell = new Cell(lo, le);
		
		assertEquals(lo, cell.getLocation());
		assertEquals(le, cell.getLetter());
	}
	
	public void testSetLetter() {
		Location lo = new Location(1, 2);
		Letter le = new Letter("A");
		
		Cell cell = new Cell(lo, le);
		Letter letter = new Letter("B");
		cell.setLetter(letter);
		
		assertEquals(letter, cell.getLetter());
		assertEquals(false, le.equals(cell.getLetter()));
	}
}
