package client.model;

import util.ScoreMap;

/**
 * This class contains the points of the Letter and a flag to identify whether 
 * 
 * this Letter is the special multiplier or not.
 * 
 * @author Team Pisces
 *
 */
public class Letter {
	/** The character in this Letter. */
	String character = null; 
	
	/** 
	 * The flag indicating whether this Letter is the special multiplier. 
	 * 
	 * It's set to <code>false</code> in default.
	 */
	boolean isMultiplier = false;
	
	/** Points of the Letter. */
	final int points; 
	
	/** 
	 * Construct a Letter with a given character.
	 * 
	 * @param character The character in this Letter.
	 */
	public Letter(String character) {
		this.character = character;
		this.points = ScoreMap.findLetterScore(character);
	}
	
	/** 
	 * Get the character of this Letter.
	 * 
	 * @return A String representing the character in a Letter.
	 */
	public String getCharacter() {
		return this.character;
	}
	
	/** 
	 * Get the points of the letter.
	 * 
	 * @return An <code>int</code> representing the points of a Letter.
	 */
	public int getPoint() {
		return this.points;
	}
	
	/** 
	 * Check if the Letter is a special multiplier.
	 * 
	 * @return <code>true</code> if it's a special multiplier, 
	 * <code>false</code> if it's not a special multiplier.
	 */
	public boolean isMultiplier() {
		return this.isMultiplier;
	}
	
	/** Set this Letter as the special multiplier. */
	public void setMultiplier() {
		this.isMultiplier = true;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Letter letter = (Letter) obj;
		
		return (character.equals(letter.getCharacter()) && 
				(points == letter.getPoint()) &&
				(isMultiplier == letter.isMultiplier()));
	}
}
