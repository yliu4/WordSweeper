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
	 * @param m <code>Model</code> for current application.
	 * @param application Current <code>Application</code>.
	 */
	public CreateGamePanel(Model m, Application application) {
		this.model = m;
		this.app = application;
		
		setLayout(new GroupLayout(this));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height / 180;
		int width = d.width / 320;
		
		textFieldNickname = new JTextField();
		textFieldNickname.setFont(new Font("Times New Roman", Font.PLAIN, 5*height));
		textFieldNickname.setBounds(42*width, 27*height, 60*width, 9*height);
		add(textFieldNickname);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setEditable(false);
		textFieldPassword.setFont(new Font("Times New Roman", Font.PLAIN, 5*height));
		textFieldPassword.setBounds(42*width, 55*height, 60*width, 9*height);
		add(textFieldPassword);
		
		rdbtnPublic = new JRadioButton("Public", true);
		rdbtnPublic.setFont(new Font("Tahoma", Font.PLAIN, 4*height));
		rdbtnPublic.setBounds(42*width, 41*height, 25*width, 4*height);
		rdbtnPublic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChoosePublicController(app).process();
			}
		});
		
		rdbtnPrivate = new JRadioButton("Private", false);
		rdbtnPrivate.setFont(new Font("Tahoma", Font.PLAIN, 4*height));
		rdbtnPrivate.setBounds(42*width, 47*height, 25*width, 4*height);
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
		lblCreateNewGame.setFont(new Font("Times New Roman", Font.BOLD, 7*height));
		lblCreateNewGame.setBounds(30*width, 5*height, 60*width, 10*height);
		add(lblCreateNewGame);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 5*height));
		lblNickname.setBounds(12*width, 27*height, 32*width, 9*height);
		add(lblNickname);
		
		JLabel lblMode = new JLabel("Mode:");
		lblMode.setHorizontalAlignment(SwingConstants.CENTER);
		lblMode.setFont(new Font("Tahoma", Font.PLAIN, 5*height));
		lblMode.setBounds(12*width, 41*height, 32*width, 9*height);
		add(lblMode);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 5*height));
		lblPassword.setBounds(12*width, 55*height, 32*width, 9*height);
		add(lblPassword);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 5*height));
		btnGo.setBounds(25*width, 76*height, 30*width, 9*height);
		add(btnGo);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateGameController(model, app).process();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 5*height));
		btnCancel.setBounds(68*width, 76*height, 30*width, 9*height);
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
