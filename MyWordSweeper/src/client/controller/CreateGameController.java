package client.controller;

import xml.Message;
import client.model.Game;
import client.model.Location;
import client.model.Model;
import client.model.Player;
import client.view.Application;

/**
 * The create game controller is used to send create game request to server.
 * 
 * @author Team Pisces
 * @since 2016-10-30
 */
public class CreateGameController {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * CreateGameController constructor.
	 * 
	 * @param model  The model.
	 * @param app    The application.
	 */
	public CreateGameController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}

	/**
	 * Process create game request and them send a request to server in xml format.
	 */
	public void process() {
		String nickname = app.getCreateGamePanel().getTextFieldNickname().getText();
		char[] password = app.getCreateGamePanel().getTextFieldPassword().getPassword();
		boolean isPrivate = app.getCreateGamePanel().getRdbtnPrivate().isSelected();
		
		if (nickname.isEmpty()) {
			app.popupEmptyNicknameWarnig();
		} else if (isPrivate && password.length == 0) {
			app.popupEmptyPasswordWarnig();
		} else {
			String createGameRequest = "<createGameRequest name='" + nickname + "'" 
					+ ((password.length == 0)? "":(" password='" + new String(password) + "'"))
					+ "/></request>";
			String xmlString = Message.requestHeader() + createGameRequest;
			Message m = new Message (xmlString);
			Game game = new Game(new Player(nickname, 0, new Location(1, 1)));
			
			model.setGame(game);
			app.getServerAccess().sendRequest(m);
		}
	}
}