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
	
	/**
	 * ChoosePublicController constructor
	 *
	 * @param app  	 initialize application
	 * @param model	 initialize model
	 */
	public ConnectResponseController(Application app, Model model) {
		super();
		this.app = app;
		this.model = model;
	}
	
	/**
	 * process connection response from server after client try to 
	 * connect with server 
	 *
	 * @param response  connection response from server in xml format
	 */
	@Override
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("connectResponse")) {
			return next.process(response);
		}
		
		return true;
	}
}
