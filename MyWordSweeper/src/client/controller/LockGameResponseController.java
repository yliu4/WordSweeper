package client.controller;

import xml.Message;
import client.model.Model;
import client.view.Application;

/**
 * This class is responsible for processing the LockGameResponse.
 * 
 * @author Team Pisces
 *
 */
public class LockGameResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/** Set <code>boolean</code>to allow skip the popup window in automated test. */
	boolean skipPopupWarning = false;

	/**
	 * LockGameResponseController constructor.
	 *
	 * @param app  	 Initialize the reference of application.
	 * @param model  Initialize the reference of model.
	 */
	public LockGameResponseController(Model model, Application app)  {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * Process lock game responses from server.
	 *
	 * @param Message Lock game response message from server in xml format.
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
	 * Allow automated test to skip the pop up window.
	 */
	public void SetSkipPopupWarning() {
		this.skipPopupWarning = true;
	}
}
