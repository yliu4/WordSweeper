package client.model;

import java.util.ArrayList;

import client.view.CellDrawer;

import junit.framework.TestCase;

/**
 * The <code>TestGame</code> class tests the <code>Game</code> class.
 * 
 * @author Team Pisces
 *
 */
public class TestGame extends TestCase {
	/** Test the constructor. */
	public void testConstructor() {
		Game game = new Game();
		
		assertEquals(0, game.getPlayers().size());
	}

	/** Test the getCurrentPlayer method. */
	public void testGetCurrentPlayer() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i / 4, i % 4);
			Letter letter = new Letter("A");
			
			cells.add(new Cell(location, letter));
		}
		
		Location myLocation = new Location(1, 2);
		Player player = new Player("Ann", 10, myLocation);
		Game game = new Game(player);
		
		assertEquals(player.name, game.getCurrentPlayer().name);
		assertEquals(player.getScore(), game.getCurrentPlayer().getScore());
		assertEquals(player.getOriginPosition(), game.getCurrentPlayer()
				.getOriginPosition());
	}

	/** Test the addPlayer method. */
	public void testAddPlayer() {
		Game game = new Game();
		Location location = new Location(1, 2);
		Player player = new Player("Ann", 10, location);
		
		game.addPlayer(player);
		
		assertEquals(1, game.getPlayers().size());
	}

	/** Test the setGameID method. */
	public void testSetGameID() {
		Game game = new Game();
		
		game.setGameId("gameid");
		
		assertEquals("gameid", game.getGameId());
	}

	/** Test the calculate method with valid word. */
	public void testCalculateValid() {
		Location locationOfPlayer = new Location(1, 2);
		Game game = new Game(new Player("Ann", 10, locationOfPlayer));
		Word word = new Word();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("A");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("L");
		
		word.add(new Cell(location1, letter1));
		word.add(new Cell(location2, letter2));
		word.add(new Cell(location3, letter3));
		
		assertEquals(560, game.calculate(word));
	}

	/** Test the calculate method with invalid word. */
	public void testCalculateNotValid() {
		Location locationOfPlayer = new Location(1, 2);
		Game game = new Game(new Player("Ann", 10, locationOfPlayer));
		Word word = new Word();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("Qu");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("L");
		
		word.add(new Cell(location1, letter1));
		word.add(new Cell(location2, letter2));
		word.add(new Cell(location3, letter3));
		
		assertEquals(0, game.calculate(word));
	}

	/** Test the calculate method with word that contains "Qu". */
	public void testCalculateQu() {
		Location locationOfPlayer = new Location(1, 2);
		Game game = new Game(new Player("Ann", 10, locationOfPlayer));
		Word word = new Word();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("Qu");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("I");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("T");
		
		word.add(new Cell(location1, letter1));
		word.add(new Cell(location2, letter2));
		word.add(new Cell(location3, letter3));

		assertEquals(1120, game.calculate(word));
	}

	/** Test the calculate method with word that contains overlapped cell(s). */
	public void testCalculateHasOverlap() {
		Game game = new Game();
		Location locationOfPlayer1 = new Location(1, 2);
		Player player1 = new Player("Ann", 10, locationOfPlayer1);
		Location locationOfPlayer2 = new Location(1, 2);
		Player player2 = new Player("Tom", 10, locationOfPlayer2);
		Word word = new Word();
		Cell cell0 = new Cell(new Location(0, 0), new Letter("Qu"));
		Cell cell1 = new Cell(new Location(0, 1), new Letter("I"));
		Cell cell2 = new Cell(new Location(0, 2), new Letter("T"));
		Cell cell3 = new Cell(new Location(0, 3), new Letter("T"));
		Cell cell4 = new Cell(new Location(1, 0), new Letter("Qu"));
		Cell cell5 = new Cell(new Location(1, 1), new Letter("I"));
		Cell cell6 = new Cell(new Location(1, 2), new Letter("T"));
		Cell cell7 = new Cell(new Location(1, 3), new Letter("T"));
		Cell cell8 = new Cell(new Location(2, 0), new Letter("Qu"));
		Cell cell9 = new Cell(new Location(2, 1), new Letter("I"));
		Cell cell10 = new Cell(new Location(2, 2), new Letter("T"));
		Cell cell11 = new Cell(new Location(2, 3), new Letter("T"));
		Cell cell12 = new Cell(new Location(3, 0), new Letter("Qu"));
		Cell cell13 = new Cell(new Location(3, 1), new Letter("I"));
		Cell cell14 = new Cell(new Location(3, 2), new Letter("T"));
		Cell cell15 = new Cell(new Location(3, 3), new Letter("T"));
		ArrayList<Cell> cells = new ArrayList<Cell>(16);

		word.add(cell0); word.add(cell1); word.add(cell2);
		cells.add(cell0); cells.add(cell1); cells.add(cell2); cells.add(cell3);
		cells.add(cell4); cells.add(cell5); cells.add(cell6); cells.add(cell7);
		cells.add(cell8); cells.add(cell9); cells.add(cell10); cells.add(cell11);
		cells.add(cell12); cells.add(cell3); cells.add(cell14); cells.add(cell15);
		cell0.setDrawer(new CellDrawer());
		cell1.setDrawer(new CellDrawer());
		cell2.setDrawer(new CellDrawer());
		cell3.setDrawer(new CellDrawer());
		cell4.setDrawer(new CellDrawer());
		cell5.setDrawer(new CellDrawer());
		cell6.setDrawer(new CellDrawer());
		cell7.setDrawer(new CellDrawer());
		cell8.setDrawer(new CellDrawer());
		cell9.setDrawer(new CellDrawer());
		cell10.setDrawer(new CellDrawer());
		cell11.setDrawer(new CellDrawer());
		cell12.setDrawer(new CellDrawer());
		cell13.setDrawer(new CellDrawer());
		cell14.setDrawer(new CellDrawer());
		cell15.setDrawer(new CellDrawer());
		game.setBoard(cells, new Location(-1, -1));
		game.addPlayer(player1);
		game.addPlayer(player2);
		game.currentPlayer = player1;
		game.overlapCheck();		

		assertEquals(4480, game.calculate(word));
	}

	/** Test the calculate method with word that contains a multiplier. */
	public void testCalculateMultiplier() {
		Game game = new Game();
		Location locationOfPlayer = new Location(1, 2);
		Player player = new Player("Ann", 10, locationOfPlayer);
		Word word = new Word();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("A");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("L");
		
		game.addPlayer(player);
		game.currentPlayer = player;
		letter1.setMultiplier();
		word.add(new Cell(location1, letter1));
		word.add(new Cell(location2, letter2));
		word.add(new Cell(location3, letter3));

		assertEquals(5600, game.calculate(word));
	}

	/** Test the setBoard method with a board that has a multiplier. */
	public void testSetBoardHasBonus() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Game game = new Game();
		Location locationOfBonus = new Location(1, 1);
		
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i / 4, i % 4);
			Letter letter = new Letter("A");
			
			cells.add(new Cell(location, letter));
		}

		game.setBoard(cells, locationOfBonus);
		assertEquals(16, game.getBoard().getCells().size());
	}

	/** Test the setBoard method with a board that doesn't have a multiplier. */
	public void testSetBoardNoBonus() {
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Game game = new Game();
		Location locationOfBonus = new Location(20, 1);
		
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i / 4, i % 4);
			Letter letter = new Letter("A");
			
			cells.add(new Cell(location, letter));
		}

		game.setBoard(cells, locationOfBonus);
		
		assertEquals(16, game.getBoard().getCells().size());
	}
	
	/** Test the sortPlayers method */
	public void testSortPlayers() {
		Game game = new Game();
		Location locationOfPlayer1 = new Location(1, 2);
		Player player1 = new Player("Ann", 10, locationOfPlayer1);
		Location locationOfPlayer2 = new Location(1, 2);
		Player player2 = new Player("Tom", 10, locationOfPlayer2);
		
		game.addPlayer(player1);
		game.addPlayer(player2);
		
		player1.setScore(100);
		player2.setScore(200);
		
		game.sortPlayers();
		
		ArrayList<Player> list = game.getPlayers();
		
		assertEquals(true, list.get(0).name.equals("Tom") && list.get(1).name.equals("Ann"));
	}
}
