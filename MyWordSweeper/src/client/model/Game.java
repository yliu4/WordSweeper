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
		int score = 0;
		ArrayList<Cell> cells = word.getCells();
		Iterator<Cell> i = cells.iterator();
		while (i.hasNext()){
			Cell c = (Cell)i.next();
			if (c.getLetter().isMultiplier()){
				score *=10;
			}
			else{
				score += c.getLetter().getPoint();
			}
		}
		return score;
	}
	
	public HashMap<Location, Integer> overlapCheck(){
		HashMap<Location, Integer> positioncheck = new HashMap<Location, Integer>();
		Iterator<Player> i = players.iterator();
		int startx = this.currentPlayer.getOriginPosition().getColumn();
		int starty = this.currentPlayer.getOriginPosition().getRow();
		for (int x=0;x<4;x++){
			for (int y =0;y<4;y++){
				Location l = new Location(startx+x, starty+y);
					positioncheck.put(l, 1);
				}
			}
		while(i.hasNext()){
			Player temp = (Player) i.next();
			startx = temp.getOriginPosition().getColumn();
			starty = temp.getOriginPosition().getRow();
			for (int x=0;x<4;x++){
				for (int y =0;y<4;y++){
					Location l = new Location(startx+x, starty+y);
					if (positioncheck.containsKey(l)){
						int count = positioncheck.get(l)+1;
						positioncheck.put(l, count);
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
