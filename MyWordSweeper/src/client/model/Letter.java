package client.model;

/**
 * The <code>Letter</code> class contains its score and a flag to identify
 * 
 * whether this letter is the special multiplier or not.
 * 
 * @author Team Pisces
 *
 */
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
	
	public boolean equals(Object obj) {
		Letter letter = (Letter) obj;
		
		return (character.equals(letter.getCharacter()) && 
				(points == letter.getPoint()) &&
				(isMultiplier == letter.isMultiplier()));
	}
}
