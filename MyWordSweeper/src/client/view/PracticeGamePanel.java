package client.view;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.*;

import javax.swing.*;

import client.controller.*;
import client.model.*;

import javax.swing.GroupLayout.Alignment;

public class PracticeGamePanel extends JPanel{
	Model model;
	Application application;
	Game game;
	BoardPanel boardPanel = null;
	
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

		JButton btnReturnButton = new JButton("Return");
		btnReturnButton.setFont(new Font("Tahoma", Font.PLAIN, height/50));
		btnReturnButton.setBounds(height/180, width/320, height/9, width/64);
		add(btnReturnButton);
		
		ReturnMenuPanelController returnMenuController 
			= new ReturnMenuPanelController(model, application);
		btnReturnButton.addMouseListener(returnMenuController);

		JButton btnResetGame = new JButton("Reset Game");
		btnResetGame.setFont(new Font("Tahoma", Font.PLAIN, height/50));
		btnResetGame.setBounds(23*height/45, 17*width/640, 3*height/20, width/64);
		add(btnResetGame);
		ResetGameInPracticeController resetGameController 
			= new ResetGameInPracticeController(model, application);
        btnResetGame.addMouseListener(resetGameController);
        
		JLabel lblRoomm = new JLabel("Practice");
		lblRoomm.setFont(new Font("Arial", Font.BOLD, height/30));
		lblRoomm.setBounds(height/4, 17*width/640, 7*height/45, width/64);
		add(lblRoomm);

		JLabel lblYourNameAnna = new JLabel("Your Name: Practicer");
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
			this.boardPanel = new BoardPanel(cells);
			add(boardPanel);
		}
		else
		{
			this.boardPanel.updateCells(cells);
			this.boardPanel.repaint();
		}
	}
}
