package client.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestGame extends TestCase {

	public void testConstructor() {
		Game g = new Game();
		assertEquals(0, g.getPlayers().size());
	}

	public void testGetCurrentPlayer() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i / 4, i % 4);
			Letter letter = new Letter("A");
			cells.add(new Cell(location, letter));
		}
		Location l1 = new Location(1, 2);
		Player p1 = new Player("Ann", 10, l1);
		Game g = new Game(p1);
		assertEquals(p1.name, g.getCurrentPlayer().name);
		assertEquals(p1.getScore(), g.getCurrentPlayer().getScore());
		assertEquals(p1.getOriginPosition(), g.getCurrentPlayer()
				.getOriginPosition());
	}

	public void testaddPlayer() {
		Game g = new Game();
		Location l1 = new Location(1, 2);
		Player p1 = new Player("Ann", 10, l1);
		g.addPlayer(p1);
		assertEquals(1, g.getPlayers().size());
	}

	public void testsetGameID() {
		Game g = new Game();
		g.setGameId("gameid");
		assertEquals("gameid", g.getGameId());
	}

	public void testCalculateValid() {
		Game g = new Game();
		Location l1 = new Location(1, 2);
		Player p1 = new Player("Ann", 10, l1);
		g.addPlayer(p1);
		g.currentPlayer = p1;
		ArrayList<Cell> cells = new ArrayList<Cell>();

		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		cells.add(new Cell(location1, letter1));

		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("A");
		cells.add(new Cell(location2, letter2));

		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("L");
		cells.add(new Cell(location3, letter3));

		Word w = new Word(cells);
		assertEquals(2240, g.calculate(w));
	}

	public void testCalculateNotValid() {
		Game g = new Game();
		Location l1 = new Location(1, 2);
		Player p1 = new Player("Ann", 10, l1);
		g.addPlayer(p1);
		g.currentPlayer = p1;
		ArrayList<Cell> cells = new ArrayList<Cell>();

		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		cells.add(new Cell(location1, letter1));

		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("Qu");
		cells.add(new Cell(location2, letter2));

		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("L");
		cells.add(new Cell(location3, letter3));

		Word w = new Word(cells);
		assertEquals(0, g.calculate(w));
	}

	public void testCalculateQu() {
		Game g = new Game();
		Location l1 = new Location(1, 2);
		Player p1 = new Player("Ann", 10, l1);
		g.addPlayer(p1);
		g.currentPlayer = p1;
		ArrayList<Cell> cells = new ArrayList<Cell>();

		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("Qu");
		cells.add(new Cell(location1, letter1));

		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("I");
		cells.add(new Cell(location2, letter2));

		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("N");
		cells.add(new Cell(location3, letter3));

		Word w = new Word(cells);
		assertEquals(9600, g.calculate(w));
	}

	public void testCalculateOverLap() {
		Game g = new Game();
		Location l1 = new Location(1, 2);
		Player p1 = new Player("Ann", 10, l1);
		Location l2 = new Location(1, 2);
		Player p2 = new Player("Tom", 10, l2);
		g.addPlayer(p1);
		g.addPlayer(p2);
		g.currentPlayer = p1;
		ArrayList<Cell> cells = new ArrayList<Cell>();

		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("Qu");
		cells.add(new Cell(location1, letter1));

		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("I");
		cells.add(new Cell(location2, letter2));

		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("N");
		cells.add(new Cell(location3, letter3));

		Word w = new Word(cells);
		assertEquals(19200, g.calculate(w));
	}

	public void testCalculateMult() {
		Game g = new Game();
		Location l1 = new Location(1, 2);
		Player p1 = new Player("Ann", 10, l1);
		g.addPlayer(p1);
		g.currentPlayer = p1;
		ArrayList<Cell> cells = new ArrayList<Cell>();

		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		letter1.setMultiplier();
		cells.add(new Cell(location1, letter1));

		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("A");
		cells.add(new Cell(location2, letter2));

		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("L");
		cells.add(new Cell(location3, letter3));

		Word w = new Word(cells);

		assertEquals(22400, g.calculate(w));
	}

	public void testsetManagerPlayer() {
		Game g = new Game();
		Location l1 = new Location(1, 2);
		Player p1 = new Player("Ann", 10, l1);
		g.setManagingPlayer(p1);
		assertEquals("Ann", g.getManagingPlayer().name);
		assertEquals(10, g.getManagingPlayer().getScore());
		assertEquals(l1, g.getManagingPlayer().getOriginPosition());
	}

	public void testSetBoardhasBonus() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i / 4, i % 4);
			Letter letter = new Letter("A");
			cells.add(new Cell(location, letter));
		}

		Game g = new Game();
		Location location = new Location(1, 1);
		g.setBoard(cells, location);
		assertEquals(16, g.getBoard().getCells().size());
	}

	public void testSetBoardnoBonus() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i / 4, i % 4);
			Letter letter = new Letter("A");
			cells.add(new Cell(location, letter));
		}

		Game g = new Game();
		Location location = new Location(20, 1);
		g.setBoard(cells, location);
		assertEquals(16, g.getBoard().getCells().size());
	}

}
