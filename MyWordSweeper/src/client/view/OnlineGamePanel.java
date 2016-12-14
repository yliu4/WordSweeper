package client.view;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;

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
	/** Serializable key. */
	private static final long serialVersionUID = -389068527822635030L;

	/** Reference <code>Model</code> for easy navigation. */
	Model model;

	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** <code>JPanel</code> for the <code>Board</code> in this <code>Game</code>.*/
	BoardPanel boardPanel = null;

	/** <code>JLabel</code> for displaying the current selected Word. */
	JLabel lblCurrentWord = null;
	
	/** <code>JLabel</code> for displaying the score of the current selected word. */
	JLabel lblScore;
	
	/** <code>JLabel</code> for displaying the gameID. */
	JLabel lblGameId;
	
	/** <code>JLabel</code> for displaying the current player's name. */
	JLabel lblYourName;
	
	/** <code>JLabel</code> for displaying the total score of the current player. */
	JLabel lblTotalScore;

	/** <code>JLabel</code> for displaying rank of the current player. */
	JLabel lblRank;
	
	/** <code>JButton</code> for providing reset game feature to managing user. */
	JButton btnResetGame;
	
	/** <code>JButton</code> for providing lock game feature to managing user. */
	JButton btnLockGame;

	/** The rowdata for the jtable that displays all players' information. */
	Vector<Vector<String>> rowData = new Vector<Vector<String>>();
	
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
		
		JLabel lblRoom = new JLabel("Room");
		lblRoom.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoom.setFont(new Font("Arial", Font.BOLD, 6*height));
		lblRoom.setBounds(60*width, height, 30*width, 10*height);
		add(lblRoom);

		lblGameId = new JLabel();
		lblGameId.setFont(new Font("Arial", Font.BOLD, 6*height));
		lblGameId.setBounds(40*width, 15*height, 70*width, 10*height);
		add(lblGameId);
		lblGameId.addMouseListener(new CopyGameIdController(model, app));
		
		lblCurrentWord = new JLabel("Current Word: ");
		lblCurrentWord.setFont(new Font("Arial", Font.BOLD, 3*height));
		lblCurrentWord.setBounds(15*width, 30*height, 70*width, 10*height);
		add(lblCurrentWord);
		
		lblScore = new JLabel("Score: 0");
		lblScore.setFont(new Font("Arial", Font.BOLD, 3*height));
		lblScore.setBounds(15*width, 40*height, 70*width, 10*height);
		add(lblScore);

		lblYourName = new JLabel("Your Name: ");
		lblYourName.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		lblYourName.setBounds(100*width, 30*height, 70*width, 10*height);
		add(lblYourName);
		
		lblTotalScore = new JLabel("Total Score: 0.");
		lblTotalScore.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		lblTotalScore.setBounds(100*width, 40*height, 70*width, 10*height);
		add(lblTotalScore);

		lblRank = new JLabel("You are at.");
		lblRank.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		lblRank.setBounds(100*width, 50*height, 70*width, 10*height);
		add(lblRank);

		JButton btnReturn = new JButton("Return");
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnReturn.setBounds(width, height, 30*width, 10*height);
		add(btnReturn);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExitGameController(model, app).process();
			}
		});
		
		JLabel lblShift = new JLabel("Shift");
		lblShift.setHorizontalAlignment(SwingConstants.CENTER);
		lblShift.setFont(new Font("Arial", Font.PLAIN, 3*height));
		lblShift.setBounds(75*width, 36*height, 15*width, 10*height);
		add(lblShift);

		JButton btnUp = new JButton("\u2191"); // Up
		btnUp.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnUp.setBounds(75*width, 48*height, 15*width, 15*height);
		add(btnUp);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RepositionBoardController(model, app).process(ShiftDirection.Up);
			}
		});
		
		JButton btnDown = new JButton("\u2193"); // Down
		btnDown.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnDown.setBounds(75*width, 65*height, 15*width, 15*height);
		add(btnDown);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RepositionBoardController(model, app).process(ShiftDirection.Down);
			}
		});
		
		JButton btnLeft = new JButton("\u2190"); //Left
		btnLeft.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnLeft.setBounds(75*width, 82*height, 15*width, 15*height);
		add(btnLeft);
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RepositionBoardController(model, app).process(ShiftDirection.Left);
			}
		});

		JButton btnRight = new JButton("\u2192"); //Right
		btnRight.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnRight.setBounds(75*width, 99*height, 15*width, 15*height);
		add(btnRight);
		btnRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RepositionBoardController(model, app).process(ShiftDirection.Right);
			}
		});

		btnResetGame = new JButton("Reset Game");
		btnResetGame.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnResetGame.setBounds(120*width, 15*height, 30*width, 10*height);
		add(btnResetGame);
		btnResetGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResetGameController(model, app).process();
			}
		});
		
		btnLockGame = new JButton("Lock Game");
		btnLockGame.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		btnLockGame.setBounds(120*width, height, 30*width, 10*height);
		add(btnLockGame);
		btnLockGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LockGameController(model, app).process();
			}
		});
		
		Vector<String> col = new Vector<String>();
		
		col.add("Rank"); col.add("Nickname"); col.add("Score");
		
		JTable table = new JTable();
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 3*height));
		table.setPreferredScrollableViewportSize(new Dimension(35*width, 50*height));
		table.setRowHeight(4*height);
		
		DefaultTableModel t = new DefaultTableModel(rowData, col) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table.setModel(t);
		
		JScrollPane scrollPane = new JScrollPane(table);
		
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(105*width, 60*height, 35*width, 50*height);
		table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 2*height));
		add(scrollPane, BorderLayout.CENTER);
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

		lblGameId.setText(model.getGame().getGameId());
		lblYourName.setText("Your Name: " + model.getGame().getCurrentPlayer().getName());
		lblTotalScore.setText("Total Score: " + 
				model.getGame().getCurrentPlayer().getScore());
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
	public JLabel getLblScore(){
		return lblScore;
	}
	
	/**
	 * Get the reset game button.
	 * 
	 * @return The reset game button.
	 */
	public JButton getBtnResetGame() {
		return btnResetGame;
	}

	/**
	 * Get the lock game button.
	 * 
	 * @return The lock game button.
	 */
	public JButton getBtnLockGame() {
		return btnLockGame;
	}

	/**
	 * Get the rowData vector for JTable.
	 * 
	 * @return The rowData vector.
	 */
	public Vector<Vector<String>> getRowData() {
		return rowData;
	}

	/**
	 * Get the JLabel displaying the rank.
	 * 
	 * @return The JLabel displaying the rank.
	 */
	public JLabel getLblRank() {
		return lblRank;
	}
}