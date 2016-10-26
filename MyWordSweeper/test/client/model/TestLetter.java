package client.model;

import junit.framework.TestCase;
import client.model.*;

public class TestLetter extends TestCase {
	public void testConstructor() {
		String s = "B";
		
		Letter letter = new Letter(s);
		
		assertEquals(s, letter.getCharacter());
	}
	
	public void testSetMultiplier() {
		String s = "B";
		
		Letter letter = new Letter(s);
		letter.setMultiplier();
		
		assertEquals(true, letter.isMultiplier());
	}
}
