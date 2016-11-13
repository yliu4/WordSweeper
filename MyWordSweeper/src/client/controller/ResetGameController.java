package client.controller;

import xml.Message;
import client.model.Game;
import client.model.Location;
import client.model.Model;
import client.model.Player;
import client.view.Application;

/**
 * This class sends the reset game request to the server.
 * 
 * @author Team Pisces
 *
 */
public class ResetGameController {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * ResetGameController constructor
	 * 
	 * @param model  The model.
	 * @param app    The application.
	 */
	public ResetGameController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}
	
	public void process() {
		String gameId = model.getGame().getGameId();
		String createGameRequest = "<resetGameRequest gameId='" + gameId
				+ "'/></request>";
		String xmlString = Message.requestHeader() + createGameRequest;
		Message m = new Message (xmlString);

		app.getServerAccess().sendRequest(m);
	}
}
