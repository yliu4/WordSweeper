package client.model;

public class Letter {
	String character = null; //Since we have 'Qu'
	boolean isMultiplier = false;
	int points = 0;
	
	public Letter(char character, int points) {
		if (character == 'Q') this.character = new String("Qu");
		else this.character = String.valueOf(character);
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
