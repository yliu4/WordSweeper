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
		assertEquals(1, ScoreMap.findLetterScore("E"));
		assertEquals(11, ScoreMap.findLetterScore("Qu"));
	}
}
