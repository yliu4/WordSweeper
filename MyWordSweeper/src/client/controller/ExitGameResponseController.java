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

/**
 * This class is responsible for processing the exitGameResponse.
 * 
 * @author Team Pisces
 *
 */
public class ExitGameResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/** Set <code>boolean</code> to skip dialog window popup when during automated test. */
	boolean skipDialogWindow = false;

	/**
	 * ExitGameResponseController constructor.
	 *
	 * @param app  	 initialize the reference of application.
	 * @param model  initialize the reference of model.
	 */
	public ExitGameResponseController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * To skip the dialog window. 
	 */
	public void SetSkipDialogWindow() {
		this.skipDialogWindow = true;
	}
	
	/**
	 * Process exit game responses from server after exitGameRquest.
	 *
	 * @param Message ExitGameResponse message from server in xml format.
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("exitGameResponse")) {
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
		
		String message = "You have successfully exited from game '" + gameId + "'!";
		
		// allow skip dialog window in automated tests
		if (!this.skipDialogWindow) {
			JOptionPane.showMessageDialog(app, message, "Exit Game!",
					JOptionPane.PLAIN_MESSAGE);
		}
		
		app.gotoMainMenu();
		
		return true;
	}
	
	
}