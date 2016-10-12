package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Model;
import client.view.Application;

/**
 * Controller for Reset button in practice panel
 * 
 * @author Team Pisces
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
