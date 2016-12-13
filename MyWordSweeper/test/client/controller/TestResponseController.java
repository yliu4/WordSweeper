package client.controller;
 
 import junit.framework.TestCase;
import xml.Message;
import client.model.Game;
import client.model.Location;
import client.model.Model;
import client.model.Player;
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
 		controller.setSkipWarningDialog();
 		controller.process(m);
 		assertEquals(controller.getFailReason(), "locked");
 		
 		m = new Message("<response id=\"b046e830-308f-4ca8-8427-11406207c077\" reason=\"The game does not exist\" success=\"false\" version=\"1.0\"><joinGameResponse gameId=\"1\"/></response>");
 		controller.process(m);
 		assertEquals(controller.getFailReason(), "does not exist");
 	}
 	
 	public void testLockGameResponseController(){
 		Message.configure("wordsweeper.xsd");
 		
 		Model model = new Model();
 		Application app = new Application(model);
 		LockGameResponseController c = new LockGameResponseController(model, app);
 		c.SetSkipPopupWarning();
 		
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
 		c.SetSkipDialogWindow();
 		
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
 	
 	public void testConnectRepsponseController(){
 		Message.configure("wordsweeper.xsd");
 		
 		Model model = new Model();
 		Application app = new Application(model);
 		ConnectResponseController c = new ConnectResponseController(model, app);
 		
 		String response = "<connectResponse id=\"89509f93-42a8-4e5a-bce5-5fd6c540e5ad\"/></response>";
 		String xmlString = Message.responseHeader("id","reson") + response; 
 		Message m = new Message (xmlString);
 		c.process(m);
 	}
 	
 	public void testControllerChain(){
 		Message.configure("wordsweeper.xsd");
 		
 		Model model = new Model();
 		Application app = new Application(model);
 		SampleClientMessageHandler s = new SampleClientMessageHandler(app);
 		ConnectResponseController c = new ConnectResponseController(model, app);
 		FindWordResponseController f = new FindWordResponseController(model, app);
 		s.registerHandler(c);
 		s.registerHandler(f);
 		
 		String response = "<connectResponse id=\"89509f93-42a8-4e5a-bce5-5fd6c540e5ad\"/></response>";
 		String xmlString = Message.responseHeader("id","reson") + response; 
 		Message m = new Message (xmlString);
 		s.process(m);
 		
 		response = "<resetGameResponse gameId='TEST'/></response>";
 		xmlString = Message.responseHeader("id") + response; 
 		m = new Message (xmlString);
 		s.process(m);
 		
 	}
 	
 	public void testBoardResponseController(){
 		Message.configure("wordsweeper.xsd");
 		
 		Model model = new Model();
 		Application app = new Application(model);
 		BoardResponseController b = new BoardResponseController(model, app);
 		
 		String response = "<boardResponse bonus=\"6,3\" gameId=\"4kvpfqi5tqiepqnlravj7mssqr\" managingUser=\"a\" size=\"7\"><player board=\"B,R,Y,X,D,O,L,S,H,J,G,R,Z,P,U,I\" name=\"Peter\" position=\"4,1\" score=\"0\"/></boardResponse></response>";
 		String xmlString = Message.responseHeader("id","reson") + response; 
 		Message m = new Message (xmlString);
 		
 		Location location = new Location(1, 2);
		Player player = new Player("Ann", 10, location);
		Location location1 = new Location(1, 3);
		Player player1 = new Player("Peter", 10, location);
		Game game = new Game(player1);
		model.setGame(game);
		model.getGame().addPlayer(player);
 		b.process(m);
 		
 	}
 }