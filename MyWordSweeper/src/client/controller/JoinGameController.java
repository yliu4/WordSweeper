package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import xml.Message;
import client.model.Model;
import client.view.Application;
import client.view.JoinGamePanel;


/**
 * This class handle the communication between the sever and client
 * The client need to check the response message from sever to justify if the 
 * the game is lock, private or public game
 * @author Tean Pisces
 *
 */
public class JoinGameController {
	
	Model model;
	Application application;
	
	JPanel popOutPanel;
	JPasswordField password;

	public JoinGameController(Model m, Application app) {
		this.model = m;
		this.application = app;
		
		this.popOutPanel = new JPanel();
		JLabel label = new JLabel("Please enter a password to join the game:");
		this.password = new JPasswordField(10);
		popOutPanel.add(label);
		popOutPanel.add(this.password);
	}

	public void process() {		
		// send the request to join the game.
		
		String gameID = application.getJoinGamePanel().getGameIDTextField().getText();
		System.out.println("### Game ID" + gameID);
		
		String xmlString = Message.requestHeader() + 
				"<joinGameRequest gameId='' name='nextOne'/></request>";
		
		
		// <request asdfasdf>
		// <joinGameRequest gameId='' name='nextOne'/>
		//   <level>
		// 
		// </request>
		
		Message m = new Message (xmlString);

		application.getServerAccess().sendRequest(m);

		// TODO: receive response from server
		// parse message, if == SUCCESS: go to game panel
		// if == FAIL, display "locked" pop up dialog
		// if == PRIVATE, pop up password dialog
		
		String[] options = new String[]{"OK", "Cancel"};
	
		int option = JOptionPane.showOptionDialog(null, this.popOutPanel, "WordSweeper",
	                     JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
	                     null, options, options[1]);
		if(option == 0) // pressing OK button
		{
		    char[] pass = this.password.getPassword();
		    System.out.println("Your password is: " + new String(pass));
		}
	}
}
