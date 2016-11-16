package client.controller;

import xml.Message;
import client.model.Model;
import client.view.Application;

/**
 * This class sends the exit game request to the server.
 * 
 * @author Team Pisces
 *
 */
public class ExitGameController {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * Construct the ExitGameController.
	 * 
	 * @param model The model.
	 * @param application The application.
	 */
	public ExitGameController(Model model, Application application) {
		this.model = model;
		this.app = application;
	}
	
	/** Send the request to server. */
	public void process() {
		String gameId = model.getGame().getGameId();
		String nickname = model.getGame().getCurrentPlayer().getName();
		String exitGameRequest = "<exitGameRequest gameId='" + gameId
				+ "' name='" + nickname + "'/></request>";
		String xmlString = Message.requestHeader() + exitGameRequest;
		Message m = new Message (xmlString);

		app.getServerAccess().sendRequest(m);
	}
}
