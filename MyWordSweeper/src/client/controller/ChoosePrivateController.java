<<<<<<< HEAD
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
=======
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
>>>>>>> fa9d3b560f674996e7fae66cc42e8847f0e48a1a
