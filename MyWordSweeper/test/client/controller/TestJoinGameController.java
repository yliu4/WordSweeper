package client.controller;

import java.util.ArrayList;

import xml.Message;
import client.MockServerAccess;
import client.model.Game;
import client.model.Model;
import client.view.Application;
import junit.framework.TestCase;

public class TestJoinGameController extends TestCase {
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
		
		public void testOpenJoinGamePanelProcess() {
			new OpenJoinGamePanelController(client, model).process();
			assertFalse(client.getMenuPanel().isVisible());
			assertTrue(client.getJoinGamePanel().isVisible());
			new OpenJoinGamePanelController(client, model).getGame();
			
			
			JoinGameController j1 = new JoinGameController(model, client);
			client.getJoinGamePanel().getTextFieldNickname().setText("yuchen");
			client.getJoinGamePanel().getTextFieldGameID().setText("1");
			j1.process();
			ArrayList<Message> reqs = mockServer.getAndClearMessages();
			assertTrue(reqs.size() == 1);
			Message r = reqs.get(0);
			assertEquals("joinGameRequest", r.contents.getFirstChild()
					.getLocalName());
			assertEquals("1", r.contents.getFirstChild().getAttributes()
					.getNamedItem("gameId").getNodeValue());
			assertEquals("yuchen", r.contents.getFirstChild().getAttributes()
					.getNamedItem("name").getNodeValue());
			
			//expect a pop up warning asking for nick name
			JoinGameController j2 = new JoinGameController(model, client);
			client.getJoinGamePanel().getTextFieldNickname().setText("");
			client.getJoinGamePanel().getTextFieldGameID().setText("123");
			j2.setSkipPopupWindow();
			j2.process();
			assertEquals(j2.getIsMissingNickName(), true);
			
			//expect a pop up warning asking for game id
			JoinGameController j3 = new JoinGameController(model, client);
			client.getJoinGamePanel().getTextFieldNickname().setText("yuchen");
			client.getJoinGamePanel().getTextFieldGameID().setText("");
			j3.setSkipPopupWindow();
			j3.process();
			assertEquals(j3.getIsMissingPassword(), true);
			
			//test Return to Menu
			new ReturnToMenuController(model, client).process();
			assertTrue(client.getMenuPanel().isVisible());
			assertFalse(client.getJoinGamePanel().isVisible());
			
			
		}
}
