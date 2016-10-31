package client.controller;

import xml.Message;
import client.model.Model;
import client.view.Application;

/**
 * The create game controller is used to send create game request to server.
 * 
 * @author Team Pisces
 * @since 2016-10-30
 */

public class CreateGameController {
	Application app;
	Model model;

	public CreateGameController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process(String player, String password) {
		// send the request to create the game.
		String createGameRequest = "<createGameRequest name='" + player + "'" + (password.isEmpty()? "":(" password='" + password + "'")) + "/></request>";
		String xmlString = Message.requestHeader() + createGameRequest;
		Message m = new Message (xmlString);

		app.getServerAccess().sendRequest(m);
	}
}