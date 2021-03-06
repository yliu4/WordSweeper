package client.model;

import java.util.ArrayList;

import junit.framework.TestCase;

/**
 * The <code>TestModel</code> class tests the <code>Model</code> class.
 * 
 * @author Team Pisces
 *
 */
public class TestModel extends TestCase {
	/** Test the setGame method. */
	public void testSetGame() {
		Model model = new Model();
		ArrayList<Cell> cells = new ArrayList<Cell>();
		
		for (int i = 0; i < 16; i++) {
			Location location = new Location(i / 4, i % 4);
			Letter letter = new Letter("A");
			
			cells.add(new Cell(location, letter));
		}
		
		Location locationOfPlayer1 = new Location(1, 2);
		Player player1 = new Player("Ann", 10, locationOfPlayer1);
		Location locationOfPlayer2 = new Location(3, 2);
		Player player2 = new Player("Tom", 1, locationOfPlayer2);
		Game game = new Game(player1);
		
		game.addPlayer(player1);
		game.addPlayer(player2);
		model.setGame(game);
		
		assertEquals(2, model.getGame().getPlayers().size());
	}
}
