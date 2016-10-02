package client.controller;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import client.model.*;
import client.view.*;

public class PracticeGameController extends MouseAdapter{
	Model        model;
	Application    application;
	Game game;
	
	public PracticeGameController(Model m, Application app) {
		this.model = m;
		this.application = app;
	}
	
	@Override
	public void mouseClicked(MouseEvent me) {
		Location nomulti = new Location(10,10);
		this.game = new Game();
		game.setBoard(this.generatecells(), nomulti);
		PracticeGamePanel practiceGamePanel = application.getPracticeGamePanel();
		practiceGamePanel.setGame(game);
		application.getMenuPanel().setVisible(false);
		application.setPraticeGamePanel(practiceGamePanel);
	}
	public ArrayList<Cell> generatecells (){
		ArrayList<Cell> cells = new ArrayList<Cell>(16);
		String[] alp = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K","L","M", "N", "O", "p", "Qu","R","S","T","U","V","W","X","Y","Z"};
		int l = alp.length;
		Random r = new Random();
		for (int y = 1;y<=4;y++){
			for(int x = 1;x<=4;x++){
				String s = alp[r.nextInt(l)];
				Letter le = new Letter(s,0);
				Cell ce = new Cell(x,y,le);
				cells.add(ce);
			}
		}
		return cells;
	}
	
	
}
