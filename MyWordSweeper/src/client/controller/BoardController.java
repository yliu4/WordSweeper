package client.controller;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import xml.Message;
import client.model.Game;
import client.model.Cell;
import client.model.Model;
import client.model.Word;
import client.view.Application;
import client.view.BoardPanel;
import client.view.CellDrawer;

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
	
	/** For avoiding sending repeated released event. */
	boolean press = false;
	
	/**
	 * BoardController constructor.
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
	 * MousePressed get mouse event when mouse pressed.
	 *
	 * @param me Mouse event when pressing.
	 */
	@Override
	public void mousePressed(MouseEvent me) {
        Word word= panel.getWord();        
        Cell cell = panel.getCell(me.getX(), me.getY());
        
        word.clear();
        
        // If the cell is valid, set state and store it. 
        if (cell != null) {
    		cell.getDrawer().setState(CellDrawer.StateSelected);
        	word.add(cell);
        	press = true;
        }
	}
	
	/**
	 * MouseDragged get mouse event when mouse dragged.
	 *
	 * @param me Mouse event when dragging.
	 */
	@Override
	public void mouseDragged(MouseEvent me) {
		if (press) { // Process only when the mouse is pressed.
	        Word word= panel.getWord();  
	        Cell cell = panel.getCell(me.getX(), me.getY());
	        
	        if (cell != null) {
	        	// We may store the cell only if it's the 
	        	// neighbor of the previous cell.
	        	if (word.isClose2Pre(cell)) {
	        		// If word contains the cell and the cell is not a
	        		// newly added cell, we stop recording.
	        		// Otherwise, set state and store it. 
		        	if (word.contains(cell) && !word.isNew(cell)) {
		        		press = false;
		        	}
		        	else {
		        		cell.getDrawer().setState(CellDrawer.StateSelected);
		        		word.add(cell);
		        	}
	        	}
	        	else 
	        		press = false;

			if (app.getPracticeGamePanel() == null) {
				app.getOnlineGamePanel().getLblCurrentWord().setText("Current Word: "
						+ panel.getWord().getWord());
				app.getOnlineGamePanel().getLblScore().setText("Score :"
						+ model.getGame().calculate(panel.getWord()));
			}
			else {
				app.getPracticeGamePanel().getLblCurrentWord().setText("Current Word: "
						+ panel.getWord().getWord());
				app.getPracticeGamePanel().getLblScore().setText("Score :"
						+ model.getGame().calculate(panel.getWord()));
			}
	        
			panel.repaint();
	        }
		}
	}
	
	/**
	 * MouseDragged get mouse event when mouse released.
	 *
	 * @param me Mouse event when releasing.
	 */
	@Override
	public void mouseReleased(MouseEvent me) {
		press = false;
		
		if (app.getPracticeGamePanel() == null) {
			// If word is empty, we do not send the request.
			if (panel.getWord().getWord().length() > 0) {
				Message msg = generateFindWordRequest();
				app.getServerAccess().sendRequest(msg);
			}
		}
		else 
			model.getGame().getCurrentPlayer().setScore(
					model.getGame().getCurrentPlayer().getScore() + 
					model.getGame().calculate(panel.getWord()));
		
		panel.resetDrawerState();
		panel.repaint();
	}
	
	/**
	 * Generate a message for sending findWordRequest to server.
	 *
	 * @return A message for findWordRequest.
	 */
	private Message generateFindWordRequest()
	{
		StringBuilder requestMessage = new StringBuilder();
		ArrayList<Cell> wordCells = panel.getWord().getCells();
		Game game = model.getGame();
		String gameId = game.getGameId();
		String playerName = game.getCurrentPlayer().getName();
		String word = panel.getWord().getWord();
		
		requestMessage.append(String.format("<findWordRequest gameId='%s' name='%s' word='%s'>",
				gameId, playerName, word));
		
		for (int i = 0; i < wordCells.size(); ++i) {
			Cell cell = wordCells.get(i);
			int col = cell.getLocation().getColumn() + 
					game.getCurrentPlayer().getOriginPosition().getColumn();
			int row = cell.getLocation().getRow() + 
					game.getCurrentPlayer().getOriginPosition().getRow();
			String cellStr = String.format("<cell position='%d,%d' letter='%s'/>",
					col,
					row,
					cell.getLetter().getCharacter());

			requestMessage.append(cellStr);
		}
		
		requestMessage.append("</findWordRequest></request>");
		
		return new Message (Message.requestHeader() + requestMessage.toString());
	}
}
