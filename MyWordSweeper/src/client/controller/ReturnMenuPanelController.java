package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import client.model.Model;
import client.view.Application;

/**
 * Controller to handle click of the return button in practice mode
 * to return back to main menu
 * @author team Pisces
 *
 */
public class ReturnMenuPanelController extends MouseAdapter {
	Model model;
	Application application;

	public ReturnMenuPanelController(Model m, Application app) {
		this.model = m;
		this.application = app;
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		application.gotoMainMenu();
	}

}
