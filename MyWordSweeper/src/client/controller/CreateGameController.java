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

	/** Send the request to create a game */
	public void process() {
		String nickname = app.getCreateGamePanel().getTextFieldNickname().getText();
		char[] password = app.getCreateGamePanel().getTextFieldPassword().getPassword();
		boolean isPrivate = app.getCreateGamePanel().getRdbtnPrivate().isSelected();
		
		if (nickname.isEmpty()) {
			app.popupEmptyNicknameWarnig();
		}
		else if (isPrivate && password.length == 0) {
			app.popupEmptyPasswordWarnig();
		}
		else {
			String createGameRequest = "<createGameRequest name='" + nickname + "'" 
					+ ((password.length == 0)? "":(" password='" + new String(password) + "'"))
					+ "/></request>";
			String xmlString = Message.requestHeader() + createGameRequest;
			Message m = new Message (xmlString);

			app.getServerAccess().sendRequest(m);
		}
	}
}