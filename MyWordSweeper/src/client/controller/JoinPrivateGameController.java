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

public class JoinPrivateGameController extends MouseAdapter {
	
	Model model;
	Application application;


	public JoinPrivateGameController(Model m, Application app) {
		this.model = m;
		this.application = app;
	}


	public void mouseClicked(MouseEvent me) {
		//application.passwordPopupPanel();
	
		JPanel panel = new JPanel();
		JLabel label = new JLabel("Please enter a password to join the game:");
		JPasswordField pass = new JPasswordField(10);
		panel.add(label);
		panel.add(pass);
		String[] options = new String[]{"OK", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, panel, "WordSweeper",
		                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
		                         null, options, options[1]);
		if(option == 0) // pressing OK button
		{
		    char[] password = pass.getPassword();
		    System.out.println("Your password is: " + new String(password));
		}
	}


}
