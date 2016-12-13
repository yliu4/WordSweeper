package client.controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import client.model.Cell;
import client.model.Model;
import client.model.Word;
import client.view.Application;
import client.view.BoardPanel;
import client.view.CellDrawer;

/**
 * This class controls copying gameId in the OnlineGamePanel.
 * 
 * @author Team Pisces
 *
 */
public class CopyGameIdController extends MouseAdapter implements MouseListener {
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/**
	 * CopyGameIdController constructor.
	 *
	 * @param model  Current model.
	 * @param application Current application.
	 */
	public CopyGameIdController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}
	

	/**
	 * MousePressed get mouse event when mouse clicked.
	 *
	 * @param me Mouse event when clicking.
	 */
	@Override
	public void mouseClicked(MouseEvent me) {
		String gameId = model.getGame().getGameId();
		StringSelection stringSelection = new StringSelection(gameId);
		Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		clpbrd.setContents(stringSelection, null);
		
		String test = "You successfully copy the gamd id (" + gameId + ")!";
		
		JOptionPane.showMessageDialog(app, test, "Copy Game Id",
				JOptionPane.PLAIN_MESSAGE);
	}
}
