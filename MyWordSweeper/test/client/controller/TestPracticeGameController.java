package client.controller;

import java.util.ArrayList;
import java.util.List;

import client.MockServerAccess;
import client.model.Game;
import client.model.Model;
import client.view.Application;
import xml.Message;
import junit.framework.TestCase;

/**
 * The TestPracticeGameController class tests the PracticeGameController class.
 *  
 * @author Team Pisces
 */
public class TestPracticeGameController extends TestCase {

	/** client to connect. */
	Application app;

	/** model being maintained by client.*/
	Model model;

	/** prepare client and connect to server. */
	protected void setUp() {
		model = new Model();
		app = new Application(model);
		app.setVisible(true);
	}

	/**
	 *	The testPracticeGame method tests for getPracticeGameController,getMenuPanel
	 *	setPracticeGameController, gnerateNewBoard, gotoPraticeGamePanel and getGame 
	 *	methods
	 *
	 */
	public void testPracticeGame() {
		PracticeGameController practiceController = new PracticeGameController(model, app);
		practiceController.process();
		Game game = practiceController.getGame();
		
		assertNotNull(game.getBoard());

		assertEquals(app.getPracticeGameController(), practiceController);
		
		assertTrue(app.getPracticeGamePanel().isVisible());
		assertFalse(app.getMenuPanel().isVisible());
	}
	
	public void testResetPracticeGame(){
		List<Object> list1 = new ArrayList<Object>();
	    List<Object> list2 = new ArrayList<Object>();
		PracticeGameController practiceController = new PracticeGameController(model, app);
		practiceController.process();
		list1.add(practiceController.getGame().getBoard().getCells());
		new ResetPracticeGameController (model, app).process();
		list2.add(practiceController.getGame().getBoard().getCells());
		assertFalse(list1.equals(list2));
		
	}
	
	
}
