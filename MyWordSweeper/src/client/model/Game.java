package client.model;

import java.util.*;

import util.WordTable;

/**
 * The Game contains a board and a list of players 
 * which includes the managing player and other
 * participating players
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

	/** construct for the game */
	public Game() {

	}
	
   /** construct a game with given player */
	public Game(Player player) {
		/** assign a current player */
		this.currentPlayer = player;
	}
		
	/**
	 * Handles the score calculation for the selected word
	 * 
	 * @param word
	 * @return
	 */
	public long calculate(Word word) {
		/** The score for the selected word */
		double score = 0;

		/** A variable to store the temporary score */
		double tempscore = 0;
		
		/** The total score for the word */

		long total = 0;
		
		/** Set if the word is multiplier as false */
		boolean hasMulti = false;
		
		/** The length of the word */
		int length = 0;
		
		/** The letter shared by one player */
		int m = 1;
		
		/** Hashmap to check if it is overlap with the other player */
		HashMap<Integer, Integer> overlapcheck = overlapCheck();
		
		/** Get the cells for the selected word */
		ArrayList<Cell> cells = word.getCells();
		
		/** Iterate all the cells */
		Iterator<Cell> i = cells.iterator();
		
		/** If the selected word is not a valid word, directly return */
		if (!WordTable.isWord(word.word)) {
			return 0;
		}
		
		/** Iterate all the cells */
		while (i.hasNext()) {
			Cell c = (Cell) i.next();
			
			/** Check if the letter is multiplier */
			if (c.getLetter().isMultiplier()) {
				/** Set it as true */
				hasMulti = true;
			}
	
			/** Calculate the length of word */
			if (c.getLetter().getCharacter().equals("Qu")) {
				length++;
			}
			length++;
			
			/** The letter is shared  by one player */
			m = 1;
			
			/**  Check if the letter is shared by multiple players */
			if (overlapcheck.containsKey(c.getLocation().getColumn() * 4 + c.getLocation().getRow())) {
				/** Get the number of players who shared the letter */
				if (overlapcheck.containsKey(c.getLocation().getColumn() * 4
						+ c.getLocation().getRow())) {
					m = overlapcheck.get(c.getLocation().getColumn() * 4
							+ c.getLocation().getRow());
				}
				
			/** Calculate the score of the letter */
			score += c.getLetter().getPoint() * Math.pow(2, m);
			}
		
			/** Calculate the score for the selected word */
			score = Math.pow(2, length) * 10 * score;
			
			/** Check if the word is multiplier */
			if (hasMulti) {
				/** If it is, multiply 10 */
				score *= 10;
			}
		}
		
			/** The total score for the word */
			total = (long) score;
			
			/** Return the score */
			return total;	
	}
		
	/**
	 * A HashMap where the key is the location of a cell on the board
	 * and the value is the number of overlapped
	 * @return
	 */
	public HashMap<Integer, Integer> overlapCheck() {
		/** A hashmap to check if the cell is overlap */
		HashMap<Integer, Integer> positioncheck = new HashMap<Integer, Integer>();
		
		/** Iterator all the players */
		Iterator<Player> i = players.iterator();
		
		/** Get the column of the cell */
		int startx = this.currentPlayer.getOriginPosition().getColumn();
		
		/** Get the row of the cell */
		int starty = this.currentPlayer.getOriginPosition().getRow();
		
		/** Iterate all the cells, and put them in the hashmap */
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				/** Put the location of each cell in the hashmap */
				positioncheck.put((startx + x) * 4 + (starty + y), 1);
			}
		}
		
		/** Iterate the hashmap */
		while (i.hasNext()) {
			/** Get the player */
			Player temp = (Player) i.next();
			
			/** Get the column of board for the player */
			startx = temp.getOriginPosition().getColumn();
			
			/** Get the row of board for the player */
			starty = temp.getOriginPosition().getRow();
			
			/** Count the number of overlap players */
			for (int x = 0; x < 4; x++) {
				for (int y = 0; y < 4; y++) { 
					/** Check if the hashmap contained the position */
					if (positioncheck.containsKey((startx + x) * 4
							+ (starty + y))) {
						/** If it is, add one to the count*/
						int count = positioncheck.get((startx + x) * 4
								+ (starty + y)) + 1;
						
						/** Put the cell's position and the number of overlap players in the hashmap */
						positioncheck.put((startx + x) * 4 + (starty + y),
								count);
					}
				}
			}
		}
		
		/** Return the hashMap */
		return positioncheck;
	}
	
	/** Get the managing user */
	public Player getManagingPlayer() {
		return managingPlayer;
	}

	/** Set the managing user */
	public void setManagingPlayer(Player managingPlayer) {
		this.managingPlayer = managingPlayer;
	}

	/** Get the board object */
	public Board getBoard() {
		return board;
	}

	/**
	 * Set the board with a list of cells and the location of the special multiplier
	 * 
	 * @param cells
	 * @param bonus
	 */
	public void setBoard(ArrayList<Cell> cells, Location bonus) {
		/** construct a board with a list of cells */
		this.board = new Board(cells);
		
		/** Set the special multiplier for the cells with valid column and row */
		if (bonus.column >= 0 && bonus.column <= 3 && bonus.row <= 3
				&& bonus.row >= 0) {
			/** set the cell as multiplier */
			this.board.getCells().get(bonus.row * 4 + bonus.column).getLetter()
					.setMultiplier();
		}
	}

	/** Get the player object */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/** Add the player into the player list */
	public void addPlayer(Player player) {
		this.players.add(player);
	}

	/** Get the ID for this game */
	public String getGameId() {
		return gameId;
	}

	/** Set the ID for the game */
	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	/** get the current player object */
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
}
