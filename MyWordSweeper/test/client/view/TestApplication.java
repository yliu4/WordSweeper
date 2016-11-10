package client.view;

import client.MockServerAccess;
import client.model.Model;
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
		app.gotoPraticeGamePanel();
	}
}
