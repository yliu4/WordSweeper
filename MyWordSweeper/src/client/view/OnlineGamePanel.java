package client.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

import client.controller.*;
import client.controller.RepositionBoardController.ShiftDirection;
import client.model.*;

/**
 * The <code>OnlineGamePanel</code> class represents an online game, which
 * 
 * contains a <code>Board</code>, and a list of <code>Player</code>s.
 * 
 * @author Team Pisces
 *
 */
public class OnlineGamePanel extends JPanel {
	/** Reference <code>Model</code> for easy navigation. */
	Model model;

	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Current game. */
	Game game;
	
	/** <code>JPanel</code> for the <code>Board</code> in this <code>Game</code>.*/
	BoardPanel boardPanel = null;

	/** <code>JLabel</code> for displaying the current selected Word. */
	JLabel lblCurrentWord = null;
	
	/** <code>JLabel</code> for displaying the score of the current selected word. */
	JLabel lblScore;
	
	/** <code>JLabel</code> for displaying the gameID. */
	JLabel lblRoom;
	
	/** <code>JLabel</code> for displaying the current player's name. */
	JLabel lblYourName;
	
	/** <code>JLabel</code> for displaying the total score of the current player. */
	JLabel lblTotalScore;
	
	/**
	 * Create the panel for online game view.
	 * 
	 * @param m <code>Model</code> for current application.
	 * @param application Current <code>Application</code>.
	 */
	public OnlineGamePanel(Model m, Application application) {
		this.model = m;
		this.app = application;

		setLayout(new GroupLayout(this));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height / 180;
		int width = d.width / 320;
		
		lblCurrentWord = new JLabel("Current Word: ");
		lblCurrentWord.setFont(new Font("Arial", Font.BOLD, 3*height));
		lblCurrentWord.setBounds(5*width, 24*height, 70*width, 4*height);
		add(lblCurrentWord);
		
		lblScore = new JLabel("Score: " + "\r\n");
		lblScore.setFont(new Font("Arial", Font.BOLD, 3*height));
		lblScore.setBounds(5*width, 28*height, 53*width, 4*height);
		add(lblScore);
		
		lblRoom = new JLabel("Room ");
		lblRoom.setFont(new Font("Arial", Font.BOLD, 6*height));
		lblRoom.setBounds(45*width, 8*height, 28*width, 5*height);
		add(lblRoom);

		lblYourName = new JLabel("Your Name: ");
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
				new ExitGameController(model, app).process();
			}
		});
		
		JLabel lblShift = new JLabel("Shift");
		lblShift.setHorizontalAlignment(SwingConstants.CENTER);
		lblShift.setFont(new Font("Arial", Font.PLAIN, 3*height));
		lblShift.setBounds(64*width, 26*height, 12*width, 8*height);
		add(lblShift);

		JButton btnUp = new JButton("\u2191"); // Up
		btnUp.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnUp.setBounds(64*width, 35*height, 12*width, 12*height);
		add(btnUp);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RepositionBoardController(model, app).process(ShiftDirection.Up);
			}
		});
		
		JButton btnDown = new JButton("\u2193"); // Down
		btnDown.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnDown.setBounds(64*width, 48*height, 12*width, 12*height);
		add(btnDown);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RepositionBoardController(model, app).process(ShiftDirection.Down);
			}
		});
		
		JButton btnLeft = new JButton("\u2190"); //Left
		btnLeft.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnLeft.setBounds(64*width, 61*height, 12*width, 12*height);
		add(btnLeft);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RepositionBoardController(model, app).process(ShiftDirection.Left);
			}
		});

		JButton btnRight = new JButton("\u2192"); //Right
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnRight.setBounds(64*width, 74*height, 12*width, 12*height);
		add(btnRight);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RepositionBoardController(model, app).process(ShiftDirection.Right);
			}
		});

		JButton btnResetGame = new JButton("Reset Game");
		btnResetGame.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnResetGame.setBounds(96*width, 9*height, 22*width, 5*height);
		add(btnResetGame);
		btnResetGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetGameController(model, app).process();
			}
		});
	}


	/**
	 * Get the current <code>Game> object.
	 * 
	 * @return A <code>Game</code> object for the current game.
	 */

	public Game getGame() {
		return this.game;
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

		lblRoom.setText("Room " + game.getGameId());
		lblYourName.setText("Your Name: " + game.getCurrentPlayer().getName());
		lblScore.setText("Score: " + "\r\n");
		//lblScore.setText("Score: "+ boardPanel.getScore());

		ArrayList<Cell> cells = this.game.getBoard().getCells();
		
		if (this.boardPanel == null) {
			this.boardPanel = new BoardPanel(model, app, cells);
			add(boardPanel);
		}
		else {
			this.boardPanel.updateCells(cells);
			this.boardPanel.repaint();
		}

		lblCurrentWord.setText("Current Word: "+boardPanel.getCurrentWord());
		lblScore.setText("Score: " + boardPanel.getScoreForSelectedWord()) ;
	}

	/**
	 * Get the JLabel that displays the word.
	 * 
	 * @return The JLabel that displays the word.
	 */
	public JLabel getLblCurrentWord() {
		return lblCurrentWord;
	}
	
	/**
	 * Get the JLabel that displays the score of word.
	 * 
	 * @return The JLabel that displays the score of word.
	 */
	public JLabel getLblWordScore(){
		return lblScore;
	}
}