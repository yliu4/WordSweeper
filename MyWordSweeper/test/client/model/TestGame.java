package client.model;

import java.util.ArrayList;

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
		Game game = new Game();
		Location locationOfPlayer = new Location(1, 2);
		Player player = new Player("Ann", 10, locationOfPlayer);
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("A");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("L");
		
		game.addPlayer(player);
		game.currentPlayer = player;
		cells.add(new Cell(location1, letter1));
		cells.add(new Cell(location2, letter2));
		cells.add(new Cell(location3, letter3));
		
		Word word = new Word(cells);
		
		assertEquals(2240, game.calculate(word));
	}

	/** Test the calculate method with invalid word. */
	public void testCalculateNotValid() {
		Game game = new Game();
		Location locationOfPlayer = new Location(1, 2);
		Player player = new Player("Ann", 10, locationOfPlayer);
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("Qu");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("L");
		
		game.addPlayer(player);
		game.currentPlayer = player;
		cells.add(new Cell(location1, letter1));
		cells.add(new Cell(location2, letter2));
		cells.add(new Cell(location3, letter3));

		Word word = new Word(cells);
		
		assertEquals(0, game.calculate(word));
	}

	/** Test the calculate method with word that contains "Qu". */
	public void testCalculateQu() {
		Game game = new Game();
		Location locationOfPlayer = new Location(1, 2);
		Player player = new Player("Ann", 10, locationOfPlayer);
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("Qu");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("I");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("N");
		
		game.addPlayer(player);
		game.currentPlayer = player;
		cells.add(new Cell(location1, letter1));
		cells.add(new Cell(location2, letter2));
		cells.add(new Cell(location3, letter3));

		Word word = new Word(cells);
		
		assertEquals(4800, game.calculate(word));
	}

	/** Test the calculate method with word that contains overlapped cell(s). */
	public void testCalculateHasOverlap() {
		Game game = new Game();
		Location locationOfPlayer1 = new Location(1, 2);
		Player player1 = new Player("Ann", 10, locationOfPlayer1);
		Location locationOfPlayer2 = new Location(1, 2);
		Player player2 = new Player("Tom", 10, locationOfPlayer2);
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("Qu");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("I");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("N");
		
		game.addPlayer(player1);
		game.addPlayer(player2);
		game.currentPlayer = player1;
		cells.add(new Cell(location1, letter1));
		cells.add(new Cell(location2, letter2));
		cells.add(new Cell(location3, letter3));

		Word word = new Word(cells);
		
		assertEquals(9600, game.calculate(word));
	}

	/** Test the calculate method with word that contains a multiplier. */
	public void testCalculateMultiplier() {
		Game game = new Game();
		Location locationOfPlayer = new Location(1, 2);
		Player player = new Player("Ann", 10, locationOfPlayer);
		ArrayList<Cell> cells = new ArrayList<Cell>();
		Location location1 = new Location(1, 2);
		Letter letter1 = new Letter("A");
		Location location2 = new Location(1, 3);
		Letter letter2 = new Letter("A");
		Location location3 = new Location(1, 4);
		Letter letter3 = new Letter("L");
		
		game.addPlayer(player);
		game.currentPlayer = player;
		letter1.setMultiplier();
		cells.add(new Cell(location1, letter1));
		cells.add(new Cell(location2, letter2));
		cells.add(new Cell(location3, letter3));

		Word word = new Word(cells);

		assertEquals(22400, game.calculate(word));
	}

	/** Test the setManagingPlayer method. */
	public void testSetManagingPlayer() {
		Game game = new Game();
		Location location = new Location(1, 2);
		Player player = new Player("Ann", 10, location);
		
		game.setManagingPlayer(player);
		
		assertEquals("Ann", game.getManagingPlayer().name);
		assertEquals(10, game.getManagingPlayer().getScore());
		assertEquals(location, game.getManagingPlayer().getOriginPosition());
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
}
