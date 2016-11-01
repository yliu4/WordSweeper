package client.controller;

import client.model.Model;
import client.view.Application;

/**
 * The <code>ChoosePrivateController</code> class enables the editing of password field.
 * 
 * @author Team Pisces
 *
 */
public class ChoosePrivateController {

	Application app;

	public ChoosePrivateController(Application app) {
		this.app = app;
	}
	
	public void process() {
		app.getCreateGamePanel().getTextFieldPW().setEditable(true);
	}
}
