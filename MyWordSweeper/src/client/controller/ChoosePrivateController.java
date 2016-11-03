package client.controller;

import client.view.Application;

/**
 * The <code>ChoosePrivateController</code> class enables the editing of password field.
 * 
 * @author Team Pisces
 * @since  2016-11-01
 */
public class ChoosePrivateController {
	Application app;
	
	/**
	 * ChoosePrivateController constructor
	 *
	 * @param app  	 initialize application
	 */
	public ChoosePrivateController(Application app) {
		this.app = app;
	}
	
	/**
	 * set password's text field editable when choosing private mode
	 */
	public void process() {
		app.getCreateGamePanel().getTextFieldPassword().setEditable(true);
	}
}
