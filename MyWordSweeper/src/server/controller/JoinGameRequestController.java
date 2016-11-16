package server.controller;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import server.ClientState;
import server.IProtocolHandler;
import server.Server;
import server.model.ServerModel;
import xml.Message;

/**
 * Controller on server to package up the current state of the model
 * as an updateResponse message and send it back to the client.
 */
public class JoinGameRequestController implements IProtocolHandler {

	ServerModel model;
	
	public JoinGameRequestController (ServerModel model) {
		this.model = model;
	}
	
	public Message process(ClientState client, Message request) {
		//Node child = request.content.
	    //System.out.println(child.getUserData("gameId").toString());
		//string id = 
				
		model.joinGame();

		Node joinRequest = request.contents.getFirstChild();
		NamedNodeMap map = joinRequest.getAttributes();
		
		String pname = map.getNamedItem("name").getNodeValue();
		String otherPlayers = "<player name='" + pname + "' score='38974' position='2,2' board='E,C,D,R,F,T,G,O,U,I,G,E,R,P,R,T'/>";
		
		for (int i = 0; i < model.getNumPlayers(); i++) {
			otherPlayers += "<player name='player" + i + "' score='38974' position='2,2' board='E,C,D,R,F,T,G,O,U,I,G,E,R,P,R,T'/>";
		}
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		
		Message message;
		String xmlString = "";
		
		if (gameId.equals("lock"))
		{
			// Game is locked
			String response = "<joinGameResponse gameId='" + gameId 
					+ "'/></response>";
			xmlString = Message.responseHeader(request.id(), "lock") 
					+ response;
		}
		else if (gameId.equals("private"))
		{
			// Game needs password
			Node password = map.getNamedItem("password");
			
			if (password == null) {
				String response = "<joinGameResponse gameId='" + gameId 
						+ "'/></response>";
				xmlString = Message.responseHeader(request.id(), "private") 
						+ response;
			}
			else if ("password".equals(password.getNodeValue())) {
				xmlString = Message.responseHeader(request.id()) + 
						"<boardResponse gameId='" + gameId + "' managingUser='player2' bonus='4,3' contents='ABCGBCJDH...HDJHJD'>" +
					      otherPlayers +
					  "</boardResponse>" +
					"</response>";
			}
			else {
				String response = "<joinGameResponse gameId='" + gameId 
						+ "'/></response>";
				xmlString = Message.responseHeader(request.id(), "private") 
						+ response;
			}
		}
		else {
			// Join success
			xmlString = Message.responseHeader(request.id()) + 
					"<boardResponse gameId='" + gameId + "' managingUser='player2' bonus='4,3' contents='ABCGBCJDH...HDJHJD'>" +
				      otherPlayers +
				  "</boardResponse>" +
				"</response>";
		}

		message = new Message (xmlString);
		
		// all other players on game (excepting this particular client) need to be told of this
		// same response. Note this is inefficient and should be replaced by more elegant functioning
		// hint: rely on your game to store player names...
		for (String id : Server.ids()) {
			if (!id.equals(client.id())) {
				Server.getState(id).sendMessage(message);
			}
		}

		// send this response back to the client which sent us the request.
		return message;
	}
}
