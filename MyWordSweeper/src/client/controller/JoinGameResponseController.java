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

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
//		Node boardResponse = response.contents.getFirstChild();
//		NamedNodeMap map = boardResponse.getAttributes();
//		String gameId = map.getNamedItem("gameId").getNodeValue();
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		
		//Show warning message
		if ("private".equals(reason)) {
			JPanel panel = new JPanel();
			JLabel label = new JLabel("Enter a password:");
			JPasswordField pass = new JPasswordField(10);

			label.setFont(new Font("Times New Roman", Font.PLAIN, 2*height/45));
			panel.add(label);
			pass.setFont(new Font("Times New Roman", Font.PLAIN, 2*height/45));
			panel.add(pass);
			String[] options = new String[]{"OK", "Cancel"};
			int option = JOptionPane.showOptionDialog(app.getJoinGamePanel(), panel
					, "Warning", JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE,
					null, options, options[1]);
			if(option == 0) // pressing OK button
			{
			    String password = new String(pass.getPassword());
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
			}
		}
		else {
			UIManager.put("OptionPane.buttonFont", 
					new FontUIResource(new Font("Tahoma", Font.PLAIN, height/36)));
			UIManager.put("OptionPane.messageFont", 
					new FontUIResource(new Font("Times New Roman", Font.PLAIN, 2*height/45)));
			
			String message = "This game is locked or does not exist!";
			
			JOptionPane.showMessageDialog(app.getJoinGamePanel(), message, "Error!",
	        JOptionPane.ERROR_MESSAGE);
		}
		
		return true;
	}
}