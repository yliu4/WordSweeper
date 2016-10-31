package client.model;

import junit.framework.TestCase;

public class TestPlayer extends TestCase {
	public void testgetScore() {
		Location l = new Location(1, 2);
		Player p = new Player("Ann", 10, l);
		assertEquals(10, p.getScore());
	}

	public void testsetScore() {
		Location l = new Location(1, 2);
		Player p = new Player("Ann", 10, l);
		p.setScore(11);
		assertEquals(11, p.getScore());
	}

	public void testgetOriginalPoint() {
		Location l = new Location(1, 2);
		Player p = new Player("Ann", 10, l);
		assertEquals(l, p.getOriginPosition());
	}

	public void testsetOriginalPoint() {
		Location l1 = new Location(1, 2);
		Location l2 = new Location(1, 2);
		Player p = new Player("Ann", 10, l1);
		p.setOriginPosition(l2);
		assertEquals(l2, p.getOriginPosition());
	}

}
