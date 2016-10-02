package client.view;

import java.awt.*;
import java.util.*;

import javax.swing.*;


import client.controller.*;
import client.model.*;
import javax.swing.GroupLayout.Alignment;

public class PracticeGamePanel extends JPanel{
	Model model;
	Application application;
	Game game;
	
	public PracticeGamePanel (Model model, Application application) {
		this.model = model;
		this.application = application;
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
//		this.repaint();
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

		JButton btnNewButton = new JButton("Return");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, height/50));
		btnNewButton.setBounds(height/180, width/320, height/9, width/64);
		add(btnNewButton);

		JButton btnResetGame = new JButton("Reset Game");
		btnResetGame.setFont(new Font("Tahoma", Font.PLAIN, height/50));
		btnResetGame.setBounds(409, 14, 3*height/20, width/64);
		add(btnResetGame);

		JLabel lblRoomm = new JLabel("Practice Game");
		lblRoomm.setFont(new Font("Arial", Font.BOLD, height/30));
		lblRoomm.setBounds(173, 11, 180, 20);
		add(lblRoomm);

		JLabel lblYourNameAnna = new JLabel("Your Name: Practice Player");
		lblYourNameAnna.setFont(new Font("Tahoma", Font.PLAIN, height/60));
		lblYourNameAnna.setBounds(368, 89, 171, 14);
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
		BoardPanel myBoard = new BoardPanel(cells);
		add(myBoard);
	}
}
