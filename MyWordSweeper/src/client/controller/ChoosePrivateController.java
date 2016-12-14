
package client.controller;

import client.view.Application;

/**
 * The ChoosePrivateController class enables the editing of password field.
 * 
 * @author Team Pisces
 *
 */
public class ChoosePrivateController {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;

	/**
	 * ChoosePrivateController constructor.
	 *
	 * @param app  initialize the reference of application.
	 */
	public ChoosePrivateController(Application app) {
		this.app = app;
	}
	
	/**
	 * Set password's text field editable when choosing private mode.
	 */
	public void process() {
		app.getCreateGamePanel().getTextFieldPassword().setEditable(true);
	}
}

