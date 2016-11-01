package client.controller;

import client.model.Model;
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

	public ChoosePublicController(Application app) {
		this.app = app;
	}
	
	public void process() {
		app.getCreateGamePanel().getTextFieldPW().setEditable(false);
		app.getCreateGamePanel().getTextFieldPW().setText("");
	}
}
