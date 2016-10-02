package client.model;

import java.util.*;

public class Word {
	ArrayList<Cell> cells = null;
	String word = null;
	
	public Word(ArrayList<Cell> cells) {
		this.cells = cells;
		StringBuffer sb = new StringBuffer();
		for (Cell cell: cells) {
			sb.append(cell.getLetter().getCharacter());
		}
		this.word = sb.toString();
	}
}
