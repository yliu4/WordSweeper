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
	
	/** Use <code>boolean</code> to track missing nickname for automated test. */
	boolean isMissingNickName = false;
	
	/** Use <code>boolean</code> to track missing password for automated test. */
	boolean isMissingPassword = false;
	
	/** Set <code>boolean</code> to skip pop up windows in automated tests. */
	boolean skipPopupWindow = false;
	
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
			this.isMissingNickName = true;
			if (!this.skipPopupWindow) {
				app.popupWarnig("Please enter a nickname!");
			}
		} else if (isPrivate && password.length == 0) {
			this.isMissingPassword = true;
			if (!this.skipPopupWindow) {
				app.popupWarnig("Please enter a password!");
			}
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
	
	/**
	 * Allow skip pop up window in automated tests
	 */
	public void setSkipPopupWindow() {
		this.skipPopupWindow = true;
	}
	
	/**
	 * Return whether input is missing nick name for automated tests
	 * @return The boolean of whether missing nick name
	 */
	public boolean getIsMissingNickName() {
		return this.isMissingNickName;
	}
	
	/**
	 * Return whether input is missing password for automated tests
	 * @return The boolean of whether missing password
	 */
	public boolean getIsMissingPassword() {
		return this.isMissingPassword;
	}
}