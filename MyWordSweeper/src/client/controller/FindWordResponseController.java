package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.model.Model;
import client.view.Application;
import xml.Message;

public class FindWordResponseController extends ControllerChain {
	Application app;
	Model model;

	public FindWordResponseController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("findWordResponse")) {
			return next.process(response);
		}
		
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		String name = map.getNamedItem("gameId").getNodeValue();
		String score = map.getNamedItem("score").getNodeValue();
		
		return true;
	}
}
