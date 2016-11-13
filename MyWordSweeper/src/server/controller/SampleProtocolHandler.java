package server.controller;
import org.w3c.dom.Node;

import server.ClientState;
import server.IShutdownHandler;
import server.model.ServerModel;
import xml.*;

/**
 * Sample implementation of a protocol handler to respond to messages received from clients.
 * You should follow this template when designing YOUR protocol handler.
 * <p>
 * To avoid issues with multiple clients submitting requests concurrently,
 * notice that the {@link #process(ClientState, Message)} method is synchronized.
 * This will ensure that no more than one server thread executes this method
 * at a time.
 * <p>
 * Also extended to support detection of client disconnects so these can release the lock
 * if indeed the client was the one locking the model.
 */
public class SampleProtocolHandler implements IShutdownHandler {
	
	ServerModel model;
	
	public SampleProtocolHandler (ServerModel model) {
		this.model = model;
	}
	
	public synchronized Message process (ClientState st, Message request) {
		Node child = request.contents.getFirstChild();
		String type = child.getLocalName();
		
		System.out.println (request);
		if (type.equals ("createGameRequest")) {
			return new CreateGameRequestController(model).process(st, request); 
		} else if (type.equals ("joinGameRequest")) {
			return new JoinGameRequestController(model).process(st, request);
		}
		
		String xmlString = Message.responseHeader(request.id()) +
				"<boardResponse gameId='hg12jhd' managingUser='testtest' bonus='5,5'>" +
			      "<player name='testtest' score='12345678' position='4,4' board='AFERKSOEROIQRPOR'/>" +
			  "</boardResponse>" +
			"</response>";
		
		// send this response back to the client which sent us the request.
//		return new Message (xmlString);
		
		// unknown? no idea what to do
		System.err.println("Unable to handle message:" + request);
		return null;
	}

	public void logout(ClientState st) {
		new ClientDisconnectController().process(st);		
	} 
}
