package client.controller;

import xml.Message;
import client.model.Model;
import client.model.Word;
import client.view.Application;

/**
 * This class handle the reposition board request.
 * 
 * @author Team Pisces
 *
 */
public class RepositionBoardController {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * An enum representing the shift direction.
	 * 
	 * @author Team Pisces
	 *
	 */
	public enum ShiftDirection {
		Left,
		Right,
		Up,
		Down
	}
	
	/**
	 * Constructor for RepositionBoardController.
	 * 
	 * @param model The Model.
	 * @param app The Application. 
	 */
	public RepositionBoardController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}

	/**
	 * Create a reposition board request and send it to the server. 
	 * 
	 * @param shiftDirection Shift direction.
	 */
	public void process(ShiftDirection shiftDirection)
	{
		int rowChange = 0, colChange = 0;
		
		switch(shiftDirection) {
			case Left:
				colChange = -1;
				break;
			case Right:
				colChange = 1;
				break;
			case Up:
				rowChange = -1;
				break;
			case Down:
				rowChange = 1;
				break;
		}
		
		String nickname = model.getGame().getCurrentPlayer().getName();
		String gameId = model.getGame().getGameId();
		String repositionBoardRequest = "<repositionBoardRequest name='" 
				+ nickname + "' gameId='" + gameId + "' rowChange='" 
				+ rowChange + "' colChange='" + colChange	
				+ "'/></request>";
		String xmlString = Message.requestHeader() + repositionBoardRequest;
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	}
}
