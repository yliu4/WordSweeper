package client.controller;

import xml.Message;
import client.model.Model;
import client.view.Application;

public class LockGameResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/** Set <code>boolean</code>to allow skip the popup window in automated test */
	boolean skipPopupWarning = false;

	/**
	 * LockGameResponseController constructor
	 *
	 * @param app  	 initialize the reference of application
	 * @param model  initialize the reference of model
	 */
	public LockGameResponseController(Model model, Application app)  {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * process lock game responses from server
	 *
	 * @param Message  lock game response message from server in xml format
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("lockGameResponse")) {
			return next.process(response);
		}
		
		if (!this.skipPopupWarning) {	
			if (response.success()) 
				app.popupWarnig("This game is locked!");
			else
				app.popupWarnig(response.reason());
		}
		
		return true;
	}
	
	/**
	 * Allow automated test to skip the pop up window
	 */
	public void SetSkipPopupWarning() {
		this.skipPopupWarning = true;
	}
}
