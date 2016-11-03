package client.model;

import junit.framework.TestCase;

/**
 * The <code>TestLocation</code> class tests the <code>Location</code> class.
 * 
 * @author Team Pisces
 *
 */
public class TestLocation extends TestCase {
	/** Test the constructor. */
	public void testConstructor() {
		Location location = new Location(1, 2);
		
		assertEquals(1, location.getRow());
		assertEquals(2, location.getColumn());
	}

	/** Test the setPanelLocation method. */
	public void testSetPanelLocation() {
		Location location = new Location(1, 2);
		
		location.setPanelLocation(1, 2, 3, 4);
		
		assertEquals(1, location.getCoordinateX());
		assertEquals(2, location.getCoordinateY());
		assertEquals(3, location.width);
		assertEquals(4, location.height);
	}

	/** Test the equals method. */
	public void testEquals() {
		Location location1 = new Location(1, 2);
		Location location2 = new Location(1, 2);
		Location location3 = new Location(2, 2);
		Location location4 = new Location(1, 3);
		
		assertTrue(location1.equals(location2));
		assertFalse(location1.equals(location3));
		assertFalse(location1.equals(location4));
	}
}
