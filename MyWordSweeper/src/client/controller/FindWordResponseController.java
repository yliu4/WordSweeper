package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.model.Model;
import client.view.Application;
import xml.Message;

public class FindWordResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * FindWordResponseController constructor
	 *
	 * @param app  	 initialize the reference of application
	 * @param model  initialize the reference of model
	 */
	public FindWordResponseController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}
	
	
	/**
	 * process find word game responses from server after submitting a word
	 *
	 * @param Message  find word response message from server in xml format
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		System.out.println("Response type : " + type);
		System.out.println("Response body : " + response.toString());
		
		if (!type.equals ("findWordResponse")) {
			return next.process(response);
		}
		
		boolean success = response.success();
		
		if(success) {
			Node boardResponse = response.contents.getFirstChild();
			NamedNodeMap map = boardResponse.getAttributes();
		
			String gameId = map.getNamedItem("gameId").getNodeValue();
			String name = map.getNamedItem("name").getNodeValue();
			String score = map.getNamedItem("score").getNodeValue();
			System.out.println(String.format("gamdId %1, name %2, score %3", gameId, name, score));
		
		} else {
			
		}
		return true;
	}
}
