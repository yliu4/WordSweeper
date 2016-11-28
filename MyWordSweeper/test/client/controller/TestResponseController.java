package client.controller;
 
 import xml.Message;

 import junit.framework.TestCase;
 import client.controller.JoinGameResponseController;
 import client.model.Model;
 import client.view.Application;
 

/**
 * 
 * This test class tests for the board response controller
 * 
 * @author Team Pisces
 *
 */
 public class TestResponseController extends TestCase{
 	// TODO: use MockServer?
 	
 	public void testJoinGameResponseController() {
 		Message.configure("wordsweeper.xsd");
 		
 		Model model = new Model();
 		Application app = new Application(model);
 		JoinGameResponseController controller = new JoinGameResponseController(model, app);
 		
 		String response = "<joinGameResponse gameId='TEST'/></response>";
 		String xmlString = Message.responseHeader("id", "lock") + response;
 		Message m = new Message (xmlString);
 		controller.process(m);
 	}
 	
 	public void testLockGameResponseController(){
 		Message.configure("wordsweeper.xsd");
 		
 		Model model = new Model();
 		Application app = new Application(model);
 		LockGameResponseController c = new LockGameResponseController(model, app);
 		
 		String response = "<lockGameResponse gameId='TEST'/></response>";
 		String xmlString = Message.responseHeader("id") + response;
 		Message m = new Message (xmlString);
 		c.process(m);
 		
 		xmlString = Message.responseHeader("id", "already lock") + response;
 		m = new Message (xmlString);
 		c.process(m);
 	}
 	
 	public void testExitGameResponseController(){
 		Message.configure("wordsweeper.xsd");
 		
 		Model model = new Model();
 		Application app = new Application(model);
 		ExitGameResponseController c = new ExitGameResponseController(model, app);
 		
 		String response = "<exitGameResponse gameId='TEST'/></response>";
 		String xmlString = Message.responseHeader("id") + response; 
 		Message m = new Message (xmlString);
 		c.process(m);
 	}
 	
 	public void testResetGameResponseController(){
 		Message.configure("wordsweeper.xsd");
 		
 		Model model = new Model();
 		Application app = new Application(model);
 		ResetGameResponseController c = new ResetGameResponseController(model, app);
 		
 		String response = "<resetGameResponse gameId='TEST'/></response>";
 		String xmlString = Message.responseHeader("id") + response; 
 		Message m = new Message (xmlString);
 		c.process(m);
 		
 		xmlString = Message.responseHeader("id", "reason") + response; 
 		m = new Message (xmlString);
 		c.process(m);
 	}
 	
 	public void testFindWordResponseController(){
 		Message.configure("wordsweeper.xsd");
 		
 		Model model = new Model();
 		Application app = new Application(model);
 		FindWordResponseController c = new FindWordResponseController(model, app);
 		
 		String response = "<findWordResponse gameId='TEST' name=\"1\" score=\"0\"/></response>";
 		String xmlString = Message.responseHeader("id","reson") + response; 
 		Message m = new Message (xmlString);
 		c.process(m);
 	}
 }