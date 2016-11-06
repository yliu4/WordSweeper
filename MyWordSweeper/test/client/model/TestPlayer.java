package client.model;

import junit.framework.TestCase;

/**
 * The <code>TestPlayer</code> class tests the <code>Player</code> class.
 * 
 * @author Team Pisces
 *
 */
public class TestPlayer extends TestCase {
	public void testGetScore() {
		/** Test the getScore method. */
		Location location = new Location(1, 2);
		Player player = new Player("Ann", 10, location);
		
		assertEquals(10, player.getScore());
	}

	/** Test the setScore method. */
	public void testSetScore() {
		Location location = new Location(1, 2);
		Player player = new Player("Ann", 10, location);
		
		player.setScore(11);
		
		assertEquals(11, player.getScore());
	}

	/** Test the getOriginalPoint method. */
	public void testGetOriginalPoint() {
		Location location = new Location(1, 2);
		Player player = new Player("Ann", 10, location);
		
		assertEquals(location, player.getOriginPosition());
	}

	/** Test the setOriginalPoint method. */
	public void testSetOriginalPoint() {
		Location location = new Location(1, 2);
		Location newLocation = new Location(3, 4);
		Player player = new Player("Ann", 10, location);
		
		player.setOriginPosition(newLocation);

		assertEquals(newLocation, player.getOriginPosition());
		assertEquals(false, location.equals(player.getOriginPosition()));
	}

	/** Test the getName method. */
	public void testGetName() {
		Location location = new Location(1, 2);
		Player player = new Player("Ann", 10, location);
		
		assertEquals("Ann", player.getName());
	}
}
