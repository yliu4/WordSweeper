package util;

import java.util.HashMap;

/**
 * This class finds score for each letter.
 * 
 * @author Team Pisces
 *
 */
public class ScoreMap {
	/** A hashmap that maps a score to each letter. */
	static HashMap<String, Integer> ScoreMap = new HashMap<String, Integer>();

	/**
	 * Load the letter-score pair into the hashmap.
	 */
	public static void loadScore() {
		ScoreMap.put("E", 1);
		ScoreMap.put("T", 1);
		ScoreMap.put("A", 2);
		ScoreMap.put("O", 2);
		ScoreMap.put("I", 2);
		ScoreMap.put("N", 2);
		ScoreMap.put("S", 2);
		ScoreMap.put("H", 2);
		ScoreMap.put("R", 2);
		ScoreMap.put("D", 3);
		ScoreMap.put("L", 3);
		ScoreMap.put("C", 3);
		ScoreMap.put("U", 3);
		ScoreMap.put("M", 3);
		ScoreMap.put("W", 3);
		ScoreMap.put("F", 4);
		ScoreMap.put("G", 4);
		ScoreMap.put("Y", 4);
		ScoreMap.put("P", 4);
		ScoreMap.put("B", 4);
		ScoreMap.put("V", 5);
		ScoreMap.put("K", 5);
		ScoreMap.put("J", 7);
		ScoreMap.put("X", 7);
		ScoreMap.put("Qu", 11);
		ScoreMap.put("Z", 8);
	} 
	
	/**
	 * Find the score of a letter.
	 * 
	 * @param c The letter.
	 * @return The score of that letter.
	 */
	public static int findLetterScore(String c){
		loadScore();
		return ScoreMap.get(c);
	}
	
}
