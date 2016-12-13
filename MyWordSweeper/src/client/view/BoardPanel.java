package client.view;

import java.awt.*;
import java.util.*;

import javax.swing.*;

import client.controller.*;
import client.model.*;

/**
 * The <code>BoardPanel</code> class represents the 4*4 board that is assigned
 * 
 * to a player when he/she enters a game.
 * 
 * @author Team Pisces
 *
 */
public class BoardPanel extends JPanel {
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** An <code>ArrayList</code> for the <code>Cell</code>s in a <code>Board</code>. */
	ArrayList<Cell> cells;
	
	/** The current selected word. */
	Word word = new Word();
	
	/** Reference for easy navigation */
	BoardController boardController = null;

	/**
	 * Construct the panel for the board according to the cells. 
	 * 
	 * @param application Current <code>Application</code>.
	 * @param model <code>Model</code> for current application.
	 * @param cells <code>Cell</code>s in this <code>Board</code>.
	 */
	public BoardPanel(Model model, Application app, ArrayList<Cell> cells) {
		this.cells = cells;
		this.model = model;
		this.app = app;
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height / 180;
		int width = d.width / 320;
		
		setBounds(15*width, 55*height, 52*width+1, 52*height+1);
		
		this.boardController = new BoardController(model, app, this);
		
		this.addMouseListener(boardController);
		this.addMouseMotionListener(boardController);
	}
	
	/** 
	 * Get the board controller object. 
	 * 
	 * @return A <code>BoardController</code>. 
	 */
	public BoardController getBoardController() {
		return this.boardController;
	}
	
	/**
	 * Get the selected word.
	 * 
	 * @return A word.
	 */
	public Word getWord() {
		return this.word;
	}
	
	/**
	 * Update the board with a list of new cells.
	 * 
	 * @param cells A new list of cells assigned to this board.
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}
	
	/**
	 * Get the cell according to the current location on the board.
	 * 
	 * @param x X coordinate.
	 * @param y Y coordinate.
	 * @return The cell.
	 */
	public Cell getCell(int x, int y) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height / 360;
		int width = d.width / 640;
		int cellHeight = 26 * height;
		int cellWidth = 26 * width;
		
		if (x <= 1 ||
			y <= 1 ||
			x >= this.getWidth()-3 ||
			y >= this.getHeight()-3)
			return null;
		
		int col = x/cellWidth;
		int row = y/cellHeight;
		
		if (col >= 0 && col < 4 &&
				row >= 0 && row < 4) {
			int xBoundary = col * cellWidth;
			int yBoundary = row * cellHeight;
			
			if (x >= xBoundary + width &&
					x <= xBoundary + cellWidth - width &&
					y >= yBoundary + height &&
					y <= yBoundary + cellHeight - height)
				return cells.get(row*4+col);
		}
		
		return null;
	}
	
	/**
	 * Reset the state of all drawers to normal.
	 */
	public void resetDrawerState() {
		for (int i = 0; i < 16; i++) {
			Cell cell = cells.get(i);
			CellDrawer drawer = cell.getDrawer();
			int counter = cell.getCounter();
			
			if (cell.getLetter().isMultiplier())
				drawer.setState(CellDrawer.StateBonus);
			else if (counter == 1)
				drawer.resetState();
			else 
				drawer.setState(counter);
		}
	}
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height / 360;
		int width = d.width / 640;
		int cellHeight = 26 * height;
		int cellWidth = 26 * width;

		g.setColor(Color.black);
		g.setFont(new Font("Tahoma", Font.BOLD, 7*height));
		
		// Draw the grids.
		for (int i = 0; i < 5; i++) {
			g.drawLine(0, i*cellHeight, 4*cellWidth, i*cellHeight);
			g.drawLine(i*cellWidth, 0, i*cellWidth, 4*cellHeight);
		}
		
		ArrayList<Cell> cells = model.getGame().getBoard().getCells();
		
		for (int i = 0; i < 16; i++) {
			Cell cell = cells.get(i);
			CellDrawer drawer = cell.getDrawer();

			// Draw the cells by celldrawers.
			drawer.drawCell(g, cell, cellWidth, cellHeight, i);
		}
	}
}