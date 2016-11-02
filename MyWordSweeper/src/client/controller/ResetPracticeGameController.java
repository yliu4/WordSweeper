package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Model;
import client.view.Application;

/**
 * Controller for clicking the Reset button in practice mode.
 * 
 * @author Team Pisces
 *
 */
public class ResetPracticeGameController {
	Model model;
	Application app;

	public ResetPracticeGameController(Model m, Application app) {
		this.model = m;
		this.app = app;
	}

	public void process() {
		app.resetGame();
	}
}
