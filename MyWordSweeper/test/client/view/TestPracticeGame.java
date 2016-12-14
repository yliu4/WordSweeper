package client.view;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import junit.framework.TestCase;
import client.controller.PracticeGameController;
import client.model.Game;
import client.model.Model;

public class TestPracticeGame extends TestCase{
	/** client to connect. */
	Application app;

	/** model being maintained by client.*/
	Model model;
	
	/** Current game */
	Game game;

	/** prepare client and connect to server. */
	protected void setUp() {
		model = new Model();
		app = new Application(model);
		app.setVisible(true);
	}
	
    /** test Practice Controller and practice panel */
	public void testPracticeControllerAndPanel()
	{
		/** test controller */
		PracticeGameController practiceController = 
				new PracticeGameController(model, app);

		practiceController.process();
		
		PracticeGamePanel practicePanel = app.getPracticeGamePanel();	
		assertTrue(practicePanel.isVisible());
		
		/** test panel */
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

		BufferedImage bi = new BufferedImage(d.width, d.height, 
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = bi.createGraphics();
		practicePanel.setSize(d.width, d.height);
		practicePanel.paintComponents(g2);
		g2.dispose();
		
		BoardPanel boardPanel = (BoardPanel) practicePanel.getBoardPanel();
		
		assertNotNull(boardPanel);
	}

}
