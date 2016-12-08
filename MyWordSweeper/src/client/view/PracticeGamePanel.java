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
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoom.setFont(new Font("Arial", Font.BOLD, 6*height));
		lblRoom.setBounds(60*width, 10*height, 40*width, 10*height);
		add(lblRoom);
		
		lblCurrentWord = new JLabel("Current Word: ");
		lblCurrentWord.setFont(new Font("Arial", Font.BOLD, 3*height));
		lblCurrentWord.setBounds(15*width, 30*height, 70*width, 10*height);
		add(lblCurrentWord);

		lblScore = new JLabel("Score: \r\n");
		lblScore.setFont(new Font("Arial", Font.BOLD, 3*height));
		lblScore.setBounds(15*width, 40*height, 70*width, 10*height);
		add(lblScore);

		JLabel lblYourName = new JLabel("Your Name: PracticerPracticerPracticer");
		lblYourName.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		lblYourName.setBounds(100*width, 30*height, 70*width, 10*height);
		add(lblYourName);

		lblTotalScore = new JLabel("Total Score: 0.");
		lblTotalScore.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		lblTotalScore.setBounds(100*width, 40*height, 70*width, 10*height);
		add(lblTotalScore);

		JButton btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnReturn.setBounds(width, height, 30*width, 10*height);
		add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReturnToMenuController(model, app).process();
			}
		});

		JButton btnResetGame = new JButton("Reset Game");
		btnResetGame.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnResetGame.setBounds(120*width, 15*height, 30*width, 10*height);
		add(btnResetGame);
		btnResetGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetPracticeGameController(model, app).process();
			}
		});
	}

	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		ArrayList<Cell> cells = model.getGame().getBoard().getCells();
		if (this.boardPanel == null) {
			this.boardPanel = new BoardPanel(model, app, cells);
			add(boardPanel);
		} else {
			this.boardPanel.setCells(cells);
			this.boardPanel.repaint();
		}
		
		lblTotalScore.setText("Total Score: " + 
				model.getGame().getCurrentPlayer().getScore());
	}
	
	/**
	 * Get the BoardPanel object.
	 * 
	 * @return The BoardPanel.
	 */
	public BoardPanel getBoardPanel() {
		return this.boardPanel;
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
	public JLabel getLblScore()
	{
		return lblScore;
	}

	/**
	 * Get the JLabel that displays the total score.
	 * 
	 * @return The JLabel that displays total score.
	 */
	public JLabel getLblTotalScore() {
		return lblTotalScore;
	}
}
