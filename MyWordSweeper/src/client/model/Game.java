package client.model;

import java.util.*;

import util.WordTable;

/**
 * The <code>Game</code> contains a <code>Board</code> and a list of 
 * 
 * <code>Player</code>s which includes the managing player and other 
 * 
 * participating players.
 * 
 * @author Team Pisces
 *
 */
public class Game {
	Board board = null;
	ArrayList<Player> players = new ArrayList<Player>();
	Player managingPlayer = null;
	Player currentPlayer = null;
	String gameId = null;

	public Game() {

	}

	public Game(Player player) {
		this.currentPlayer = player;
	}
	
	/**
	 * Handles the score calculation of a given <code>Word</code>.
	 * 
	 * @param word The <code>Word</code> selected.
	 * @return The score of that <code>Word</code>.
	 */
	public long calculate(Word word) {
		double score = 0;
		long total = 0;
		boolean hasMulti = false;
		int length = 0;
		int m = 1;
		HashMap<Integer, Integer> overlapcheck = overlapCheck();
		ArrayList<Cell> cells = word.getCells();
		Iterator<Cell> i = cells.iterator();
		if (!WordTable.isWord(word.word)) {
			return 0;
		}
		while (i.hasNext()) {
			Cell c = (Cell) i.next();
			if (c.getLetter().isMultiplier()) {
				hasMulti = true;
			}
			if (c.getLetter().getCharacter().equals("Qu")) {
				length++;
			}
			length++;
			m = 1;
			if (overlapcheck.containsKey(c.getLocation().getColumn() * 4
					+ c.getLocation().getRow())) {
				m = overlapcheck.get(c.getLocation().getColumn() * 4
						+ c.getLocation().getRow());
			}
			score += c.getLetter().getPoint() * Math.pow(2, m);
		}
		score = Math.pow(2, length) * 10 * score;
		if (hasMulti) {
			score *= 10;
		}
		total = (long) score;
		return total;
	}
	
	/**
	 * 
	 * @return A <code>HashMap&lt;Integer, Integer&gt;</code> where the key is
	 * the <code>Integer</code> representing the location of a <code>Cell</code> on 
	 * the <code>Board</code>, and the value is the number of overlapped 
	 * <code>Player</code>s on that <code>Cell</code>.
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

	public Player getManagingPlayer() {
		return managingPlayer;
	}

	public void setManagingPlayer(Player managingPlayer) {
		this.managingPlayer = managingPlayer;
	}

	public Board getBoard() {
		return board;
	}

	/**
	 * Set the <code>Board</code> with a list of <code>Cell</code>s and the 
	 * 
	 * <code>Location</code> of the special multiplier.
	 * 
	 * @param cells 16 <code>Cell</code>s on this <code>Board</code>.
	 * @param bonus <code>Location</code> of the special multiplier.
	 */
	public void setBoard(ArrayList<Cell> cells, Location bonus) {
		this.board = new Board(cells);
		if (bonus.column >= 0 && bonus.column <= 3 && bonus.row <= 3
				&& bonus.row >= 0) {
			this.board.getCells().get(bonus.row * 4 + bonus.column).getLetter()
					.setMultiplier();
		}
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void addPlayer(Player player) {
		this.players.add(player);
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public Player getCurrentPlayer() {
		return currentPlayer;
	}
}
