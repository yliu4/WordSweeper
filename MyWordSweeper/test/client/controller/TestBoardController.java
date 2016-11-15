package client.controller;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.Cell;
import client.model.Game;
import client.model.Model;
import client.view.Application;
import client.view.BoardPanel;
import junit.framework.TestCase;

/**
 * 
 * This test class tests for the board controller
 * 
 * @author Team Pisces
 *
 */
public class TestBoardController extends TestCase{
	// Mock server object that extends (and overrides) ServerAccess for its
	// purposes
	MockServerAccess mockServer;

	// client to connect
	Application client;

	// model being maintained by client.
	Model model;

	protected void setUp() {
		// FIRST thing to do is register the protocol being used.
		if (!Message.configure("wordsweeper.xsd")) {
			fail("unable to configure protocol");
		}

		// prepare client and connect to server.
		model = new Model();
		client = new Application(model);
		client.setVisible(true);

		// Create mockServer to simulate server, and install 'obvious' handler
		// that simply dumps to the screen the responses.
		mockServer = new MockServerAccess("localhost");

		// as far as the client is concerned, it gets a real object with which
		// to communicate.
		client.setServerAccess(mockServer);
	}
	
	/** 
	 * testMouseEvent tests for the mouse press, drag and release
	 * 
	 */
	public void  testMouseEvent()
	{
		PracticeGameController practiceController = new PracticeGameController(model, client);
		practiceController.process();
		Game game = practiceController.getGame();
		
		ArrayList<Cell> cells = game.getBoard().getCells();

		BoardPanel boardPanel = new BoardPanel(model, client, cells);
		BoardController boardController = boardPanel.getBoardController();
		
		MouseEvent pressEvent = new MouseEvent(
				boardPanel, MouseEvent.MOUSE_PRESSED, 1, 0,
				29, 26, 1, false,MouseEvent.BUTTON1);
		boardController.mousePressed(pressEvent);
		
		MouseEvent dragEvent = new MouseEvent(
				boardPanel, MouseEvent.MOUSE_DRAGGED, 1, 0,
			80, 135, 1, false,MouseEvent.BUTTON1);
		boardController.mouseDragged(dragEvent);
		
		MouseEvent releaseEvent = new MouseEvent(
				boardPanel, MouseEvent.MOUSE_RELEASED, 1, 0,
				136, 72, 1, false,MouseEvent.BUTTON1);
		boardController.mouseReleased(releaseEvent);	
	}
	
}
