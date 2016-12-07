package client.model;

import java.util.*;

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
	
	/** Manager player for each game */
	Player managingPlayer = null;
	
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
		HashMap<Integer, Integer> overlapcheck = null;
		
		if (players.size() != 0) 
			overlapcheck = overlapCheck();
		
		ArrayList<Cell> cells = word.getCells();
		Iterator<Cell> i = cells.iterator();
		double score = 0;
		double tempscore = 0;
		boolean hasMulti = false;
		int length = 0;
		int m = 1;
		
		if (!WordTable.isWord(word.word)) {
			return 0;
		}
		
		while (i.hasNext()) {
			Cell c = (Cell) i.next();
			
			if (c.getLetter().isMultiplier()) {
				hasMulti = true;
			}
			
			length++;
			m = 1;
			
			if (overlapcheck != null && 
					overlapcheck.containsKey(c.getLocation().getColumn() * 4 +
					c.getLocation().getRow())) {
				m = overlapcheck.get(c.getLocation().getColumn() * 4
						+ c.getLocation().getRow());
			}
			
			tempscore = c.getLetter().getPoint();
			
			if (m!=1){
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
	 * 
	 * @return A HashMap&lt;Integer, Integer&gt; where the key is a Integer of 
	 * representing the location of a Cell on the Board, and the value is the 
	 * number of overlapped Players on that Cell.
	 */
	public HashMap<Integer, Integer> overlapCheck() {
		HashMap<Integer, Integer> positioncheck = new HashMap<Integer, Integer>();
		Iterator<Player> i = players.iterator();
		int startx = this.currentPlayer.getOriginPosition().getColumn();
		int starty = this.currentPlayer.getOriginPosition().getRow();
		
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				positioncheck.put((startx + x) * 4 + (starty + y), 1);
			}
		}
		
		while (i.hasNext()) {
			Player temp = (Player) i.next();
			
			startx = temp.getOriginPosition().getColumn();
			starty = temp.getOriginPosition().getRow();
			
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) { 
					if (positioncheck.containsKey((startx + x) * 4
							+ (starty + y))) {
						int count = positioncheck.get((startx + x) * 4
								+ (starty + y)) + 1;
						
						positioncheck.put((startx + x) * 4 + (starty + y),
								count);
					}
				}
			}
		}
		
		return positioncheck;
	}
	
	/** 
	 * Get the managing player.
	 * 
	 * @return A Player that is the managing player.
	 */
	public Player getManagingPlayer() {
		return managingPlayer;
	}

	/** 
	 * Set the managing player.
	 * 
	 * @param managingPlayer The managing Player.
	 */
	public void setManagingPlayer(Player managingPlayer) {
		this.managingPlayer = managingPlayer;
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
			this.board.getCells().get(bonus.row * 4 + bonus.column).getLetter()
					.setMultiplier();
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
