package client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import client.controller.*;
import client.model.*;

import javax.swing.GroupLayout.Alignment;

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

		JLabel lblRoomm = new JLabel("Room " + game.getGameId());
		lblRoomm.setFont(new Font("Arial", Font.BOLD, height/30));
		lblRoomm.setBounds(height/4, 17*width/640, 7*height/45, width/64);
		add(lblRoomm);

		JLabel lblYourNameAnna = new JLabel("Your Name: " + game.getCurrentPlayer().getName());
		lblYourNameAnna.setFont(new Font("Tahoma", Font.PLAIN, height/60));
		lblYourNameAnna.setBounds(83*height/180, 7*width/100, height/6, 7*width/640);
		add(lblYourNameAnna);

		JLabel lblScore = new JLabel("Total Score: 0.");
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, height/60));
		lblScore.setBounds(83*height/180, 17*width/200, height/6, 7*width/640);
		add(lblScore);

		JLabel lblCurrentWord = new JLabel("Current Word: ");
		lblCurrentWord.setFont(new Font("Arial", Font.BOLD, height/60));
		lblCurrentWord.setBounds(height/36, 23*width/320, 53*height/180, 9*width/640);
		add(lblCurrentWord);

		JLabel lblScore_1 = new JLabel("Score: \r\n");
		lblScore_1.setFont(new Font("Arial", Font.BOLD, height/60));
		lblScore_1.setBounds(height/36, 7*width/80, 53*height/180, 9*width/640);
		add(lblScore_1);

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
	}
}
