package client.controller;

import client.model.Model;
import client.view.Application;

/**
 * Controller for clicking the Reset button in practice mode.
 * 
 * @author Team Pisces
 *
 */
public class ResetPracticeGameController {
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/** Reference <code>Application</code> for easy navigation. */
	Application app;

	/**
	 * Constructor for ResetPracticeGameController.
	 * 
	 * @param m The Model.
	 * @param app The Application.
	 */
	public ResetPracticeGameController(Model m, Application app) {
		this.model = m;
		this.app = app;
	}

	/**
	 * Reset the practice game. 
	 */
	public void process() {
		app.resetGame();
		app.getPracticeGamePanel().getLblCurrentWord().setText("Current Word: ");
		app.getPracticeGamePanel().getLblScore().setText("Score: ");
		model.getGame().getCurrentPlayer().setScore(0);
		app.getPracticeGamePanel().repaint();
		app.getPracticeGamePanel().revalidate();
	}
}
