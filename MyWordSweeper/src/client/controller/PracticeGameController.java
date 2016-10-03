package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import client.model.Cell;
import client.model.Game;
import client.model.Letter;
import client.model.Location;
import client.model.Model;
import client.view.Application;

public class PracticeGameController extends MouseAdapter {
	Model model;
	Application application;
	Game game;

	public PracticeGameController(Model m, Application app) {
		this.model = m;
		this.application = app;
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		this.game = new Game();
		resetGame();
		application.setPracticeGameController(this);
		application.gotoPraticeGamePanel();
	}
	
	public void resetGame()
	{
		Location nomulti = new Location(10, 10);
		this.game.setBoard(this.generatecells(), nomulti);
	}

	public ArrayList<Cell> generatecells() {
		ArrayList<Cell> cells = new ArrayList<Cell>(16);
		String[] alp = new String[] { "A", "B", "C", "D", "E", "F", "G", "H",
				"I", "J", "K", "L", "M", "N", "O", "p", "Qu", "R", "S", "T",
				"U", "V", "W", "X", "Y", "Z" };
		int l = alp.length;
		Random r = new Random(System.currentTimeMillis());
		for (int y = 1; y <= 4; y++) {
			for (int x = 1; x <= 4; x++) {
				String s = alp[r.nextInt(l)];
				Letter le = new Letter(s, 0);
				Cell ce = new Cell(x, y, le);
				cells.add(ce);
			}
		}
		return cells;
	}

	public Game getGame()
	{
		return this.game;
	}
}
