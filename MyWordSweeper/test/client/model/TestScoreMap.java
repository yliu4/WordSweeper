package client.model;

import util.ScoreMap;
import junit.framework.TestCase;

/**
 * The <code>TestScoremap</code> class tests the <code>Scoremap</code> class.
 * 
 * @author Team Pisces
 *
 */
public class TestScoreMap extends TestCase {
	/** Test the findLetterScore method. */
	public void testFindLetterScore() {
		ScoreMap scoremap = new ScoreMap();
		
		assertEquals(1, scoremap.findLetterScore("E"));
		assertEquals(11, scoremap.findLetterScore("Qu"));
	}
}
