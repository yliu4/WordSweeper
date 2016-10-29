package client.model;

import util.Scoremap;
import junit.framework.TestCase;

public class TestScoremap extends TestCase {

	public void testfindLetterScore() {
		Scoremap s = new Scoremap();
		assertEquals(1, s.findLetterScore("E"));
		assertEquals(11, s.findLetterScore("Qu"));
	}
}
