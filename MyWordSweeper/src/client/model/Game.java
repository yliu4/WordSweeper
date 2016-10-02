package client.model;

import java.util.*;

public class Game {
	Board board = null;
	ArrayList<Player> players = new ArrayList<Player>();
	Player managingPlayer = null;
	Player currentPlayer = null;
	String gameId = null;
	
	public Game(){
		
	}
	
	public Game(Player player) {
		this.currentPlayer = player;
	}
	
	public int calculate(Word word) {
		return 0;
		// i don't know what to do with this
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

	public void setBoard(ArrayList<Cell> cells, Location bonus) {
		// Should we pass String or Board?
		// the location of bonus is relative location in 4*4 board
		this.board = new Board(cells);
		if (bonus.column >= 0 && bonus.column <= 4
				&& bonus.row <= 4 && bonus.row >= 0) {
			this.board.getCells().get(bonus.row*4+bonus.column).getLetter().setMultiplier();
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
