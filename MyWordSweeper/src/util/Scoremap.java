package util;

import java.util.HashMap;

public class Scoremap {
	HashMap<String, Integer> SMap = new HashMap<String, Integer>();

	public Scoremap() {
		SMap.put("E", 1);
		SMap.put("T", 1);
		SMap.put("A", 2);
		SMap.put("O", 2);
		SMap.put("I", 2);
		SMap.put("N", 2);
		SMap.put("S", 2);
		SMap.put("H", 2);
		SMap.put("R", 2);
		SMap.put("D", 3);
		SMap.put("L", 3);
		SMap.put("C", 3);
		SMap.put("U", 3);
		SMap.put("M", 3);
		SMap.put("W", 3);
		SMap.put("F", 4);
		SMap.put("G", 4);
		SMap.put("Y", 4);
		SMap.put("P", 4);
		SMap.put("B", 4);
		SMap.put("V", 5);
		SMap.put("K", 5);
		SMap.put("J", 7);
		SMap.put("X", 7);
		SMap.put("Qu", 11);
		SMap.put("Z", 8);
	} 
	
	public int findLetterScore (String c){
		return SMap.get(c);
	}
	
}
