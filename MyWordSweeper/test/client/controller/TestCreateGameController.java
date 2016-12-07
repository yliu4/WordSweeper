package client.controller;

import java.util.ArrayList;

import client.MockServerAccess;
import client.controller.RepositionBoardController.ShiftDirection;
import client.model.Model;
import client.view.Application;
import xml.Message;
import junit.framework.TestCase;

/**
 * This test case is needed when the job of a controller is to send a Request to
 * the server.
 * <P>
 * To make this work we need to create a "mock" Server whose only purpose is to
 * WAIT for requests to come from the client being pressed into service here in
 * this test case.
 * 
 * @author Team Pisces
 */
public class TestCreateGameController extends TestCase {

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
	 * The real test case whose purpose is to validate that selecting the Locked
	 * button sends a GrabLock request to the server.
	 */
	public void testOpenCreateGamePanelProcess() {
		new OpenCreateGamePanelController(model, client).process();

		assertFalse(client.getMenuPanel().isVisible());
		assertTrue(client.getCreateGamePanel().isVisible());

		// create a private game with password and user name
		CreateGameController c1 = new CreateGameController(model, client);
		client.getCreateGamePanel().getTextFieldNickname().setText("yuchen");
		client.getCreateGamePanel().getTextFieldPassword().setText("123");
		client.getCreateGamePanel().getRdbtnPrivate().setSelected(true);
		c1.process();
		ArrayList<Message> reqs = mockServer.getAndClearMessages();
		assertTrue(reqs.size() == 1);
		Message r = reqs.get(0);
		assertEquals("createGameRequest", r.contents.getFirstChild()
				.getLocalName());
		assertEquals("yuchen", r.contents.getFirstChild().getAttributes()
				.getNamedItem("name").getNodeValue());
		assertEquals("123", r.contents.getFirstChild().getAttributes()
				.getNamedItem("password").getNodeValue());

		// create a public game with password and user name
		CreateGameController c2 = new CreateGameController(model, client);
		client.getCreateGamePanel().getTextFieldNickname().setText("yuchen");
		c2.process();

		// create a private game with password and without user name
		// expect pop up warning
		CreateGameController c3 = new CreateGameController(model, client);
		client.getCreateGamePanel().getTextFieldNickname().setText("");
		client.getCreateGamePanel().getTextFieldPassword().setText("123");
		client.getCreateGamePanel().getRdbtnPrivate().setSelected(true);
		c3.setSkipPopupWindow();
		c3.process();
		assertEquals(c3.getIsMissingNickName(), true);

		// create a private game without password and with user name
		// expect pop up warning
		CreateGameController c4 = new CreateGameController(model, client);
		client.getCreateGamePanel().getTextFieldNickname().setText("yuchen");
		client.getCreateGamePanel().getTextFieldPassword().setText("");
		client.getCreateGamePanel().getRdbtnPrivate().setSelected(true);
		c4.setSkipPopupWindow();
		c4.process();
		assertEquals(c4.getIsMissingPassword(), true);

		new ChoosePrivateController(client).process();
		assertTrue(client.getCreateGamePanel().getTextFieldPassword()
				.isEditable());

		new ChoosePublicController(client).process();
		assertFalse(client.getCreateGamePanel().getTextFieldPassword()
				.isEditable());
		
		reqs = mockServer.getAndClearMessages();
		new ResetGameController(model, client).process();
		reqs = mockServer.getAndClearMessages();
		assertEquals(1, reqs.size());
		r = reqs.get(0);
		assertEquals("resetGameRequest", r.contents.getFirstChild()
				.getLocalName());
		
		reqs = mockServer.getAndClearMessages();
		new RepositionBoardController(model, client).process(ShiftDirection.Up);
		new RepositionBoardController(model, client).process(ShiftDirection.Down);
		new RepositionBoardController(model, client).process(ShiftDirection.Left);
		new RepositionBoardController(model, client).process(ShiftDirection.Right);
		reqs = mockServer.getAndClearMessages();
		assertEquals(4, reqs.size());
		r = reqs.get(0);
		assertEquals("repositionBoardRequest", r.contents.getFirstChild()
				.getLocalName());
		
		
	}
}
