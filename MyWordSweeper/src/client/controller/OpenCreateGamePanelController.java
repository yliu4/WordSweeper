package client.controller;

import xml.Message;
import client.model.Model;
import client.view.Application;

/**
 * The OpenCreateGamePanelController class creates a panel to gather
 * 
 * the information needed for creating a new game.
 * 
 * @author Team Pisces
 *
 */
public class OpenCreateGamePanelController {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;

	/**
	 * Constructor for OpenCreateGamePnaleController.
	 * 
	 * @param model The Model.
	 * @param app The Application.
	 */
	public OpenCreateGamePanelController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}

	/**
	 * Open the CreateGamePanel. 
	 */
	public void process() {
		app.gotoCreateGamePanel();
	}
}
