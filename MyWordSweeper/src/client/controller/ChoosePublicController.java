package client.controller;

import client.view.Application;

/**
 * The ChoosePublicController class disables the editing of password field,
 * 
 * and resets the text in that field.
 * 
 * @author Team Pisces
 *
 */
public class ChoosePublicController {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;

	/**
	 * ChoosePublicController constructor
	 *
	 * @param app  initialize the reference of application
	 */
	public ChoosePublicController(Application app) {
		this.app = app;
	}
	
	/**
	 * Set password's text field uneditable when choosing public mode.
	 */
	public void process() {
		app.getCreateGamePanel().getTextFieldPassword().setEditable(false);
		app.getCreateGamePanel().getTextFieldPassword().setText("");
	}
}
