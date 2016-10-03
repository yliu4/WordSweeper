package client.view;

import java.awt.*;
import java.awt.event.MouseMotionListener;
import java.util.*;

import javax.swing.*;

import client.controller.*;
import client.model.*;

import javax.swing.GroupLayout.Alignment;

public class BoardPanel extends JPanel{
	ArrayList<Cell> cells;
	Model model;
	
	public BoardPanel(Model model, ArrayList<Cell> cells) {
		this.cells = cells;
		this.model = model;
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;
		setBounds(height/36, 17*width/160, 13*height/45, 13*width/80);
		
		BoardController control = new BoardController(model, this);
		this.addMouseListener(control);
		this.addMouseMotionListener(control);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 13*height/45, 13*width/80-1);
		g.setColor(Color.black);
		g.setFont(new Font("Tahoma", Font.BOLD, 7*height/360));
		g.drawLine(0, 0, 13*height/45, 0);
		g.drawLine(0, 13*width/320, 13*height/45, 13*width/320);
		g.drawLine(0, 26*width/320, 13*height/45, 13*width/160);
		g.drawLine(0, 39*width/320, 13*height/45, 39*width/320);
		g.drawLine(0, 52*width/320-1, 13*height/45, 13*width/80-1);
		g.drawLine(0, 0, 0, 13*width/80);
		g.drawLine(13*height/180, 0, 13*height/180, 13*width/80);
		g.drawLine(26*height/180, 0, 13*height/90, 13*width/80);
		g.drawLine(39*height/180, 0, 13*height/60, 13*width/80);
		g.drawLine(52*height/180-1, 0, 13*height/45-1, 13*width/80);
		
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
		
		this.cells.get(0).setCoordinateLocation(0, 0, 13*height/180, 13*width/320);
		this.cells.get(1).setCoordinateLocation(13*height/180, 0, 13*height/180, 13*width/320);
		this.cells.get(2).setCoordinateLocation(26*height/180, 0, 13*height/180, 13*width/320);
		this.cells.get(3).setCoordinateLocation(39*height/180, 0, 13*height/180, 13*width/320);
		this.cells.get(4).setCoordinateLocation(0, 13*width/320, 13*height/180, 13*width/320);
		this.cells.get(5).setCoordinateLocation(13*height/180, 13*width/320, 13*height/180, 13*width/320);
		this.cells.get(6).setCoordinateLocation(26*height/180, 13*width/320, 13*height/180, 13*width/320);
		this.cells.get(7).setCoordinateLocation(39*height/180, 13*width/320, 13*height/180, 13*width/320);
		this.cells.get(8).setCoordinateLocation(0, 26*width/320, 13*height/180, 13*width/320);
		this.cells.get(9).setCoordinateLocation(13*height/180, 26*width/320, 13*height/180, 13*width/320);
		this.cells.get(10).setCoordinateLocation(26*height/180, 26*width/320, 13*height/180, 13*width/320);
		this.cells.get(11).setCoordinateLocation(39*height/180, 26*width/320, 13*height/180, 13*width/320);
		this.cells.get(12).setCoordinateLocation(0, 39*width/320, 13*height/180, 13*width/320);
		this.cells.get(13).setCoordinateLocation(13*height/180, 39*width/320, 13*height/180, 13*width/320);
		this.cells.get(14).setCoordinateLocation(26*height/180, 39*width/320, 13*height/180, 13*width/320);
		this.cells.get(15).setCoordinateLocation(39*height/180, 39*width/320, 13*height/180, 13*width/320);

		Location location = this.model.getFilledBoard();
		if(location != null) {
			
			int x = location.CoordinateX;
			int y = location.CoordinateY;
			int cellWidth = location.width;
			int cellHeight = location.height;
			/*
			int start = -1;
			for(int i = 0; i < 16; i++) {
				Location cellLoc = this.cells.get(i).getLocation();
				if(x >= cellLoc.CoordinateX && x <= cellLoc.CoordinateX+cellLoc.width &&
				   y >= cellLoc.CoordinateY && y <= cellLoc.CoordinateY+cellLoc.height) {
					g.setColor(Color.pink);
					g.fillRect(cellLoc.CoordinateX, cellLoc.CoordinateY, cellLoc.width, cellLoc.height);
					start = i;
					System.out.println(start);
				}
				
				if(x+cellWidth >= cellLoc.CoordinateX && x <= cellLoc.CoordinateX+cellLoc.width &&
				   y+cellHeight >= cellLoc.CoordinateY && y <= cellLoc.CoordinateY+cellLoc.height){
					g.setColor(Color.pink);
					g.fillRect(cellLoc.CoordinateX, cellLoc.CoordinateY, cellLoc.width, cellLoc.height);
				}
			}*/
			g.setColor(Color.pink);
			g.drawLine(x, y, x+cellWidth, y+cellHeight);
			
			
			g.setColor(Color.black);
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
}
