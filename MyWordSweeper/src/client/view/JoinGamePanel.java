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

import client.controller.JoinGameController;
import client.controller.JoinPrivateGameController;
import client.controller.PracticeGameController;
import client.model.Game;
import client.model.Model;


public class JoinGamePanel extends JPanel {
	 //Game game;
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

//		final JTextField nameTextField = new JTextField(30);
//		nameTextField.setFont(new Font("Times New Roman", Font.PLAIN, height/60));
//		nameTextField.setBounds(83*height/360, 3*width/40, 7*height/30, 7*width/180);
//		add(nameTextField);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Times New Roman", Font.PLAIN, height/60));
		nameTextField.setBounds(83*height/360, 3*width/40, 7*height/30, 7*width/180);
		add(nameTextField);
		nameTextField.setColumns(10);
	
		JLabel lbGameID = new JLabel("GameID:");
		lbGameID.setHorizontalAlignment(SwingConstants.CENTER);
		lbGameID.setFont(new Font("Tahoma", Font.PLAIN, height/50));
		lbGameID.setBounds(20*height/360, 11*width/80, 7*height/30, 7*width/180);
		add(lbGameID);
		
		gameIDTextField = new JTextField();
		gameIDTextField.setToolTipText("Enter a gameID to join a specfic game, or leave it empty to randomly join a public game.");
		gameIDTextField.setFont(new Font("Times New Roman", Font.PLAIN, height/60));
		gameIDTextField.setBounds(83*height/360, 11*width/80, 7*height/30, 7*width/180);
		add(gameIDTextField);
		gameIDTextField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("GO");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, height/60));
		btnNewButton.setBounds(40*height/360, 8*width/35, 7*height/70, 7*width/250);
		add(btnNewButton);
		JoinPrivateGameController go = new JoinPrivateGameController(model, application);
		btnNewButton.addMouseListener(go);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.BOLD, height/50));
		cancelButton.setBounds(130*height/360, 8*width/35, 7*height/70, 7*width/250);
		add(cancelButton);
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

//	public void setGame(Game game) {
//		// TODO Auto-generated method stub
//		this.game = game;
//	}
}
