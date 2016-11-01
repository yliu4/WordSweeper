package client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import client.controller.*;
import client.model.*;

/**
 * The <code>OnlineGamePanel</code> class represents an online game, which
 * 
 * contains a <code>Board</code>, and a list of <code>Player</code>s.
 * 
 * @author Team Pisces
 *
 */
public class OnlineGamePanel extends JPanel{
	Model model;
	Application app;
	Game game;
	BoardPanel boardPanel = null;
	JLabel lblRoom;
	JLabel lblYourName;
	JLabel lblTotalScore;
	
	public OnlineGamePanel (Model model, Application application) {
		this.model = model;
		this.app = application;
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 450, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGap(0, 300, Short.MAX_VALUE)
		);
		setLayout(groupLayout);

		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;
		
		lblTotalScore = new JLabel("Total Score: 0.");
		lblTotalScore.setFont(new Font("Tahoma", Font.PLAIN, height/60));
		lblTotalScore.setBounds(83*height/180, 17*width/200, height/6, 7*width/640);
		add(lblTotalScore);

		JLabel lblShift = new JLabel("Shift");
		lblShift.setHorizontalAlignment(SwingConstants.CENTER);
		lblShift.setFont(new Font("Arial", Font.PLAIN, 7*height/360));
		lblShift.setBounds(16*height/45, 27*width/320, height/15, 7*width/320);
		add(lblShift);
	}

	public void setGame(Game game) {
		this.game = game;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;

		JButton btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, height/50));
		btnReturn.setBounds(height/180, width/320, height/9, width/64);
		add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReturnToMenuController(model, app).process();
			}
		});

		if (lblRoom == null) 
			lblRoom = new JLabel("Room " + game.getGameId());
		else 
			lblRoom.setText("Room " + game.getGameId());
		lblRoom.setFont(new Font("Arial", Font.BOLD, height/30));
		lblRoom.setBounds(height/4, 17*width/640, 7*height/45, width/64);
		add(lblRoom);

		if (lblYourName == null) 
			lblYourName = new JLabel("Your Name: " + game.getCurrentPlayer().getName());
		else 
			lblYourName.setText("Your Name: " + game.getCurrentPlayer().getName());
		lblYourName.setFont(new Font("Tahoma", Font.PLAIN, height/60));
		lblYourName.setBounds(83*height/180, 7*width/100, height/6, 7*width/640);
		add(lblYourName);
		
		lblTotalScore.setText("Total Score: " + game.getCurrentPlayer().getScore());

		JLabel lblCurrentWord = new JLabel("Current Word: ");
		lblCurrentWord.setFont(new Font("Arial", Font.BOLD, height/60));
		lblCurrentWord.setBounds(height/36, 23*width/320, 53*height/180, 9*width/640);
		add(lblCurrentWord);

		JLabel lblScore = new JLabel("Score: \r\n");
		lblScore.setFont(new Font("Arial", Font.BOLD, height/60));
		lblScore.setBounds(height/36, 7*width/80, 53*height/180, 9*width/640);
		add(lblScore);

		ArrayList<Cell> cells = this.game.getBoard().getCells();
		if (this.boardPanel == null)
		{
			this.boardPanel = new BoardPanel(model, cells);
			add(boardPanel);
		}
		else
		{
			this.boardPanel.updateCells(cells);
			this.boardPanel.repaint();
		}
		
		JButton btnLeft = new JButton("\u2190"); //Left
		btnLeft.setFont(new Font("Tahoma", Font.PLAIN, 7*height/360));
		btnLeft.setBounds(16*height/45, 61*width/320, height/15, 3*width/80);
		add(btnLeft);

		JButton btnRight = new JButton("\u2192"); //Right
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 7*height/360));
		btnRight.setBounds(16*height/45, 74*width/320, height/15, 3*width/80);
		add(btnRight);

		JButton btnUp = new JButton("\u2191"); // Up
		btnUp.setFont(new Font("Tahoma", Font.PLAIN, 7*height/360));
		btnUp.setBounds(16*height/45, 35*width/320, height/15, 3*width/80);
		add(btnUp);

		JButton btnDown = new JButton("\u2193"); // Down
		btnDown.setFont(new Font("Tahoma", Font.PLAIN, 7*height/360));
		btnDown.setBounds(16*height/45, 48*width/320, height/15, 3*width/80);
		add(btnDown);
	}
}
