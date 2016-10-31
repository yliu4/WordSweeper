package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.Message;
import client.model.Model;
import client.view.Application;

/**
 * Tells the client whether the model is locked or not BY SOME OTHER CLIENT. This will never be returned to a client
 * to tell him that HE has the model locked (that is job of LockResponse).
 */
public class BoardResponseController extends ControllerChain{

	public Application app;
	public Model model;
	
	public BoardResponseController(Application a, Model m) {
		this.app = a;
		this.model = m;
	}
	
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("boardResponse")) {
			return next.process(response);
		}

		// this refers to the outer node of the Message DOM (in this case, updateResponse).
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		
		// get global game board information
		String gameId = map.getNamedItem("gameId").getNodeValue();
		String contents = map.getNamedItem("contents").getNodeValue();
		String managingUser = map.getNamedItem("managingUser").getNodeValue();
		String bonus = map.getNamedItem("managingUser").getNodeValue();
		
		// get game board information for the managing user
		NodeList list = boardResponse.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			String pname = n.getAttributes().getNamedItem("name").getNodeValue();
			String pboard = n.getAttributes().getNamedItem("board").getNodeValue();
			String pposition = n.getAttributes().getNamedItem("position").getNodeValue();
			String pscore = n.getAttributes().getNamedItem("score").getNodeValue();
		}

		// at this point, you would normally start processing this...
		// TBD
		
		return true;
	}

}
