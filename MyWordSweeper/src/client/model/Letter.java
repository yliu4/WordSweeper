package client.model;

import java.util.HashMap;

import util.Scoremap;

/**
 * This class contains its score and a flag to identify whether this 
 * letter is the special multiplier or not
 * 
 * @author Team Pisces
 *
 */
public class Letter {
	/** A character for each letter */
	String character = null; 
	
	/** Set the letter's multiplier as false */
	boolean isMultiplier = false;
	
	/** Points for the letter */
	final int points; 
	
	/** Create a new score map */
	final Scoremap SMap = new Scoremap(); 
	
	/** Construct a letter with given character */
	public Letter(String character) {
		/** Assign the given character */
		this.character = character;
		
		/** Find the score of the letter from the score map */
		this.points = SMap.findLetterScore(character);
	}
	
	/** Get the character object */
	public String getCharacter() {
		return this.character;
	}
	
	/** Get the point of the letter */
	public int getPoint() {
		return this.points;
	}
	
	/** Check if the letter is multiplier */
	public boolean isMultiplier() {
		return this.isMultiplier;
	}
	
	/** Set the Multiplier as true */
	public void setMultiplier() {
		this.isMultiplier = true;
	}
	
	/** Check if the letter is equal to the object */
	public boolean equals(Object obj) {
		Letter letter = (Letter) obj;
		
		return (character.equals(letter.getCharacter()) && 
				(points == letter.getPoint()) &&
				(isMultiplier == letter.isMultiplier()));
	}
}
