package client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import client.controller.ChoosePrivateController;
import client.controller.ChoosePublicController;
import client.controller.CreateGameController;
import client.controller.ReturnToMenuController;
import client.model.Model;

/**
 * The <code>CreateGamePanel</code> class gathers the information needed for creating 
 * 
 * a new game, and provides the function to create a game. 
 * 
 * @author Team Pisces
 *
 */
public class CreateGamePanel extends JPanel {
	/** Reference <code>Model</code> for easy navigation. */
	Model model;

	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/**	<code>JTextField</code> for the nickname. */
	JTextField textFieldNickname;
	
	/**	<code>JPasswordField</code> for the password. */
	JPasswordField textFieldPassword;

	/** A <code>ButtonGroup</code> to manage the radiobuttons as a whole. */
	ButtonGroup modeBtnGroup;
	
	/**	<code>JRadioButton</code> indicating it's a public game. */
	JRadioButton rdbtnPublic;
	
	/**	<code>JRadioButton</code> indicating it's a private game. */
	JRadioButton rdbtnPrivate;
	
	/**
	 * Create the panel for collecting information for create game request.
	 * 
	 * @param model <code>Model</code> for current application.
	 * @param application Current <code>Application</code>.
	 */
	public CreateGamePanel(Model model, Application application) {
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
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setEditable(false);
		textFieldPassword.setFont(new Font("Times New Roman", Font.PLAIN, height/36));
		textFieldPassword.setBounds(21*width/160, 11*height/36, 3*width/16, height/20);
		add(textFieldPassword);
		
		rdbtnPublic = new JRadioButton("Public", true);
		rdbtnPublic.setFont(new Font("Tahoma", Font.PLAIN, height/45));
		rdbtnPublic.setBounds(21*width/160, 41*height/180, 5*width/64, height/45);
		rdbtnPublic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChoosePublicController(app).process();
			}
		});
		
		rdbtnPrivate = new JRadioButton("Private", false);
		rdbtnPrivate.setFont(new Font("Tahoma", Font.PLAIN, height/45));
		rdbtnPrivate.setBounds(21*width/160, 47*height/180, 5*width/64, height/45);
		rdbtnPrivate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChoosePrivateController(app).process();
			}
		});
		
		modeBtnGroup = new ButtonGroup();
		modeBtnGroup.add(rdbtnPublic);
		modeBtnGroup.add(rdbtnPrivate);
		add(rdbtnPublic);
		add(rdbtnPrivate);

		JLabel lblCreateNewGame = new JLabel("Create New Game");
		lblCreateNewGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewGame.setFont(new Font("Times New Roman", Font.BOLD, 7*height/180));
		lblCreateNewGame.setBounds(3*width/32, height/36, 3*width/16, height/18);
		add(lblCreateNewGame);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, height/36));
		lblNickname.setBounds(3*width/80, 3*height/20, width/10, height/20);
		add(lblNickname);
		
		JLabel lblMode = new JLabel("Mode:");
		lblMode.setHorizontalAlignment(SwingConstants.CENTER);
		lblMode.setFont(new Font("Tahoma", Font.PLAIN, height/36));
		lblMode.setBounds(3*width/80, 41*height/180, width/10, height/20);
		add(lblMode);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, height/36));
		lblPassword.setBounds(3*width/80, 11*height/36, width/10, height/20);
		add(lblPassword);
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
		
		JButton btnNewButton = new JButton("GO!");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, height/36));
		btnNewButton.setBounds(5*width/64, 19*height/45, 3*width/32, height/20);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateGameController(model, app).process();
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

	/**
	 * Get the <code>JTextField</code> recording the nickname.
	 * 
	 * @return A <code>JTextField</code> recording the nickname.
	 */
	public JTextField getTextFieldNickname() {
		return textFieldNickname;
	}

	/**
	 * Get the <code>JPasswordField</code> recording the password.
	 * 
	 * @return A <code>JPasswordField</code> recording the password.
	 */
	public JPasswordField getTextFieldPassword() {
		return textFieldPassword;
	}

	/**
	 * Get the <code>JRadioButton</code> representing the private mode.
	 * 
	 * @return A <code>JRadioButton</code> representing the private mode.
	 */
	public JRadioButton getRdbtnPrivate() {
		return rdbtnPrivate;
	}
}
