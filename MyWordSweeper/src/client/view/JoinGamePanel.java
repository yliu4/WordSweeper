package client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import client.controller.OpenJoinGamePanelController;
import client.controller.JoinGameController;
import client.controller.PracticeGameController;
import client.controller.ReturnToMenuController;
import client.model.Game;
import client.model.Model;

/*
* The <code>CreateGamePanel</code> class represents the view that enables 
* the player to enter his/her nickname and gmeID to join a game 
*/

public class JoinGamePanel extends JPanel {
	Game game;
	Model model;
	Application application;
	private JTextField nameTextField;
	private JTextField gameIDTextField;

	public JoinGamePanel(Model model, Application application) {
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
		 //this.repaint();
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;
		
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Times New Roman", Font.PLAIN, height/60));
		nameTextField.setBounds(83*height/360, 3*width/40, 7*height/30, 7*width/180);
		add(nameTextField);
		
		gameIDTextField = new JTextField();
		gameIDTextField.setToolTipText("Enter a gameID to join a specfic game, or leave it empty to randomly join a public game.");
		gameIDTextField.setFont(new Font("Times New Roman", Font.PLAIN, height/60));
		gameIDTextField.setBounds(83*height/360, 11*width/80, 7*height/30, 7*width/180);
		add(gameIDTextField);
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
		
		setName("WordSweeper");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1039, 817);
		
		JLabel lblJoinNewGame = new JLabel("Join Game");
		lblJoinNewGame.setFont(new Font("Times New Roman", Font.BOLD, height/20));
		lblJoinNewGame.setBounds(60*height/360, width/64, 29*height/90, 7*width/160);
		add(lblJoinNewGame);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, height/50));
		lblNickname.setBounds(20*height/360, 3*width/40, 7*height/30, 7*width/160);
		add(lblNickname);

		JLabel lbGameID = new JLabel("GameID:");
		lbGameID.setHorizontalAlignment(SwingConstants.CENTER);
		lbGameID.setFont(new Font("Tahoma", Font.PLAIN, height/50));
		lbGameID.setBounds(20*height/360, 11*width/80, 7*height/30, 7*width/180);
		add(lbGameID);		
		
		JButton btnGoButton = new JButton("GO!");
		btnGoButton.setFont(new Font("Tahoma", Font.BOLD, height/60));
		btnGoButton.setBounds(40*height/360, 8*width/35, 7*height/70, 7*width/250);
		add(btnGoButton);
		btnGoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinGameController(model, application).process();
			}
		});
						
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, height/50));
		cancelButton.setBounds(130*height/360, 8*width/35, 7*height/70, 7*width/250);
		add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReturnToMenuController(model, application).process();
			}
		});
	}

	
	
	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}
	// get the name of player
	public JTextField getNameTextField() {
		return nameTextField;
	}
	//get the the input gameID from player
	public JTextField getGameIDTextField()
	{
		return gameIDTextField;
	}
}
