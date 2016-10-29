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
public class ResetGameInPracticeController extends MouseAdapter {
	Model model;
	Application application;

	public ResetGameInPracticeController(Model m, Application app) {
		this.model = m;
		this.application = app;
	}

	public void mouseClicked(MouseEvent me) {
		application.resetGame();
	}

}
