package client.model;

import junit.framework.TestCase;

public class TestLocation extends TestCase {

	public void testConstructor() {
		Location location = new Location(1, 2);
		assertEquals(1, location.getRow());
		assertEquals(2, location.getColumn());
	}

	public void testSetPanelLocation() {
		Location location = new Location(1, 2);
		location.setPanelLocation(1, 2, 3, 4);
		assertEquals(1, location.getCoordinateX());
		assertEquals(2, location.getCoordinateY());
		assertEquals(3, location.width);
		assertEquals(4, location.height);
	}

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
