package client.model;

import java.util.Hashtable;

public class Letter {
	String character = null; //Since we have 'Qu'
	boolean isMultiplier = false;
	int points = 0;
	
	public Letter(String character, int points) {
		this.character = character;
		this.points = points;
	}
	
	public String getCharacter() {
		return this.character;
	}
	
	public int GetPoint() {
		return this.points;
	}
	
	public boolean isMultiplier() {
		return this.isMultiplier;
	}
	
	public void setMultiplier() {
		this.isMultiplier = true;
	}
}
