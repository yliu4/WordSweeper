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

/**
 * Controller for creating practice game.
 * 
 * @author Team Pisces
 * 
 */
public class PracticeGameController {
	Model model;
	Application app;
	Game game;

	public PracticeGameController(Model m, Application app) {
		this.model = m;
		this.app = app;
	}

	public void process() {
		this.game = new Game();
		generateNewBoard();
		app.setPracticeGameController(this);
		app.gotoPraticeGamePanel();
	}
	
	/**
	 * Generate a new <code>Board</code> for practice game.
	 * 
	 * The location of bonus is set to be outside the range of a <code>Board</code>
	 */
	public void generateNewBoard()
	{
		/** The location of bonus is set to be outside the range of a <code>Board</code> */
		Location nomulti = new Location(10, 10);
		this.game.setBoard(this.generatecells(), nomulti);
	}
	
	/**
	 * Randomly generate 16 <code>Cells</code> for the <code>Board</code>
	 * 
	 * @return A List of <code>Cells</code>
	 */
	public ArrayList<Cell> generatecells (){
		ArrayList<Cell> cells = new ArrayList<Cell>(16);
		String[] alp = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K","L","M", "N", "O", "P", "Qu","R","S","T","U","V","W","X","Y","Z"};
		int l = alp.length;
		Random r = new Random(System.currentTimeMillis());
		for (int y = 0; y <= 3; y++) {
			for (int x = 0; x <= 3; x++) {
				String s = alp[r.nextInt(l)];
				Letter le = new Letter(s);
				Location lo = new Location(x, y);
				Cell ce = new Cell(lo, le);
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
