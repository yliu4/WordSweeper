package client.model;

import junit.framework.TestCase;

/**
 * The <code>TestLetter</code> class tests the <code>Letter</code> class.
 * 
 * @author Team Pisces
 *
 */
public class TestLetter extends TestCase {
	/**
	 * Test the constructor.
	 */
	public void testConstructor() {
		String str = "B";
		Letter letter = new Letter(str);
		
		assertEquals(str, letter.getCharacter());
	}
	
	/**
	 * Test the setMultiplier method.
	 */
	public void testSetMultiplier() {
		String str = "B";
		Letter letter = new Letter(str);
		
		letter.setMultiplier();
		
		assertEquals(true, letter.isMultiplier());
	}
}
