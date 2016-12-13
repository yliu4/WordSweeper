package client.controller;

import client.model.Game;
import client.model.Model;
import client.view.Application;

public class OpenJoinGamePanelController {
	Game game;
	Application app;
	Model model;

	public OpenJoinGamePanelController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		app.gotoJoinGamePanel();
	}

	/**
	 * get the game object
	 * @return game object
	 */
	public Game getGame() {
		return this.game;
	}
}
