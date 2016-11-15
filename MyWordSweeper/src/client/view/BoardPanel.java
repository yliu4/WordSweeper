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
	
	/** An <code>ArrayList</code> for */
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	/** For building the current selected word. */
	StringBuilder currentWord;
	
	/** For recording the previous dragged cell */
	int prev;
	
	/** Mark if you dragged the same cell two times */
	boolean stop = false;
	
	BoardController boardController = null;

	/**
	 * Construct the panel for the board according to the cells. 
	 * 
	 * @param model <code>Model</code> for current application.
	 * @param cells <code>Cell</code>s in this <code>Board</code>.
	 */
	public BoardPanel(Model model, Application app, ArrayList<Cell> cells) {
		this.cells = cells;
		this.model = model;
		this.app = app;
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height / 360;
		int width = d.width / 640;
		
		setBounds(10*width, 68*height, 104*width, 104*height);
		currentWord = new StringBuilder();
		
		this.boardController = new BoardController(model, this);
		
		this.addMouseListener(boardController);
		this.addMouseMotionListener(boardController);
	}
	
	/** Get the board controller object 
	 * 
	 * @returnA <code>boardController</code> 
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
	 * Update the board with a list of new cells.
	 * 
	 * @param cells A new list of cells assigned to this board.
	 */
	public void updateCells(ArrayList<Cell> cells) {
		this.cells = cells;
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

		g.setColor(Color.black);
		g.setFont(new Font("Tahoma", Font.BOLD, 7*height));
		g.drawLine(0, 0, 104*width, 0);
		g.drawLine(0, 26*height, 104*width, 26*height);
		g.drawLine(0, 52*height, 104*width, 52*height);
		g.drawLine(0, 78*height, 104*width, 78*height);
		g.drawLine(0, 104*height-1, 104*width, 104*height-1);
		g.drawLine(0, 0, 0, 104*height);
		g.drawLine(26*width, 0, 26*width, 104*height);
		g.drawLine(52*width, 0, 52*width, 104*height);
		g.drawLine(78*width, 0, 78*width, 104*height);
		g.drawLine(104*width-1, 0, 104*width-1, 104*height);
		
		String s0 = this.cells.get(0).getLetter().getCharacter();
		String s1 = this.cells.get(1).getLetter().getCharacter();
		String s2 = this.cells.get(2).getLetter().getCharacter();
		String s3 = this.cells.get(3).getLetter().getCharacter();
		String s4 = this.cells.get(4).getLetter().getCharacter();
		String s5 = this.cells.get(5).getLetter().getCharacter();
		String s6 = this.cells.get(6).getLetter().getCharacter();
		String s7 = this.cells.get(7).getLetter().getCharacter();
		String s8 = this.cells.get(8).getLetter().getCharacter();
		String s9 = this.cells.get(9).getLetter().getCharacter();
		String s10 = this.cells.get(10).getLetter().getCharacter();
		String s11 = this.cells.get(11).getLetter().getCharacter();
		String s12 = this.cells.get(12).getLetter().getCharacter();
		String s13 = this.cells.get(13).getLetter().getCharacter();
		String s14 = this.cells.get(14).getLetter().getCharacter();
		String s15 = this.cells.get(15).getLetter().getCharacter();
		
		g.drawString(s0, 11*width, 15*height);
		g.drawString(s1, 37*width, 15*height);
		g.drawString(s2, 63*width, 15*height);
		g.drawString(s3, 89*width, 15*height);
		g.drawString(s4, 11*width, 41*height);
		g.drawString(s5, 37*width, 41*height);
		g.drawString(s6, 63*width, 41*height);
		g.drawString(s7, 89*width, 41*height);
		g.drawString(s8, 11*width, 67*height);
		g.drawString(s9, 37*width, 67*height);
		g.drawString(s10, 63*width, 67*height);
		g.drawString(s11, 89*width, 67*height);
		g.drawString(s12, 11*width, 93*height);
		g.drawString(s13, 37*width, 93*height);
		g.drawString(s14, 63*width, 93*height);
		g.drawString(s15, 89*width, 93*height);
		
		this.cells.get(0).setCoordinateLocation(0, 0, 26*width, 26*height);
		this.cells.get(1).setCoordinateLocation(26*width, 0, 26*width, 26*height);
		this.cells.get(2).setCoordinateLocation(52*width, 0, 26*width, 26*height);
		this.cells.get(3).setCoordinateLocation(78*width, 0, 26*width, 26*height);
		this.cells.get(4).setCoordinateLocation(0, 26*height, 26*width, 26*height);
		this.cells.get(5).setCoordinateLocation(26*width, 26*height, 26*width, 26*height);
		this.cells.get(6).setCoordinateLocation(52*width, 26*height, 26*width, 26*height);
		this.cells.get(7).setCoordinateLocation(78*width, 26*height, 26*width, 26*height);
		this.cells.get(8).setCoordinateLocation(0, 52*height, 26*width, 26*height);
		this.cells.get(9).setCoordinateLocation(26*width, 52*height, 26*width, 26*height);
		this.cells.get(10).setCoordinateLocation(52*width, 52*height, 26*width, 26*height);
		this.cells.get(11).setCoordinateLocation(78*width, 52*height, 26*width, 26*height);
		this.cells.get(12).setCoordinateLocation(0, 78*height, 26*width, 26*height);
		this.cells.get(13).setCoordinateLocation(26*width, 78*height, 26*width, 26*height);
		this.cells.get(14).setCoordinateLocation(52*width, 78*height, 26*width, 26*height);
		this.cells.get(15).setCoordinateLocation(78*width, 78*height, 26*width, 26*height);

		// record the cells mouse dragged. If mouse drags the previous cell, stop recording 
		Location location = this.model.getFilledBoard();
		if(location != null) {
			int x = location.getCoordinateX();
			int y = location.getCoordinateY();
			int dragWidth = location.getWidth();
			int dragHeight = location.getHeight();
			
			for(int i = 0; i < 16; i++) {
				Location cellLoc = this.cells.get(i).getLocation();
				if(x+dragWidth >= cellLoc.getCoordinateX()+5 && x+dragWidth <= cellLoc.getCoordinateX()+cellLoc.getWidth()-5 &&
				   y+dragHeight >= cellLoc.getCoordinateY()+5 && y+dragHeight <= cellLoc.getCoordinateY()+cellLoc.getHeight()-5)
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
			
			// fill the dragged cells
			for(Integer num : list) {
				Location cell = this.cells.get(num).getLocation();
				g.setColor(Color.blue);
				g.fillRect(cell.getCoordinateX(), cell.getCoordinateY(), cell.getWidth(), cell.getHeight());
			}
			
			g.setColor(Color.black);
			g.drawString(s0, 11*width, 15*height);
			g.drawString(s1, 37*width, 15*height);
			g.drawString(s2, 63*width, 15*height);
			g.drawString(s3, 89*width, 15*height);
			g.drawString(s4, 11*width, 41*height);
			g.drawString(s5, 37*width, 41*height);
			g.drawString(s6, 63*width, 41*height);
			g.drawString(s7, 89*width, 41*height);
			g.drawString(s8, 11*width, 67*height);
			g.drawString(s9, 37*width, 67*height);
			g.drawString(s10, 63*width, 67*height);
			g.drawString(s11, 89*width, 67*height);
			g.drawString(s12, 11*width, 93*height);
			g.drawString(s13, 37*width, 93*height);
			g.drawString(s14, 63*width, 93*height);
			g.drawString(s15, 89*width, 93*height);
		} else {
			currentWord.delete(0, currentWord.length());
			for(Integer num : list) {
				Location cell = this.cells.get(num).getLocation();
				currentWord.append(this.cells.get(num).getLetter().getCharacter());
				g.setColor(Color.blue);
				g.fillRect(cell.getCoordinateX(), cell.getCoordinateY(), cell.getWidth(), cell.getHeight());
			}
			
			OnlineGamePanel onlinePanel = this.app.getOnlineGamePanel();
			onlinePanel.setCurrentWord(currentWord.toString());
			
			g.setColor(Color.black);
			g.drawString(s0, 11*width, 15*height);
			g.drawString(s1, 37*width, 15*height);
			g.drawString(s2, 63*width, 15*height);
			g.drawString(s3, 89*width, 15*height);
			g.drawString(s4, 11*width, 41*height);
			g.drawString(s5, 37*width, 41*height);
			g.drawString(s6, 63*width, 41*height);
			g.drawString(s7, 89*width, 41*height);
			g.drawString(s8, 11*width, 67*height);
			g.drawString(s9, 37*width, 67*height);
			g.drawString(s10, 63*width, 67*height);
			g.drawString(s11, 89*width, 67*height);
			g.drawString(s12, 11*width, 93*height);
			g.drawString(s13, 37*width, 93*height);
			g.drawString(s14, 63*width, 93*height);
			g.drawString(s15, 89*width, 93*height);
			list.clear();
			stop = false;
		}
	}
}