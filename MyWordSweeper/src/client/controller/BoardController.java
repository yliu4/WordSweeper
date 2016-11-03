package client.controller;

import java.awt.event.*;

import client.model.Model;
import client.view.BoardPanel;

/**
 * The board controller is used to record the mouse motion on the board.
 *
 * @author Team Pisces
 * @since 2016-10-03
 */
public class BoardController extends MouseAdapter implements MouseMotionListener {
	Model model;
	BoardPanel panel;
	private int x;
	private int y;
	boolean press = false;
	
	/**
	 * BoardController constructor
	 *
	 * @param model  initialize model
	 * @param panel  initialize panel
	 */
	public BoardController(Model model, BoardPanel panel) {
		this.model = model;
		this.panel = panel;
	}
	
	/**
	 * mousePressed get mouse event when mouse pressed
	 *
	 * @param me mouse event when pressing
	 */
	@Override
	public void mousePressed(MouseEvent me) {
        this.x = me.getX();
        this.y = me.getY();
        press = true;
	}
	
	/**
	 * mouseDragged get mouse event when mouse dragged
	 *
	 * @param me mouse event when dragging
	 */
	@Override
	public void mouseDragged(MouseEvent me) {
		int deltaX = me.getX() - this.x;
		int deltaY = me.getY() - this.y;
		model.setFilledBoard(this.x, this.y, deltaX, deltaY);
		panel.repaint();
	}
	
	/**
	 * mouseDragged get mouse event when mouse released
	 *
	 * @param me mouse event when releasing
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		if(press == true) {
			model.setFilledBoard(-1, -1, 0, 0);
			panel.repaint();
			press = false;
		}
	}
}
