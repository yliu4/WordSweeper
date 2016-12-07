package client.controller;

import java.util.ArrayList;
import java.util.Vector;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import xml.Message;
import client.model.Cell;
import client.model.Game;
import client.model.Letter;
import client.model.Location;
import client.model.Model;
import client.model.Player;
import client.view.Application;
import client.view.OnlineGamePanel;

/**
 * The board response controller is used to process board response from server.
 * 
 * And it will draw a new board if it's for create game request, otherwise
 * update the board.
 * 
 * @author Team Pisces
 * @since 2016-10-30
 */
public class BoardResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	public Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	public Model model;
	
	/**
	 * BoardResponseController constructor.
	 *
	 * @param model  The model.
	 * @param app    The application.
	 */
	public BoardResponseController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * Process board responses from server after createGameRquest or joinGameRequest
	 *
	 * @param Message board response message from server in xml format
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		
		if (!type.equals("boardResponse")) {
			return next.process(response);
		}

		Game game = model.getGame();
		
		game.getPlayers().clear();

		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();
		String gameId = null, managingUser = null, bonus = null;
		String pname = null, pboard = null, pposition = null, pscore = null;
		
		// get global game board information
		gameId = map.getNamedItem("gameId").getNodeValue();
		managingUser = map.getNamedItem("managingUser").getNodeValue();
		bonus = map.getNamedItem("bonus").getNodeValue();
		
		// get game board information for the managing user
		ArrayList<Cell> cells = new ArrayList<Cell>();
		String[] bonusLocation = bonus.split(",");
		Location bonusLoc = null;
		NodeList list = boardResponse.getChildNodes();
		
		app.getOnlineGamePanel().getRowData().clear();
		
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);

			pname = n.getAttributes().getNamedItem("name").getNodeValue();
			pposition = n.getAttributes().getNamedItem("position").getNodeValue();
			pscore = n.getAttributes().getNamedItem("score").getNodeValue();
			
			String[] cellLocation = pposition.split(",");
			
			if(pname.equals(model.getGame().getCurrentPlayer().getName())) {
				pboard = n.getAttributes().getNamedItem("board").getNodeValue();
				bonusLoc = new Location(Integer.valueOf(bonusLocation[1])-Integer.valueOf(cellLocation[1]), 
						Integer.valueOf(bonusLocation[0])-Integer.valueOf(cellLocation[0]));
				app.getOnlineGamePanel().getLblRank().setText("You are at "
						+ (i+1) +"/" + list.getLength() + ".");
				model.getGame().getCurrentPlayer().setScore(Long.valueOf(pscore));
				model.getGame().getCurrentPlayer().setOriginPosition(new Location(Integer.valueOf(cellLocation[1]), Integer.valueOf(cellLocation[0])));
			}
			
			Player player = new Player(pname, Long.valueOf(pscore)
					, new Location(Integer.valueOf(cellLocation[1]), Integer.valueOf(cellLocation[0])));
			
			game.getPlayers().add(player);
		}
		
		game.sortPlayers();
		for (int i = 1; i <= game.getPlayers().size(); i++) {
			Player p = game.getPlayers().get(i-1);
			Vector tmp = new Vector();
			
			tmp.add(i);
			tmp.add(p.getName());
			tmp.add(p.getScore());
			app.getOnlineGamePanel().getRowData().add(tmp);
			
			if(p.getName().equals(model.getGame().getCurrentPlayer().getName())) {
				app.getOnlineGamePanel().getLblRank().setText("You are at "
						+ i +"/" + list.getLength() + ".");
			}
		}

		// Set game id 
		game.setGameId(gameId);
		
		// Set game board
		generateCells(pboard, cells);
		game.setBoard(cells, bonusLoc);

		// Set managing user
		if(model.getGame().getCurrentPlayer().getName().equals(managingUser)) {
			game.setManagingPlayer(model.getGame().getCurrentPlayer());
//			app.getOnlineGamePanel().getBtnLockGame().setVisible(true);
			app.getOnlineGamePanel().getBtnResetGame().setVisible(true);
		}
		else {
//			game.setManagingPlayer(managingUser);
			app.getOnlineGamePanel().getBtnLockGame().setVisible(false);
			app.getOnlineGamePanel().getBtnResetGame().setVisible(false);
		}

		app.getOnlineGamePanel().getLblCurrentWord().setText("Current Word: ");
		app.getOnlineGamePanel().getLblScore().setText("Score: ");
		
		// Go to online panel
		app.gotoOnlineGamePanel();
		
		return true;
	}
	
	public void generateCells(String cellString, ArrayList<Cell> cells) {
		cells.clear();
		
		String[] arr = cellString.split(",");
	
		for(int i = 0; i < 16; i++) {
			Location cellLocation = new Location(i/4, i%4);
			Letter cellLetter = new Letter(arr[i]);
			
			cells.add(new Cell(cellLocation, cellLetter));
		}
	}
}