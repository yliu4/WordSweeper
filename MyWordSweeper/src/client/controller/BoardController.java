package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import client.model.Cell;
import client.model.Model;
import client.model.Word;
import client.view.Application;
import client.view.BoardPanel;

/**
 * The board controller is used to record the mouse motion on the board.
 *
 * @author Team Pisces
 * @since 2016-10-03
 */
public class BoardController extends MouseAdapter implements MouseMotionListener {
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>BoardPanel</code> for easy navigation. */
	BoardPanel panel;

	/** For recording the start coordinate in X-axle. */
	private int x = -1;
	
	/** For recording the start coordinate in Y-axle. */
	private int y = -1;
	
	/** For recording the relative dragged coordinate in X-axle. */
	private int deltaX;
	
	/** For recording the relative dragded coordinate in Y-axle. */
	private int deltaY;
	
	/** For avoiding sending repeated released event. */
	boolean press = false;
	
	/**
	 * BoardController constructor
	 *
	 * @param model  Current model.
	 * @param application Current application.
	 * @param panel  Current panel.
	 */
	public BoardController(Model model, Application app, BoardPanel panel) {
		this.app = app;
		this.model = model;
		this.panel = panel;
	}
	
	/**
	 * mousePressed get mouse event when mouse pressed
	 *
	 * @param me  mouse event when pressing
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
		this.deltaX = me.getX() - this.x;
		this.deltaY = me.getY() - this.y;
		panel.repaint();
	}
	
	/**
	 * mouseDragged get mouse event when mouse released
	 *
	 * @param me  mouse event when releasing
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		if(press == true) {
//			panel.calculateScoreForSelectedWord();
			this.x = -1;
			this.y = -1;
			this.deltaX = 0;
			this.deltaY = 0;
			panel.repaint();
			press = false;

			model.getGame().getCurrentPlayer().setScore(
					model.getGame().getCurrentPlayer().getScore() + 
					panel.getWordScore());
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDeltaX() {
		return deltaX;
	}

	public int getDeltaY() {
		return deltaY;
	}
}
