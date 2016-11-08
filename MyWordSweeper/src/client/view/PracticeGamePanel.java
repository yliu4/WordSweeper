package client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import client.controller.*;
import client.model.*;

/**
 * The <code>PracticeGamePanel</code> class represents the practice game, which
 * 
 * contains a <code>Board</code>.
 * 
 * @author Team Pisces
 *
 */
public class PracticeGamePanel extends JPanel{
	/** Reference <code>Model</code> for easy navigation. */
	Model model;

	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Current game. */
	Game game;
	
	/** <code>JPanel</code> for the <code>Board</code> in this <code>Game</code>.*/
	BoardPanel boardPanel = null;
	
	/** <code>JLabel</code> for displaying the gameID. */
	JLabel lblRoom;
	
	/** <code>JLabel</code> for displaying the total score of the current player. */
	JLabel lblTotalScore;
	
	/** <code>JLabel</code> for displaying the current selected word. */
	JLabel lblCurrentWord;
	
	/** <code>JLabel</code> for displaying the score of the current selected word. */
	JLabel lblScore;

	/**
	 * Create the panel for practice game view.
	 * 
	 * @param model <code>Model</code> for current application.
	 * @param application Current <code>Application</code>.
	 */
	public PracticeGamePanel(Model model, Application application) {
		this.model = model;
		this.app = application;

		setLayout(new GroupLayout(this));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;

		lblRoom = new JLabel("Practice");
		lblRoom.setFont(new Font("Arial", Font.BOLD, height/30));
		lblRoom.setBounds(height/4, 17*width/640, 7*height/45, width/64);
		add(lblRoom);
		
		lblCurrentWord = new JLabel("Current Word: ");
		lblCurrentWord.setFont(new Font("Arial", Font.BOLD, height/60));
		lblCurrentWord.setBounds(height/36, 23*width/320, 53*height/180, 9*width/640);
		add(lblCurrentWord);

		JLabel lblYourName = new JLabel("Your Name: Practicer");
		lblYourName.setFont(new Font("Tahoma", Font.PLAIN, height/60));
		lblYourName.setBounds(83*height/180, 7*width/100, height/6, 7*width/640);
		add(lblYourName);

		lblTotalScore = new JLabel("Total Score: 0.");
		lblTotalScore.setFont(new Font("Tahoma", Font.PLAIN, height/60));
		lblTotalScore.setBounds(83*height/180, 17*width/200, height/6, 7*width/640);
		add(lblTotalScore);

		lblCurrentWord = new JLabel("Current Word: ");
		lblCurrentWord.setFont(new Font("Arial", Font.BOLD, height/60));
		lblCurrentWord.setBounds(height/36, 23*width/320, 53*height/180, 9*width/640);
		add(lblCurrentWord);

		lblScore = new JLabel("Score: \r\n");
		lblScore.setFont(new Font("Arial", Font.BOLD, height/60));
		lblScore.setBounds(height/36, 7*width/80, 53*height/180, 9*width/640);
		add(lblScore);
	}

	/**
	 * Set the current game.
	 * 
	 * @param game A <code>Game</code> object for the current game.
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
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

		JButton btnResetGame = new JButton("Reset Game");
		btnResetGame.setFont(new Font("Tahoma", Font.PLAIN, height/50));
		btnResetGame.setBounds(23*height/45, 17*width/640, 3*height/20, width/64);
		add(btnResetGame);
		btnResetGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetPracticeGameController(model, app).process();
			}
		});

		ArrayList<Cell> cells = this.game.getBoard().getCells();
		if (this.boardPanel == null)
		{
			this.boardPanel = new BoardPanel(model, app, cells);
			add(boardPanel);
		}
		else
		{
			this.boardPanel.updateCells(cells);
			this.boardPanel.repaint();
		}
	}
}
