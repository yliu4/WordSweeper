package client.controller;

import java.util.ArrayList;
import java.util.Random;

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
	 * BoardResponseController constructor
	 *
	 * @param app  	 initialize the reference of application
	 * @param panel  initialize the reference of panel
	 */
	public BoardResponseController(Application app, Model model) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * process board responses from server after createGameRquest or joinGameRequest
	 *
	 * @param Message board response message from server in xml format
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("boardResponse")) {
			return next.process(response);
		}

		// at this point, you would normally start processing this...
		OnlineGamePanel onlinePanel = app.getOnlineGamePanel();
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

		ArrayList<Cell> cells = new ArrayList<Cell>();
		String[] bonusLocation = bonus.split(",");
		Location bonusLoc = null;

		NodeList list = boardResponse.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			pname = n.getAttributes().getNamedItem("name").getNodeValue();
			pposition = n.getAttributes().getNamedItem("position").getNodeValue();
			pscore = n.getAttributes().getNamedItem("score").getNodeValue();
			String[] cellLocation = pposition.split(",");
			if(pname.equals(model.getGame().getCurrentPlayer().getName())) {
				pboard = n.getAttributes().getNamedItem("board").getNodeValue();
				bonusLoc = new Location(Integer.valueOf(bonusLocation[0])-Integer.valueOf(cellLocation[0]), 
						Integer.valueOf(bonusLocation[1])-Integer.valueOf(cellLocation[1]));
			}
			Player player = new Player(pname, Long.valueOf(pscore), new Location(Integer.valueOf(cellLocation[0]), Integer.valueOf(cellLocation[1])));
			game.getPlayers().add(player);
		}

		// set game id 
		game.setGameId(gameId);
		
		// set game board
		generateCells(pboard, cells);
		game.setBoard(cells, bonusLoc);
		
		// managing user
		if(model.getGame().getCurrentPlayer().getName().equals(managingUser))
			game.setManagingPlayer(model.getGame().getCurrentPlayer());
		
		// go to online panel
		onlinePanel.setGame(game);
		app.gotoOnlineGamePanel();
		onlinePanel.repaint();
		onlinePanel.revalidate();
		
		return true;
	}
	
	public void generateCells(String cellString, ArrayList<Cell> cells) {
		if(cellString.length() != 16) {
			System.err.println("Wrong cell string length");
			return;
		}
		
		cells.clear();
	
		for(int i = 0; i < cellString.length(); i++) {
			Location cellLocation = new Location(i/4, i%4);
			String letter = String.valueOf(cellString.charAt(i));
			
			if("Q".equals(letter)) letter = "Qu";
			
			Letter cellLetter = new Letter(letter);
			
			cells.add(new Cell(cellLocation, cellLetter));
		}
	}
}