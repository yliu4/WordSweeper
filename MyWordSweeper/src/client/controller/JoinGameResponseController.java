package client.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import xml.Message;
import client.model.Model;
import client.view.Application;

public class JoinGameResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * JoinGameResponseController constructor
	 *
	 * @param app  	 initialize the reference of application
	 * @param model  initialize the reference of model
	 */
	public JoinGameResponseController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * process join game responses from server if fail when join a specific game
	 *
	 * @param Message  join game response message from server in xml format
	 */
	public boolean process(Message response) {
		Node joinGameResponse = response.contents.getFirstChild();
		if (!joinGameResponse.getLocalName().equals ("joinGameResponse")) {
			return next.process(response);
		}
		
		//Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = joinGameResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		
		if (gameId.equals("-1"))
		{
			app.getJoinGamePanel().PopUpLocked();
		}
		else if (gameId.equals("-2"))
		{
			app.getJoinGamePanel().PopUpPassword();
		}
		else
		{
			// TODO: successfully joined the game, change panel to online
			// and get board response to draw board
			app.getJoinGamePanel().PopUpJoinSuccess();
		}
		
		return true;
	}
}