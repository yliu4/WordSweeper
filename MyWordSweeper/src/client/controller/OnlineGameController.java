package client.controller;

import xml.Message;
import client.model.Model;
import client.model.Word;
import client.view.Application;

/**
 * This class handle the communication between the sever and client. The client 
 * 
 * need to check the response message from sever to justify if the the game is 
 * 
 * lock, private or public game
 * 
 * @author Team Pisces
 *
 */
public class OnlineGameController {
	Model model;
	Application app;
	
	public OnlineGameController(Model model, Application app) {
		this.model = model;
		this.app = app;
	}
	
	public enum ShiftDirection
	{
		Left,
		Right,
		Up,
		Down
	}

	public void processShift(ShiftDirection shiftDirection)
	{
		String direction = "";
		switch(shiftDirection)
		{
		case Left:
			direction = "left";
			break;
		case Right:
			direction = "right";
			break;
		case Up:
			direction = "up";
			break;
		case Down:
			direction = "down";
			break;
		
		}
		
		/**
		 * create a shift request to the server, the server should respond with a board response
		 * (that contains the shifted board cells)
		 * The response is handled in BoardResponseController to update the existing game
		*/
		String shiftBoardRequest = "<shiftBoardRequest direction='" + direction
				+ "'/></request>";
		String xmlString = Message.requestHeader() + shiftBoardRequest;
		Message m = new Message (xmlString);
		
		app.getServerAccess().sendRequest(m);
	}
	
	public void processWordSelect(Word word)
	{
		//TODO: send word to server, server should respond with a board response
		// The response is handled in BoardResponseController to update the existing game
	}
}

