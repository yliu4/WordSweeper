package client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.controller.JoinGameController;
import client.controller.ReturnToMenuController;
import client.model.Game;
import client.model.Model;

/**
* The <code>JoinGamePanel</code> class represents the view that enables
*  
* the player to enter his/her nickname and gmeID to join a game.
* 
* @author Team Pisces
*/
public class JoinGamePanel extends JPanel {
	/** Refrence <code>Model</code> for easy navigation. */
	Model model;

	/** Refrence <code>Application</code> for easy navigation. */
	Application app;
	
	/** Current game. */
	Game game; // Do we need this?
	
	/**	<code>JTextField</code> for the nickname. */
	JTextField textFieldNickname;
	
	/**	<code>JTextField</code> for the gameID. */
	JTextField textFieldGameID;

	/**
	 * Create the panel for collecting information for join game request.
	 * 
	 * @param model <code>Model</code> for current application.
	 * @param application Current <code>Application</code>.
	 */
	public JoinGamePanel(Model model, Application application) {
		this.model = model;
		this.app = application;
		
		setLayout(new GroupLayout(this));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;

		textFieldNickname = new JTextField();
		textFieldNickname.setFont(new Font("Times New Roman", Font.PLAIN, height/36));
		textFieldNickname.setBounds(21*width/160, 3*height/20, 3*width/16, height/20);
		add(textFieldNickname);
		
		textFieldGameID = new JTextField();
//		textFieldGameID.setToolTipText("Enter a gameID to join a specfic game, " +
//				"or leave it empty to randomly join a public game.");
		textFieldGameID.setFont(new Font("Times New Roman", Font.PLAIN, height/36));
		textFieldGameID.setBounds(21*width/160, 11*height/36, 3*width/16, height/20);
		add(textFieldGameID);
	}
	
	// Do we need this?
	public void setGame(Game game) {
		this.game = game;
	}

	/**
	 * Get the <code>JTextField</code> recording the nickname.
	 * 
	 * @return A <code>JTextField</code> recording the nickname.
	 */
	public JTextField getTextFieldNickname() {
		return textFieldNickname;
	}

	/**
	 * Get the <code>JTextField</code> recording the gameID.
	 * 
	 * @return A <code>JTextField</code> recording the gameID.
	 */
	public JTextField getTextFieldGameID() {
		return textFieldGameID;
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
		
		JLabel lblJoinNewGame = new JLabel("Join Game");
		lblJoinNewGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoinNewGame.setFont(new Font("Times New Roman", Font.BOLD, 7*height/180));
		lblJoinNewGame.setBounds(3*width/32, height/36, 3*width/16, height/18);
		add(lblJoinNewGame);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, height/36));
		lblNickname.setBounds(3*width/80, 3*height/20, width/10, height/20);
		add(lblNickname);

		JLabel lbGameID = new JLabel("GameID:");
		lbGameID.setHorizontalAlignment(SwingConstants.CENTER);
		lbGameID.setFont(new Font("Tahoma", Font.PLAIN, height/36));
		lbGameID.setBounds(3*width/80, 11*height/36, width/10, height/20);
		add(lbGameID);	
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Tahoma", Font.BOLD, height/36));
		btnGo.setBounds(5*width/64, 19*height/45, 3*width/32, height/20);
		add(btnGo);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinGameController(model, app).process();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, height/36));
		btnCancel.setBounds(17*width/80, 19*height/45, 3*width/32, height/20);
		add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReturnToMenuController(model, app).process();
			}
		});
	}
}
