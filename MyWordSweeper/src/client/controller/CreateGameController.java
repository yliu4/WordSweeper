package client.controller;


import xml.Message;
import client.model.Model;
import client.view.Application;

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
		System.out.println(createGameRequest);
		String xmlString = Message.requestHeader() + createGameRequest;
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
		app.getServerAccess().sendRequest(m);
	}
}