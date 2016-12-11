package client.view;

import java.util.ArrayList;

import client.MockServerAccess;
import client.model.Cell;
import client.model.Game;
import client.model.Letter;
import client.model.Location;
import client.model.Model;
import client.model.Player;
import client.view.Application;
import junit.framework.TestCase;

/**
 * The TestApplication class test the Application class in the view
 * 
 * @author Team Pisces
 *
 */
public class TestApplication extends TestCase {
	/** Mock server object that extends (and overrides) ServerAccess for its purposes */
	MockServerAccess mockServer;

	/** client to connect */
	Application app;

	/** model being maintained by client. */
	Model model;

	protected void setUp() {
	    /** prepare client and connect to server.*/
		model = new Model();
		app = new Application(model);
		app.setVisible(true);

		/** 
		 * Create mockServer to simulate server, and install 'obvious' handler
		 * that simply dumps to the screen the responses.
		 */
		mockServer = new MockServerAccess("localhost");

		/** as far as the client is concerned, it gets a real object with which to communicate.*/
		app.setServerAccess(mockServer);
	}

	/** test gotoCreateGamePanel */
	public void testGotoCreateGamePanel() {
		app.gotoCreateGamePanel();
		assertTrue(app.getCreateGamePanel().isVisible());
		assertFalse(app.getMenuPanel().isVisible());
	}

	/** test gotoJoinGamePanel */
	public void testGotoJoinGamePanel() {
		app.gotoJoinGamePanel();
		assertTrue(app.getJoinGamePanel().isVisible());
		assertFalse(app.getMenuPanel().isVisible());
	}

	/** test gotoOnlineGamePanel */
	public void testGotoOnlineGamePanel() {
		app.gotoOnlineGamePanel();
		app.gotoMainMenu();
		
		Game game = new Game(new Player("Ann", 10, new Location(1, 2)));
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
		
		model.setGame(game);
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
		cells.add(cell0); cells.add(cell1); cells.add(cell2); cells.add(cell3);
		cells.add(cell4); cells.add(cell5); cells.add(cell6); cells.add(cell7);
		cells.add(cell8); cells.add(cell9); cells.add(cell10); cells.add(cell11);
		cells.add(cell12); cells.add(cell3); cells.add(cell14); cells.add(cell15);
		game.setBoard(cells, new Location(-1, -1));
		
		app.gotoPraticeGamePanel();
	}
}
