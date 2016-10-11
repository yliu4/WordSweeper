package client.model;

public class Letter {
	String character = null; 
	boolean isMultiplier = false;
	final int points = 0; // revise later
	
	public Letter(String character) {
		this.character = character;
	}
	
	public String getCharacter() {
		return this.character;
	}
	
	public int getPoint() {
		return this.points;
	}
	
	public boolean isMultiplier() {
		return this.isMultiplier;
	}
	
	public void setMultiplier() {
		this.isMultiplier = true;
	}
}
