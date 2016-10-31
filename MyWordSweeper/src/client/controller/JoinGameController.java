package client.controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import xml.Message;
import client.model.Cell;
import client.model.Game;
import client.model.Letter;
import client.model.Location;
import client.model.Model;
import client.view.Application;

public class JoinGameController extends MouseAdapter {
	Game game;
	Application app;
	Model model;

	public JoinGameController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}

	/** Make the request on the server and wait for response. */
	public void process() {
		// send the request to create the game.
		String xmlString = Message.requestHeader() + "<joinGameRequest gameId='somePlace' name='nextOne'/></request>";
		Message m = new Message (xmlString);

		// Request the lock (this might not succeed).
//		app.getRequestArea().append(m.toString());
//		app.getRequestArea().append("\n");
		app.getServerAccess().sendRequest(m);
	}
	

	public void mouseClicked(MouseEvent me) {
		//app.setJoinGameController(this);
		app.gotoJoinGameRegisterPanel();
	}

	public Game getGame()
	{
		return this.game;
	}
}
