package client.controller;

import client.model.Model;
import client.view.Application;

public class ChoosePrivateController {

	Application app;

	public ChoosePrivateController(Application app) {
		this.app = app;
	}
	
	public void process() {
		app.getCreateGamePanel().getTextFieldPW().setEditable(true);
	}
}
