package client.controller;

import client.model.Model;
import client.view.Application;
import xml.Message;

public class LockGameController {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * ResetGameController constructor.
	 * 
	 * @param model  The model.
	 * @param app    The application.
	 */
	public LockGameController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}
	
	/** Send the LockGameRequest to server. */
	public void process() {
		String gameId = model.getGame().getGameId();
		String lockGameRequest = "<lockGameRequest gameId='" + gameId
				+ "'/></request>";
		String xmlString = Message.requestHeader() + lockGameRequest;
		Message m = new Message (xmlString);

		app.getServerAccess().sendRequest(m);
	}
}
