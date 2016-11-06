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
	Application app;
	
	/** An <code>ArrayList</code> for the <code>Cell</code>s in a <code>Board</code>. */
	ArrayList<Cell> cells;
	
	/** An <code>ArrayList</code> for */
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	/** For building the current selected word. */
	StringBuilder currentWord;
	
	/** */
	int prev;
	
	/** */
	boolean stop = false;

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
		int height = d.height;
		int width = d.width;
		
		setBounds(height/36, 17*width/160, 13*height/45, 13*width/80);
		currentWord = new StringBuilder();
		
		BoardController control = new BoardController(model, this);
		
		this.addMouseListener(control);
		this.addMouseMotionListener(control);
	}

	/**
	 * Get the current selected word.
	 * 
	 * @return A <code>String</code> represents the current selected word.
	 */
	public String getCurrentWord() {
		return this.currentWord.toString();
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
		int height = d.height;
		int width = d.width;

		g.setColor(Color.black);
		g.setFont(new Font("Tahoma", Font.BOLD, 7*height/360));
		g.drawLine(0, 0, 13*height/45, 0);
		g.drawLine(0, 13*width/320, 13*height/45, 13*width/320);
		g.drawLine(0, 26*width/320, 13*height/45, 13*width/160);
		g.drawLine(0, 39*width/320, 13*height/45, 39*width/320);
		g.drawLine(0, 52*width/320-1, 13*height/45, 13*width/80-1);
		g.drawLine(0, 0, 0, 13*width/80);
		g.drawLine(13*height/180, 0, 13*height/180, 13*width/80);
		g.drawLine(26*height/180, 0, 13*height/90, 13*width/80);
		g.drawLine(39*height/180, 0, 13*height/60, 13*width/80);
		g.drawLine(52*height/180-1, 0, 13*height/45-1, 13*width/80);
		
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
		
		g.drawString(s0, 11*height/360, 3*width/128);
		g.drawString(s1, 37*height/360, 3*width/128);
		g.drawString(s2, 7*height/40, 3*width/128);
		g.drawString(s3, 89*height/360, 3*width/128);
		g.drawString(s4, 11*height/360, 41*width/640);
		g.drawString(s5, 37*height/360, 41*width/640);
		g.drawString(s6, 7*height/40, 41*width/640);
		g.drawString(s7, 89*height/360, 41*width/640);
		g.drawString(s8, 11*height/360, 67*width/640);
		g.drawString(s9, 37*height/360, 67*width/640);
		g.drawString(s10, 7*height/40, 67*width/640);
		g.drawString(s11, 89*height/360, 67*width/640);
		g.drawString(s12, 11*height/360, 93*width/640);
		g.drawString(s13, 37*height/360, 93*width/640);
		g.drawString(s14, 7*height/40, 93*width/640);
		g.drawString(s15, 89*height/360, 93*width/640);
		
		this.cells.get(0).setCoordinateLocation(0, 0, 13*height/180, 13*width/320);
		this.cells.get(1).setCoordinateLocation(13*height/180, 0, 13*height/180, 13*width/320);
		this.cells.get(2).setCoordinateLocation(26*height/180, 0, 13*height/180, 13*width/320);
		this.cells.get(3).setCoordinateLocation(39*height/180, 0, 13*height/180, 13*width/320);
		this.cells.get(4).setCoordinateLocation(0, 13*width/320, 13*height/180, 13*width/320);
		this.cells.get(5).setCoordinateLocation(13*height/180, 13*width/320, 13*height/180, 13*width/320);
		this.cells.get(6).setCoordinateLocation(26*height/180, 13*width/320, 13*height/180, 13*width/320);
		this.cells.get(7).setCoordinateLocation(39*height/180, 13*width/320, 13*height/180, 13*width/320);
		this.cells.get(8).setCoordinateLocation(0, 26*width/320, 13*height/180, 13*width/320);
		this.cells.get(9).setCoordinateLocation(13*height/180, 26*width/320, 13*height/180, 13*width/320);
		this.cells.get(10).setCoordinateLocation(26*height/180, 26*width/320, 13*height/180, 13*width/320);
		this.cells.get(11).setCoordinateLocation(39*height/180, 26*width/320, 13*height/180, 13*width/320);
		this.cells.get(12).setCoordinateLocation(0, 39*width/320, 13*height/180, 13*width/320);
		this.cells.get(13).setCoordinateLocation(13*height/180, 39*width/320, 13*height/180, 13*width/320);
		this.cells.get(14).setCoordinateLocation(26*height/180, 39*width/320, 13*height/180, 13*width/320);
		this.cells.get(15).setCoordinateLocation(39*height/180, 39*width/320, 13*height/180, 13*width/320);

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
			g.drawString(s0, 11*height/360, 3*width/128);
			g.drawString(s1, 37*height/360, 3*width/128);
			g.drawString(s2, 7*height/40, 3*width/128);
			g.drawString(s3, 89*height/360, 3*width/128);
			g.drawString(s4, 11*height/360, 41*width/640);
			g.drawString(s5, 37*height/360, 41*width/640);
			g.drawString(s6, 7*height/40, 41*width/640);
			g.drawString(s7, 89*height/360, 41*width/640);
			g.drawString(s8, 11*height/360, 67*width/640);
			g.drawString(s9, 37*height/360, 67*width/640);
			g.drawString(s10, 7*height/40, 67*width/640);
			g.drawString(s11, 89*height/360, 67*width/640);
			g.drawString(s12, 11*height/360, 93*width/640);
			g.drawString(s13, 37*height/360, 93*width/640);
			g.drawString(s14, 7*height/40, 93*width/640);
			g.drawString(s15, 89*height/360, 93*width/640);
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
			g.drawString(s0, 11*height/360, 3*width/128);
			g.drawString(s1, 37*height/360, 3*width/128);
			g.drawString(s2, 7*height/40, 3*width/128);
			g.drawString(s3, 89*height/360, 3*width/128);
			g.drawString(s4, 11*height/360, 41*width/640);
			g.drawString(s5, 37*height/360, 41*width/640);
			g.drawString(s6, 7*height/40, 41*width/640);
			g.drawString(s7, 89*height/360, 41*width/640);
			g.drawString(s8, 11*height/360, 67*width/640);
			g.drawString(s9, 37*height/360, 67*width/640);
			g.drawString(s10, 7*height/40, 67*width/640);
			g.drawString(s11, 89*height/360, 67*width/640);
			g.drawString(s12, 11*height/360, 93*width/640);
			g.drawString(s13, 37*height/360, 93*width/640);
			g.drawString(s14, 7*height/40, 93*width/640);
			g.drawString(s15, 89*height/360, 93*width/640);
			list.clear();
			stop = false;
		}
	}
}
