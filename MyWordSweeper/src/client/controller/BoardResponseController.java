package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.Message;
import client.model.Model;
import client.view.Application;

/**
 * The board response controller is used to process board response from server.
 * 
 * And it will draw a new board if it's for create game request, otherwise update the board.
 * 
 * @author Team Pisces
 * @since 2016-10-30
 */
public class BoardResponseController extends ControllerChain {
	public Application app;
	public Model model;
	
	/**
	 * BoardResponseController constructor
	 *
	 * @param app  	 initialize application
	 * @param panel  initialize panel
	 */
	public BoardResponseController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * process board responses from server after createGameRquest or joinGameRequest
	 *
	 * @param Message board response message from server in xml format
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("boardResponse")) {
			return next.process(response);
		}

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
