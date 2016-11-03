
package client.controller;

import client.view.Application;

/**
 * The ChoosePrivateController class enables the editing of password field.
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
		app.getCreateGamePanel().getTextFieldPassword().setEditable(true);
	}
}

