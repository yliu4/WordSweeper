package client.controller;

import client.model.Game;
import client.model.Model;
import client.view.Application;

/**
 * The OpenJoinGamePanelController class creates a panel to gather
 * 
 * the information needed for creating a new game.
 * 
 * @author Team Pisces
 *
 */
public class OpenJoinGamePanelController {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;

	/**
	 * Constructor for OpenJoinGamePanelController.
	 * 
	 * @param model The Model.
	 * @param app The Application.
	 */
	public OpenJoinGamePanelController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Open the JoinGamePanel. */
	public void process() {
		app.gotoJoinGamePanel();
	}
}
