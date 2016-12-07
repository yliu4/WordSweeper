package client.controller;

import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.Model;
import client.view.Application;
import junit.framework.TestCase;

public class TestLockGameController extends TestCase {
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
	 * The real test case whose purpose is to validate that send lock game request to
	 * the server.
	 */
	public void testLockGameProcess() {
		new OpenCreateGamePanelController(model, client).process();

		// create a private game with password and user name
		CreateGameController c1 = new CreateGameController(model, client);
		client.getCreateGamePanel().getTextFieldNickname().setText("yuchen");
		client.getCreateGamePanel().getTextFieldPassword().setText("123");
		client.getCreateGamePanel().getRdbtnPrivate().setSelected(true);
		c1.process();

		new LockGameController(model, client).process();

		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 2);
		Message r = reqs.get(0);
		assertEquals("createGameRequest", r.contents.getFirstChild()
				.getLocalName());
		r = reqs.get(1);
		assertEquals("lockGameRequest", r.contents.getFirstChild()
				.getLocalName());
	}
}
