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
	
	public long calculate(Word word) {
		//yaoxie
		return 0;
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
		this.board = new Board(cells);
		if (bonus.column >= 0 && bonus.column <= 3
				&& bonus.row <= 3 && bonus.row >= 0) {
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
