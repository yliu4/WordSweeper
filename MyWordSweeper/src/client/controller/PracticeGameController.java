package client.controller;

import java.awt.*;
import java.awt.event.*;

import client.model.*;
import client.view.*;

public class PracticeGameController extends MouseAdapter{
	Model        model;
	Application    application;
	
	public PracticeGameController(Model m, Application app) {
		this.model = m;
		this.application = app;
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		application.getMenuPanel().setVisible(false);
	}
}
