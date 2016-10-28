package client.model;

import java.util.HashMap;

import util.Scoremap;

/**
 * The letter class contains its score and multiplier.
 * 
 * @author team Pisces
 * 
 */
public class Letter {
	String character = null;
	boolean isMultiplier = false;
	final int points; // revise later
	final Scoremap SMap = new Scoremap();

	public Letter(String character) {
		this.character = character;
		this.points = SMap.findLetterScore(character);
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
