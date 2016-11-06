package client.model;

import util.Scoremap;
import junit.framework.TestCase;

/**
 * The <code>TestScoremap</code> class tests the <code>Scoremap</code> class.
 * 
 * @author Team Pisces
 *
 */
public class TestScoremap extends TestCase {
	/** Test the findLetterScore method. */
	public void testFindLetterScore() {
		Scoremap scoremap = new Scoremap();
		
		assertEquals(1, scoremap.findLetterScore("E"));
		assertEquals(11, scoremap.findLetterScore("Qu"));
	}
}
