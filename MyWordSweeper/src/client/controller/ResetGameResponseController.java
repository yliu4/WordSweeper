package client.controller;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import client.model.Model;
import client.view.Application;
import xml.Message;

public class ResetGameResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/**
	 * ResetGameResponseController constructor
	 *
	 * @param app  	 initialize the reference of application
	 * @param model  initialize the reference of model
	 */
	public ResetGameResponseController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * process reset game responses from server
	 *
	 * @param Message  reset game response message from server in xml format
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("resetGameResponse")) {
			return next.process(response);
		}
		
		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		
		String gameId = map.getNamedItem("gameId").getNodeValue();
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		
		//Show warning message
		UIManager.put("OptionPane.buttonFont", 
				new FontUIResource(new Font("Tahoma", Font.PLAIN, height/36)));
		UIManager.put("OptionPane.messageFont", 
				new FontUIResource(new Font("Times New Roman", Font.PLAIN, 2*height/45)));
		String message = "The game" + gameId + "is ";
		JOptionPane.showMessageDialog(app.getJoinGamePanel(), message, "Error!",
        JOptionPane.ERROR_MESSAGE);
		
		return true;
	}
}