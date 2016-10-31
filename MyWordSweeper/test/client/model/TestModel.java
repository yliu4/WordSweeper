package client.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestModel extends TestCase {
	public void testSetgame() {
		Model m = new Model();
		ArrayList<Cell> cells = new ArrayList<Cell>();
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i / 4, i % 4);
			Letter letter = new Letter("A");
			cells.add(new Cell(location, letter));
		}
		Location l1 = new Location(1, 2);
		Player p1 = new Player("Ann", 10, l1);
		Location l2 = new Location(3, 2);
		Player p2 = new Player("Tom", 1, l2);
		Game g = new Game(p1);
		g.addPlayer(p1);
		g.addPlayer(p2);
		m.setGame(g);
		assertEquals(2, m.getGame().getPlayers().size());
	}

	public void testsetFilledBoard() {
		Model m = new Model();
		m.setFilledBoard(1, 2, 3, 4);
		assertEquals(3, m.getFilledBoard().width);
		assertEquals(4, m.getFilledBoard().height);
	}

	public void testsetFilledBoardwrongxy() {
		Model m = new Model();
		m.setFilledBoard(-1, -1, 3, 4);
		assertNull(m.getFilledBoard());
	}

	public void testgetFilledBoard() {
		Model m = new Model();
		m.setFilledBoard(1, 2, 3, 4);
		assertEquals(0, m.getFilledBoard().getColumn());
		assertEquals(0, m.getFilledBoard().getRow());
	}

}
