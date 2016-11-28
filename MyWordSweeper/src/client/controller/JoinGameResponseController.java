package client.controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import xml.Message;
import client.model.Model;
import client.view.Application;

public class JoinGameResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * JoinGameResponseController constructor
	 *
	 * @param app  	 initialize the reference of application
	 * @param model  initialize the reference of model
	 */
	public JoinGameResponseController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * process join game responses from server if fail when join a specific game
	 *
	 * @param Message  join game response message from server in xml format
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("joinGameResponse")) {
			return next.process(response);
		}
		
		String reason = response.reason();

		//Show warning message and get password.
	    String password = app.getJoinGamePanel().popupNeedPassword(reason);
	    
	    if (password.length() > 0){
	    	String nickname = app.getJoinGamePanel().getTextFieldNickname().getText();
			String gameId = app.getJoinGamePanel().getTextFieldGameID().getText();
			String joinGameRequest = "<joinGameRequest gameId='" + gameId
					+ "' name='" + nickname + "' password='" + password
					+ "'/></request>";
			String xmlString = Message.requestHeader() + joinGameRequest;
			Message m = new Message (xmlString);

			app.getServerAccess().sendRequest(m);
	    }
		
		return true;
	}
}