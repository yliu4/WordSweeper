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
	Application app;

	public ReturnToMenuController(Model m, Application app) {
		this.model = m;
		this.app = app;
	}

	public void process() {
		//clear the text field when go back to main menu
		app.getJoinGamePanel().getNameTextField().setText("");
		app.getJoinGamePanel().getGameIDTextField().setText("");
		app.gotoMainMenu();
	}
}
