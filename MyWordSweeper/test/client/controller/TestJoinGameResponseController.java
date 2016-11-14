package client.controller;

import xml.Message;
import junit.framework.TestCase;
import client.controller.JoinGameResponseController;
import client.model.Model;
import client.view.Application;

public class TestJoinGameResponseController extends TestCase{
	public void testProcess() {
		Message.configure("wordsweeper.xsd");
		
		Model model = new Model();
		Application app = new Application(model);
		JoinGameResponseController controller = new JoinGameResponseController(model, app);
		
		String response = "<joinGameResponse gameId='TEST'/></response>";
		String xmlString = Message.responseHeader("id", "test") + response;
		Message m = new Message (xmlString);
		controller.process(m);
	}
}
