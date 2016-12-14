package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;

/**
 * This class is responsible for processing the findWordResponse.
 * 
 * @author Team Pisces
 *
 */
public class FindWordResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * FindWordResponseController constructor.
	 *
	 * @param app  	 initialize the reference of application.
	 * @param model  initialize the reference of model.
	 */
	public FindWordResponseController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}
	
	
	/**
	 * Process find word game responses from server after submitting a word.
	 *
	 * @param Message FindWordResponse message from server in xml format.
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		
		if (!type.equals ("findWordResponse")) {
			return next.process(response);
		}

		return true;
	}
}
