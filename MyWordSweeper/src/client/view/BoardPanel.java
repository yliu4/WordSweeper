package client.view;

import java.awt.*;
import java.util.*;

import javax.swing.*;


import client.controller.*;
import client.model.*;

import javax.swing.GroupLayout.Alignment;

public class BoardPanel extends JPanel{
	ArrayList<Cell> cells;
	
	public BoardPanel(ArrayList<Cell> cells) {
		this.cells = cells;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;
		setBounds(height/36, 17*width/160, 13*height/45, 13*width/80);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;
		g.setFont(new Font("Tahoma", Font.BOLD, 7*height/360));
		g.drawLine(0, 0, 13*height/45, 0);
		g.drawLine(0, 13*width/320, 13*height/45, 13*width/320);
		g.drawLine(0, 13*width/160, 13*height/45, 13*width/160);
		g.drawLine(0, 39*width/320, 13*height/45, 39*width/320);
		g.drawLine(0, 13*width/80-1, 13*height/45, 13*width/80-1);
		g.drawLine(0, 0, 0, 13*width/80);
		g.drawLine(13*height/180, 0, 13*height/180, 13*width/80);
		g.drawLine(13*height/90, 0, 13*height/90, 13*width/80);
		g.drawLine(13*height/60, 0, 13*height/60, 13*width/80);
		g.drawLine(13*height/45-1, 0, 13*height/45-1, 13*width/80);
		
		String s0 = this.cells.get(0).getLetter().getCharacter();
		String s1 = this.cells.get(1).getLetter().getCharacter();
		String s2 = this.cells.get(2).getLetter().getCharacter();
		String s3 = this.cells.get(3).getLetter().getCharacter();
		String s4 = this.cells.get(4).getLetter().getCharacter();
		String s5 = this.cells.get(5).getLetter().getCharacter();
		String s6 = this.cells.get(6).getLetter().getCharacter();
		String s7 = this.cells.get(7).getLetter().getCharacter();
		String s8 = this.cells.get(8).getLetter().getCharacter();
		String s9 = this.cells.get(9).getLetter().getCharacter();
		String s10 = this.cells.get(10).getLetter().getCharacter();
		String s11 = this.cells.get(11).getLetter().getCharacter();
		String s12 = this.cells.get(12).getLetter().getCharacter();
		String s13 = this.cells.get(13).getLetter().getCharacter();
		String s14 = this.cells.get(14).getLetter().getCharacter();
		String s15 = this.cells.get(15).getLetter().getCharacter();
		
		g.drawString(s0, 11*height/360, 3*width/128);
		g.drawString(s1, 37*height/360, 3*width/128);
		g.drawString(s2, 7*height/40, 3*width/128);
		g.drawString(s3, 89*height/360, 3*width/128);
		g.drawString(s4, 11*height/360, 41*width/640);
		g.drawString(s5, 37*height/360, 41*width/640);
		g.drawString(s6, 7*height/40, 41*width/640);
		g.drawString(s7, 89*height/360, 41*width/640);
		g.drawString(s8, 11*height/360, 67*width/640);
		g.drawString(s9, 37*height/360, 67*width/640);
		g.drawString(s10, 7*height/40, 67*width/640);
		g.drawString(s11, 89*height/360, 67*width/640);
		g.drawString(s12, 11*height/360, 93*width/640);
		g.drawString(s13, 37*height/360, 93*width/640);
		g.drawString(s14, 7*height/40, 93*width/640);
		g.drawString(s15, 89*height/360, 93*width/640);
	}
}
