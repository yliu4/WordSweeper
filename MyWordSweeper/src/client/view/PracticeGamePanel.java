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
	 * @param m <code>Model</code> for current application.
	 * @param application Current <code>Application</code>.
	 */
	public PracticeGamePanel(Model m, Application application) {
		this.model = m;
		this.app = application;

		setLayout(new GroupLayout(this));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height / 180;
		int width = d.width / 320;

		lblRoom = new JLabel("Practice");
		lblRoom.setFont(new Font("Arial", Font.BOLD, 6*height));
		lblRoom.setBounds(45*width, 8*height, 28*width, 5*height);
		add(lblRoom);
		
		lblCurrentWord = new JLabel("Current Word: ");
		lblCurrentWord.setFont(new Font("Arial", Font.BOLD, 3*height));
		lblCurrentWord.setBounds(5*width, 24*height, 53*width, 4*height);
		add(lblCurrentWord);

		lblScore = new JLabel("Score: \r\n");
		lblScore.setFont(new Font("Arial", Font.BOLD, 3*height));
		lblScore.setBounds(5*width, 28*height, 53*width, 4*height);
		add(lblScore);

		JLabel lblYourName = new JLabel("Your Name: Practicer");
		lblYourName.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		lblYourName.setBounds(83*width, 20*height, 30*width, 4*height);
		add(lblYourName);

		lblTotalScore = new JLabel("Total Score: 0.");
		lblTotalScore.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		lblTotalScore.setBounds(83*width, 24*height, 30*width, 4*height);
		add(lblTotalScore);

		JButton btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnReturn.setBounds(width, height, 20*width, 5*height);
		add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReturnToMenuController(model, app).process();
			}
		});

		JButton btnResetGame = new JButton("Reset Game");
		btnResetGame.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnResetGame.setBounds(96*width, 9*height, 22*width, 5*height);
		add(btnResetGame);
		btnResetGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetPracticeGameController(model, app).process();
			}
		});
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
	
   /* get the BordPanel object */
	public Object getBoardPanel() {
		return this.boardPanel;
	}
}
