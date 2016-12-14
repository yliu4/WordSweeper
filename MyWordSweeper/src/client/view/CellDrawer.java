package client.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.Serializable;

import client.model.Cell;

/**
 * This class is responsible for drawing a cell onto the board. 
 * 
 * @author Team Pisces
 *
 */
public class CellDrawer implements Serializable {
	/** Serializable key. */
	private static final long serialVersionUID = -8733988017461506064L;
	
	/** Bonus state. */
	public static final int StateBonus = -1;
	/** Normal state. */
	public static final int StateNormal = 0;
	/** Selected state. */
	public static final int StateSelected = 1;
	/** Overlapped state. */
	public static final int StateOverlapped = 2;
	
	/** State. */
	int mode = StateNormal;

	/** Default background color. */
	private Color background = new Color(250, 250, 250);
	/** Foreground color. */
	private Color foreground = Color.black;
	/** Selected cell's background color. */
	private Color selected   = Color.red;
	/** Bonus cell's background color. */
	private Color bonus = Color.yellow;
	
	/** 
	 * Get foreground color.
	 * 
	 * @return The foreground color.
	 */
	public Color getForeground() { 
		return foreground; 
	}
	
	/** 
	 * Get background color.
	 * 
	 * @return The background color.
	 */
	public Color getBackground() {
		if (mode == StateBonus) { 
			return bonus; 
		}
		
		if (mode == StateNormal) { 
			return background; 
		}
		
		if (mode == StateSelected) { 
			return selected; 
		}
		
		if (mode >= StateOverlapped) { 
			int gray = 275 - 25 * mode;
			
			gray = (gray < 5)? 5:gray;
			
			return new Color(gray, gray, gray);
		}
		
		return background; 
	}

	/** 
	 * A cell can be 'selected', 'overlapped', or 'normal'.
	 * 
	 * @return The state. 0 for normal. 1 for selected. 2 for overlapped. 
	 */
	public int getState () {
		return mode;
	}
	
	/** 
	 * Set the state of the drawer (selected, target, normal).
	 * 
	 * @param mode The state. 
	 */
	public void setState (int mode) {
		this.mode = (mode >= StateBonus)? mode:StateNormal;
	}
	
	/**
	 * Draws shape of cell.
	 * 
	 * Fill in background and then draw the text.
	 * 
	 * @param g The graphics. 
	 * @param c The cell. 
	 * @param cellWidth Width of the cell.
	 * @param cellHeight Height of the cell. 
	 * @param index Index of the cell. 
	 */
	public void drawCell(Graphics g, Cell c, int cellWidth, int cellHeight, int index) {
		fillBox(g, cellWidth, cellHeight, index);
		drawText(g, c, cellWidth, cellHeight, index);
	}

	/**
	 * Fill box (done before drawtext).
	 * 
	 * @param g The graphics.
	 * @param cellWidth Width of the cell.
	 * @param cellHeight Height of the cell. 
	 * @param index Index of the cell.
	 */
	public void fillBox(Graphics g, int cellWidth, int cellHeight, int index) {
		Color oldColor = g.getColor();
		
		g.setColor(getBackground());
		g.fillRect((index%4)*cellHeight+1, (index/4)*cellHeight+1
				, cellWidth-1, cellHeight-1);
		g.setColor(oldColor);
	}
	
	/**
	 * Draw the text. 
	 * 
	 * @param g The graphics. 
	 * @param cell The cell to be drew. 
	 * @param cellWidth Width of the cell.
	 * @param cellHeight Height of the cell. 
	 * @param index Index of the cell.
	 */
	public void drawText(Graphics g, Cell cell, int cellWidth, int cellHeight, int index) {
		Color oldColor = g.getColor();
		
		g.setColor(getForeground());
		g.drawString(cell.getLetter().getCharacter(), 
				11*cellWidth/26 + (index%4)*cellWidth, 
				15*cellHeight/26 + (index/4)*cellHeight);
		g.setColor(oldColor);
	}
	
	/**
	 * Reset the state to normal.
	 */
	public void resetState() {
		setState(StateNormal);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		if (o == null) return false;
		
		if (o instanceof CellDrawer) {
			CellDrawer drawer = (CellDrawer) o;
			
			return drawer.getState() == mode;
		}
		
		return false;
	}
}
