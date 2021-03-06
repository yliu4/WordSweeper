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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import xml.Message;

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
* 
*/

public class JoinGamePanel extends JPanel {
	/** Serializable key. */
	private static final long serialVersionUID = 373430537076665396L;

	/** Reference <code>Model</code> for easy navigation. */
	Model model;

	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/**	<code>JTextField</code> for the nickname. */
	JTextField textFieldNickname;
	
	/**	<code>JTextField</code> for the gameID. */
	JTextField textFieldGameID;

	/**
	 * Create the panel for collecting information for join game request.
	 * 
	 * @param m <code>Model</code> for current application.
	 * @param application Current <code>Application</code>.
	 */
	public JoinGamePanel(Model m, Application application) {
		this.model = m;
		this.app = application;
		
		setLayout(new GroupLayout(this));
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height / 180;
		int width = d.width / 320;
		
		JLabel lblJoinNewGame = new JLabel("Join Game");
		lblJoinNewGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoinNewGame.setFont(new Font("Times New Roman", Font.BOLD, 7*height));
		lblJoinNewGame.setBounds(40*width, 10*height, 80*width, 15*height);
		add(lblJoinNewGame);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 5*height));
		lblNickname.setBounds(25*width, 35*height, 40*width, 10*height);
		add(lblNickname);

		textFieldNickname = new JTextField();
		textFieldNickname.setFont(new Font("Times New Roman", Font.PLAIN, 5*height));
		textFieldNickname.setBounds(70*width, 35*height, 60*width, 10*height);
		add(textFieldNickname);

		JLabel lbGameID = new JLabel("GameID:");
		lbGameID.setHorizontalAlignment(SwingConstants.CENTER);
		lbGameID.setFont(new Font("Tahoma", Font.PLAIN, 5*height));
		lbGameID.setBounds(25*width, 75*height, 40*width, 10*height);
		add(lbGameID);	
		
		textFieldGameID = new JTextField();
		textFieldGameID.setFont(new Font("Times New Roman", Font.PLAIN, 5*height));
		textFieldGameID.setBounds(70*width, 75*height, 60*width, 10*height);
		add(textFieldGameID);
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 5*height));
		btnGo.setBounds(40*width, 100*height, 30*width, 10*height);
		add(btnGo);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinGameController(model, app).process();
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 5*height));
		btnCancel.setBounds(90*width, 100*height, 30*width, 10*height);
		add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ReturnToMenuController(model, app).process();
			}
		});
	}
	
    /** 
     * Popup that shows the join failure reason,
     * 
     * if the game is private, it asks for a password.
	 * 
	 * @return The password entered.
	 */
	public String popupNeedPassword(String reason) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		JPanel panel = new JPanel();
		JLabel label = new JLabel(reason + ". Enter a password when needed:");
		JPasswordField pass = new JPasswordField(10);

		label.setFont(new Font("Times New Roman", Font.PLAIN, 1*height/45));
		panel.add(label);
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 1*height/45));
		panel.add(pass);
		
		String[] options = new String[]{"OK", "Cancel"};
		int option = JOptionPane.showOptionDialog(this, panel, "Warning"
				, JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE
				, null, options, options[1]);
		String password = "";
		
		if(option == 0) {// Pressing OK button
		    password = new String(pass.getPassword());
		}
		
		return password;
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
}