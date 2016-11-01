package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;

/**
 * The connection response controller is used to process connection response from 
 * 
 * server.
 *
 * @author Team Pisces
 * @since 2016-10-30
 */

public class ConnectResponseController extends ControllerChain {
	public Application app;
	public Model model;
	
	public ConnectResponseController(Application a, Model m) {
		super();
		this.app = a;
		this.model = m;
	}
	
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("connectResponse")) {
			return next.process(response);
		}
		
		return true;
	}
}
