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
	Application app;
	Model model;

	public OpenCreateGamePanelController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}

	public void process() {
		app.gotoCreateGamePanel();
	}
}
