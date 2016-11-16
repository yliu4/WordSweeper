package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;

public class ResetGameResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * ResetGameResponseController constructor
	 *
	 * @param app  	 initialize the reference of application
	 * @param model  initialize the reference of model
	 */
	public ResetGameResponseController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * process reset game responses from server
	 *
	 * @param Message  reset game response message from server in xml format
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("resetGameResponse")) {
			return next.process(response);
		}

		return true;
	}
}
