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
	
	/** An <code>ArrayList</code> for the currently selected word. */
	ArrayList<Cell> word = new ArrayList<Cell>();
	
	/** An <code>ArrayList</code> for index of selected cells. */
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	/** For building the current selected word. */
	StringBuilder currentWord;
	
	/** Reference for easy navigation */
	BoardController boardController = null;
	
	/** A array of Strings that stores the String in each cell. */
	String[] letters = new String[16];
	
	/** For recording the previous dragged cell */
	int prev;
	
	/** Mark if you dragged the same cell two times */
	boolean stop = false;
	
	/** The score for the selected word */
	long wordScore = 0;

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

		for (int i = 0; i < 16; i++) {
			letters[i] = this.cells.get(i).getLetter().getCharacter();
		}
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height / 360;
		int width = d.width / 640;
		
		setBounds(10*width, 80*height, 104*width+1, 104*height+1);
		currentWord = new StringBuilder();
		
		this.boardController = new BoardController(model, app, this);
		
		this.addMouseListener(boardController);
		this.addMouseMotionListener(boardController);
	}
	
	/** 
	 * Get the board controller object. 
	 * 
	 * @return A <code>BoardController</code>. 
	 */
	public BoardController getBoardController()
	{
		return this.boardController;
	}

	/**
	 * Get the current selected word.
	 * 
	 * @return A <code>String</code> represents the current selected word.
	 */
	public String getCurrentWord() {
		return this.currentWord.toString().toUpperCase();
	}
	
	/**
	 * Get the score of current selected word.
	 * 
	 * @return A <code>String</code> represents the score of current selected word.
	 */
	public long getWordScore(){
		return this.wordScore;
	}
	
	/**
	 * Get the list of cells of the selected word
	 * 
	 * @return a list of cells
	 */
	public ArrayList<Cell> getWordCells()
	{
		return this.word;
	}
	
	/**
	 * Update the board with a list of new cells.
	 * 
	 * @param cells A new list of cells assigned to this board.
	 */
	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;

		for (int i = 0; i < 16; i++) {
			letters[i] = this.cells.get(i).getLetter().getCharacter();
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
		
		// Draw the letters.
		for (int i = 0; i < 16; i++) 
			g.drawString(letters[i], 
					11*width + (i%4)*cellWidth, 
					15*height + (i/4)*cellHeight);

		int x = boardController.getX();
		int y = boardController.getY();

		// Record the cells mouse dragged. 
		// If mouse drags onto a dragged cell, stop recording.
		if(x != -1 && y != -1) {
			int dragWidth = boardController.getDeltaX();
			int dragHeight = boardController.getDeltaY();
			
			for(int i = 0; i < 16; i++) {
				int cellX = (i%4)*cellWidth;
				int cellY = (i/4)*cellHeight;
				
				if(x+dragWidth >= cellX+5 &&
						x+dragWidth <= cellX+cellWidth-width &&
						y+dragHeight >= cellY+5 && 
						y+dragHeight <= cellY+cellHeight-height)
					if(stop == false) {
						if(!list.isEmpty() && prev != i && list.contains(i)) {
							stop = true;
							break;
						}
						
						prev = i;
						
						if(!list.contains(i))
							list.add(i);
					}
			} 

			currentWord.delete(0, currentWord.length());
			word.clear();
			
			for(Integer num : list) {
				g.setColor(Color.red);
				
				// Fill the dragged cells
				g.fillRect((num%4)*cellHeight, (num/4)*cellHeight
						, cellWidth, cellHeight);
				
				// Form the selected word.
				word.add(this.cells.get(num));
				currentWord.append(this.cells.get(num).getLetter().getCharacter());
				
				// Show the word.
				if (app.getPracticeGamePanel() != null) 
					app.getPracticeGamePanel().getLblCurrentWord().setText("Current Word: "+this.getCurrentWord());
				
				if (app.getOnlineGamePanel() != null) 
					app.getOnlineGamePanel().getLblCurrentWord().setText("Current Word: "+this.getCurrentWord());
			}
			
			Game game = model.getGame();
			Word selectedWord = new Word(word);
			
			// Calculate the score for selected word.
			this.wordScore = game.calculate(selectedWord);
			
			// Show the score.
			if (app.getPracticeGamePanel() != null) 
				app.getPracticeGamePanel().getLblScore().setText("Score :"+this.wordScore);
			
			if (app.getOnlineGamePanel() != null) 
				app.getOnlineGamePanel().getLblScore().setText("Score :"+this.wordScore);
			
			g.setColor(Color.black);

			for (int i = 0; i < 16; i++) 
				g.drawString(letters[i], 
						11*width + (i%4)*cellWidth, 15*height + (i/4)*cellHeight);
		} else {						
			g.setColor(Color.black);

			for (int i = 0; i < 16; i++) 
				g.drawString(letters[i], 
						11*width + (i%4)*cellWidth, 15*height + (i/4)*cellHeight);

			list.clear();
			stop = false;
		}
	}
}