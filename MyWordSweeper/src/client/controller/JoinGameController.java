package client.controller;

import java.util.ArrayList;
import java.util.Random;

import xml.Message;
import client.model.Cell;
import client.model.Game;
import client.model.Letter;
import client.model.Location;
import client.model.Model;
import client.model.Player;
import client.view.Application;
import client.view.JoinGamePanel;

/**
 * This class handle the join game request.
 * 
 * @author Team Pisces
 *
 */
public class JoinGameController {
	Model model;
	Application app;
	
	/** Use <code>boolean</code> to track missing nickname for automated test. */
	boolean isMissingNickName = false;
	
	/** Use <code>boolean</code> to track missing password for automated test. */
	boolean isMissingPassword = false;
	
	/** Set <code>boolean</code> to skip pop up windows in automated tests. */
	boolean skipPopupWindow = false;
	
	public JoinGameController(Model model, Application app) {
		this.model = model;
		this.app = app;
	}

	/** Send the request to join a game */
	public void process() {
		String nickname = app.getJoinGamePanel().getTextFieldNickname().getText();
		String gameId = app.getJoinGamePanel().getTextFieldGameID().getText();

		if (nickname.isEmpty()) {
			this.isMissingNickName = true;
			if (!this.skipPopupWindow)
			{
				app.popupWarnig("Please enter a nickname!");
			} 
		}
		else if (gameId.isEmpty()) {
			this.isMissingPassword = true;
			if (!this.skipPopupWindow)
			{
				app.popupWarnig("Please enter a gameId!");
			}
		} 
		else {
			String joinGameRequest = "<joinGameRequest gameId='" + gameId
					+ "' name='" + nickname + "'/></request>";
			String xmlString = Message.requestHeader() + joinGameRequest;
			Message m = new Message (xmlString);
			Game game = new Game(new Player(nickname, 0, new Location(1, 1)));
			
			model.setGame(game);
			app.getServerAccess().sendRequest(m);
		}	
	}
	
	/**
	 * Allow skip pop up window in automated tests
	 */
	public void setSkipPopupWindow()
	{
		this.skipPopupWindow = true;
	}
	
	/**
	 * Return whether input is missing nick name for automated tests
	 * @return The boolean of whether missing nick name
	 */
	public boolean getIsMissingNickName()
	{
		return this.isMissingNickName;
	}
	
	/**
	 * Return whether input is missing password for automated tests
	 * @return The boolean of whether missing password
	 */
	public boolean getIsMissingPassword()
	{
		return this.isMissingPassword;
	}
}

