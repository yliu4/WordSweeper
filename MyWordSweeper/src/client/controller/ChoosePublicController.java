package client.controller;

import client.model.Model;
import client.view.Application;

public class ChoosePublicController {

	Application app;

	public ChoosePublicController(Application app) {
		this.app = app;
	}
	
	public void process() {
		app.getCreateGamePanel().getTextFieldPW().setEditable(false);
		app.getCreateGamePanel().getTextFieldPW().setText("");
	}
}
