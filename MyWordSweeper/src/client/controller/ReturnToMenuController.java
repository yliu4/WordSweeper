package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Model;
import client.view.Application;

/**
 * Controller to handle clicking the return button in practice mode
 * 
 * to return to main menu.
 * 
 * @author Team Pisces
 *
 */
public class ReturnToMenuController {
	Model model;
	Application application;

	public ReturnToMenuController(Model m, Application app) {
		this.model = m;
		this.application = app;
	}

	public void process() {
		application.gotoMainMenu();
	}

}
