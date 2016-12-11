package client.controller;

import java.util.ArrayList;
import java.util.Random;

import client.model.Cell;
import client.model.Game;
import client.model.Letter;
import client.model.Location;
import client.model.Model;
import client.model.Player;
import client.view.Application;
import client.view.CellDrawer;

/**
 * Controller for creating practice game.
 * 
 * @author Team Pisces
 * 
 */
public class PracticeGameController {
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/** Reference <code>Application</code> for easy navigation. */
	Application app;

	public PracticeGameController(Model m, Application app) {
		this.model = m;
		this.app = app;
	}

	public void process() {
		model.setGame(new Game(new Player("Practicer", 0, new Location(1, 1))));
		generateNewBoard();
		app.setPracticeGameController(this);
		app.gotoPraticeGamePanel();
	}
	
	/**
	 * Generate a new Board for practice game.
	 * 
	 * The location of bonus is set to be outside the range of a <code>Board</code>
	 */
	public void generateNewBoard() {
		/** The location of bonus is set to be outside the range of a <code>Board</code> */
		Location nomulti = new Location(10, 10);
		model.getGame().setBoard(this.generatecells(), nomulti);
	}
	
	/**
	 * Randomly generate 16 Cells for the Board
	 * 
	 * @return A List of cells
	 */
	public ArrayList<Cell> generatecells () {
		ArrayList<Cell> cells = new ArrayList<Cell>(16);
		String[] alp = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K","L","M", "N", "O", "P", "Qu","R","S","T","U","V","W","X","Y","Z"};
		int l = alp.length;
		Random r = new Random();
		for (int y = 0; y <= 3; y++) {
			for (int x = 0; x <= 3; x++) {
				String s = alp[r.nextInt(l)];
				Letter le = new Letter(s);
				Location lo = new Location(x, y);
				Cell ce = new Cell(lo, le);
				
				ce.setDrawer(new CellDrawer());
				cells.add(ce);
			}
		}
		return cells;
	}
}
