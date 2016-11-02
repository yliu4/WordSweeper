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
	public Application app;
	public Model model;
	private ArrayList<Cell> fakeCells;

	public BoardResponseController(Application a, Model m) {
		this.app = a;
		this.model = m;
	}

	public boolean process(Message response) {
		
		System.out.println("RESPONSE!!!!!");
		
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals("boardResponse")) {
			return next.process(response);
		}

		Node boardResponse = response.contents.getFirstChild();
		NamedNodeMap map = boardResponse.getAttributes();

		// get global game board information
		String gameId = map.getNamedItem("gameId").getNodeValue();
		String contents = map.getNamedItem("contents").getNodeValue();
		String managingUser = map.getNamedItem("managingUser").getNodeValue();
		String bonus = map.getNamedItem("managingUser").getNodeValue();

		// get game board information for the managing user
		// TODO: need to construct a board from the following information
		ArrayList<Cell> cells = new ArrayList<Cell>();
		// TODO: need to set the bonus from server response
		Location bonusLoc = new Location(10, 10);

		NodeList list = boardResponse.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node n = list.item(i);
			String pname = n.getAttributes().getNamedItem("name")
					.getNodeValue();
			String pboard = n.getAttributes().getNamedItem("board")
					.getNodeValue();
			String pposition = n.getAttributes().getNamedItem("position")
					.getNodeValue();
			String pscore = n.getAttributes().getNamedItem("score")
					.getNodeValue();
		}

		// at this point, you would normally start processing this...
		// TBD

		OnlineGamePanel onlinePanel = app.getOnlineGamePanel();
		Game game = onlinePanel.getGame();
		boolean creatingNewGame = false;
		if (game == null) {
			creatingNewGame = true;
			game = new Game(new Player(managingUser, 0, new Location(1, 1)));
		}

		// TODO: fake board for now, will be replaced by board generated from
		// server response
		game.setGameId(gameId);
		Location nomulti = new Location(10, 10);
		game.setBoard(this.generatecells(), nomulti);
		
		if (creatingNewGame)
		{
			onlinePanel.setGame(game);
			app.gotoOnlineGamePanel();
			onlinePanel.repaint();
			onlinePanel.revalidate();
		}

		return true;
	}
	
	// -----------------------------------------------------------------------------------------------
	// TODO:
	// The following cell generation code will be removed once we have completed
	// server communication
	// -----------------------------------------------------------------------------------------------
	/**
	 * Randomly generate 16 <code>Cells</code> for the <code>Board</code>
	 * 
	 * @return A List of <code>Cells</code>
	 */
	public ArrayList<Cell> generatecells() {
		if (this.fakeCells == null) {
			this.fakeCells = new ArrayList<Cell>(16);

			String[] alp = new String[] { "A", "B", "C", "D", "E", "F", "G",
					"H", "I", "J", "K", "L", "M", "N", "O", "P", "Qu", "R",
					"S", "T", "U", "V", "W", "X", "Y", "Z" };
			int l = alp.length;
			Random r = new Random(System.currentTimeMillis());
			for (int y = 0; y <= 3; y++) {
				for (int x = 0; x <= 3; x++) {
					String s = alp[r.nextInt(l)];
					Letter le = new Letter(s);
					Location lo = new Location(x, y);
					Cell ce = new Cell(lo, le);
					fakeCells.add(ce);
				}
			}
		}

//		ArrayList<Cell> subBoard = new ArrayList<Cell>();
//
//		int rowStart = Math.max(0, subBoardStartRow);
//		rowStart = Math.min(rowStart, 8 - 4);
//		int rowEnd = rowStart + 3;
//		int colStart = Math.max(0, subBoardStartColumn);
//		colStart = Math.min(colStart, 8 - 4);
//		int colEnd = colStart + 3;
//
//		for (int row = rowStart; row < rowEnd; ++row) {
//			for (int col = colStart; col < colEnd; ++col) {
//				Cell c = cells.get(row * 8 + col);
//				subBoard.add(c);
//			}
//		}
//
//		return subBoard;
		
		return fakeCells;
	}
}
