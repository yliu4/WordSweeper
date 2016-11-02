package client.controller;

import client.view.Application;

/**
 * The <code>ChoosePublicController</code> class disables the editing of password field,
 * 
 * and resets the text in that field.
 * 
 * @author Team Pisces
 *
 */
public class ChoosePublicController {
	Application app;

	/**
	 * ChoosePublicController constructor
	 *
	 * @param app  	 initialize application
	 */
	public ChoosePublicController(Application app) {
		this.app = app;
	}
	
	/**
	 * set password's text field uneditable when choosing public mode
	 *
	 */
	public void process() {
		app.getCreateGamePanel().getTextFieldPassword().setEditable(false);
		app.getCreateGamePanel().getTextFieldPassword().setText("");
	}
}
