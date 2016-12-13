package client.model;

import java.util.*;

import client.view.CellDrawer;

import util.WordTable;

/**
 * The Game contains a Board and a List of Players which includes the managing 
 * 
 * player and other participating players.
 * 
 * @author Team Pisces
 *
 */
public class Game {
	/** Each game has one board object */
	Board board = null;
	
	/** Each game has a list of players */
	ArrayList<Player> players = new ArrayList<Player>();
	
	/** A player who is playing the game */
	Player currentPlayer = null;
	
	/** The ID for the game */
	String gameId = null;

	/** Construct an empty Game. */
	public Game() {

	}
	
	/** 
	 * Construct a Game with given Player.
	 * 
	 * @param player The Player of this Game.
	 */
	public Game(Player player) {
		this.currentPlayer = player;
	}
		
	/**
	 * Handles the score calculation for the selected Word.
	 * 
	 * @param word The word to be calculated.
	 * @return The score of the Word.
	 */
	public long calculate(Word word) {
		ArrayList<Cell> cells = word.getCells();
		Iterator<Cell> iterator = cells.iterator();
		double score = 0;
		double tempscore = 0;
		boolean hasMulti = false;
		int length = 0;
		int m = 1;
		
		if (!WordTable.isWord(word.getWord())) {
			return 0;
		}
		
		while (iterator.hasNext()) {
			Cell cell = (Cell) iterator.next();
			
			if (cell.getLetter().isMultiplier()) {
				hasMulti = true;
			}
			
			length++;
			m = cell.getCounter();			
			tempscore = cell.getLetter().getPoint();
			
			if (m != 1){
				tempscore *= Math.pow(2, m);
			}
			
			score += tempscore;
		}
		
		score = Math.pow(2, length) * 10 * score;
		
		if (hasMulti) {
			score *= 10;
		}
		
		return (long) score;
	}
		
	/**
	 * Check the overlapping status of each Cell on the current Board.
	 */
	public void overlapCheck() {
		HashMap<Integer, Integer> positioncheck = new HashMap<Integer, Integer>();
		Iterator<Player> iterator = players.iterator();
		int startx = this.currentPlayer.getOriginPosition().getColumn();
		int starty = this.currentPlayer.getOriginPosition().getRow();
		
		for (int i = 0; i < 16; i++) {
			positioncheck.put(i, 1);
		}
		
		while (iterator.hasNext()) {
			Player temp = (Player) iterator.next();
			
			if (!temp.equals(currentPlayer)) {
				int tmpx = temp.getOriginPosition().getColumn() - startx;
				int tmpy = temp.getOriginPosition().getRow() - starty;
				int beginx = (tmpx>0)?tmpx:0;
				int beginy = (tmpy>0)?tmpy:0;
				int endx = (tmpx>0)?4:(tmpx+4);
				int endy = (tmpy>0)?4:(tmpy+4);
			
				for (tmpx = beginx; tmpx < endx; tmpx++) {
					for (tmpy = beginy; tmpy < endy; tmpy++) { 
						int count = positioncheck.get(tmpy * 4
								+ tmpx) + 1;
						
						positioncheck.put(tmpy * 4 + tmpx,
								count);
					}
				}
			}
		}
		
		ArrayList<Cell> cells = this.getBoard().getCells();
		
		for (int i = 0; i < 16; i ++) {
			Cell cell = cells.get(i);
			int cnt = positioncheck.get(i);
			
			if (cell.getLetter().isMultiplier())
				cell.getDrawer().setState(CellDrawer.StateBonus);
			else if (cnt > 1) 
				cell.getDrawer().setState(cnt);
			
			cells.get(i).setCounter(cnt);
		}
	}

	/** 
	 * Get the Board object.
	 * 
	 * @return The current Board.
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Set the Board with a List of Cells and the Location of the special multiplier.
	 * 
	 * @param cells A List of Cells.
	 * @param bonus The Location of the special multiplier.
	 */
	public void setBoard(ArrayList<Cell> cells, Location bonus) {
		this.board = new Board(cells);
		
		if (bonus.column >= 0 && bonus.column <= 3 && bonus.row <= 3
				&& bonus.row >= 0) {
			this.board.getCells().get(bonus.row * 4 + bonus.column)
				.getLetter().setMultiplier();
		}
	}

	/** 
	 * Get the object of the List of Players.
	 * 
	 * @return A List of Players.
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/** 
	 * Add a Player into the Player List.
	 * 
	 * @param player The Player rto be added.
	 */
	public void addPlayer(Player player) {
		this.players.add(player);
	}

	/** 
	 * Get the ID of this game.
	 * 
	 * @return A String representing the gameID.
	 */
	public String getGameId() {
		return gameId;
	}

	/** 
	 * Set the ID of the game.
	 * 
	 * @param gameId The ID of this game.
	 */
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	/** 
	 * Get the object of the current Player.
	 * 
	 * @return The current Player.
	 */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * Sort all the Players in decreasing order according to the score of 
	 * 
	 * each Player.
	 */
	public void sortPlayers() {
		if (players.size() <= 1) return;
		
		Comparator<Player> sortingMethod = new Comparator<Player>() {
			@Override
			public int compare(Player p1, Player p2) {
				return Long.valueOf(p1.getScore()).compareTo(Long.valueOf(p2.getScore()));
			}
		};
		
		Collections.sort(players, sortingMethod);
		Collections.reverse(players);
	}
}
