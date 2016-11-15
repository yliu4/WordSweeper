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
	/** Reference <code>Model</code> for easy navigation. */
	Model model;

	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Current game. */
	Game game; // Do we need this?
	
	/**	<code>JTextField</code> for the nickname. */
	JTextField textFieldNickname;
	
	/**	<code>JTextField</code> for the gameID. */
	JTextField textFieldGameID;
	
	JPanel popupPanel;
	JPasswordField password;
	
	int screenHeight;
	int screenWidth;

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
		screenHeight = d.height;
		screenWidth = d.width;
		
		int height = d.height / 180;
		int width = d.width / 320;

		textFieldNickname = new JTextField();
		textFieldNickname.setFont(new Font("Times New Roman", Font.PLAIN, 5*height));
		textFieldNickname.setBounds(42*width, 27*height, 60*width, 9*height);
		add(textFieldNickname);
		
		textFieldGameID = new JTextField();
		textFieldGameID.setFont(new Font("Times New Roman", Font.PLAIN, 5*height));
		textFieldGameID.setBounds(42*width, 55*height, 60*width, 9*height);
		add(textFieldGameID);
		
		JLabel lblJoinNewGame = new JLabel("Join Game");
		lblJoinNewGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblJoinNewGame.setFont(new Font("Times New Roman", Font.BOLD, 7*height));
		lblJoinNewGame.setBounds(30*width, 5*height, 60*width, 10*height);
		add(lblJoinNewGame);
		
		JLabel lblNickname = new JLabel("Nickname:");
		lblNickname.setHorizontalAlignment(SwingConstants.CENTER);
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 5*height));
		lblNickname.setBounds(12*width, 27*height, 32*width, 9*height);
		add(lblNickname);

		JLabel lbGameID = new JLabel("GameID:");
		lbGameID.setHorizontalAlignment(SwingConstants.CENTER);
		lbGameID.setFont(new Font("Tahoma", Font.PLAIN, 5*height));
		lbGameID.setBounds(12*width, 55*height, 32*width, 9*height);
		add(lbGameID);	
		
		JButton btnGo = new JButton("GO!");
		btnGo.setFont(new Font("Tahoma", Font.BOLD, 5*height));
		btnGo.setBounds(25*width, 76*height, 30*width, 9*height);
		add(btnGo);
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JoinGameController(model, app).process();
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
	
	/** missing nick name warning function */
    public void PopUpNeedNickname()
    {
		Object[] options = {"OK"};
		UIManager.put("OptionPane.buttonFont", 
				new FontUIResource(new Font("Tahoma", Font.PLAIN, screenHeight/36)));
		UIManager.put("OptionPane.messageFont", 
				new FontUIResource(new Font("Times New Roman", Font.PLAIN, 2*screenHeight/45)));
		
		JOptionPane.showOptionDialog(app.getJoinGamePanel(),
				"Please enter a nickname!", "Warning", 
				JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
    }
    
    /** missing gameID popup */
    public void PopUpNeedGameID()
    {
		// If server supports randomly assign game, the following will be removed
		Object[] options = {"OK"};
		UIManager.put("OptionPane.buttonFont", 
				new FontUIResource(new Font("Tahoma", Font.PLAIN, screenHeight/36)));
		UIManager.put("OptionPane.messageFont", 
				new FontUIResource(new Font("Times New Roman", Font.PLAIN, 2*screenHeight/45)));
		
		JOptionPane.showOptionDialog(app.getJoinGamePanel(),
				"Please enter a gameID!", "Warning", 
				JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
    }
	
    /** missing password popup */
	public void PopUpPassword()
	{
		// password Popup
		this.popupPanel = new JPanel();
		JLabel label = new JLabel("Please enter a password to join the game:");
		this.password = new JPasswordField(10);
		popupPanel.add(label);
		popupPanel.add(this.password);
		String[] options = new String[]{"OK", "Cancel"};
	
		int option = JOptionPane.showOptionDialog(app.getJoinGamePanel(), this.popupPanel,
				"Warning", JOptionPane.NO_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[1]);
		if(option == 0) {
			// pressing OK button
			char[] pass = this.password.getPassword();
			System.out.println("Your password is: " + new String(pass));
		}
	}
	
	/** game lock popup */
	public void PopUpLocked()
	{
		// Popup for the lock game
		UIManager.put("OptionPane.buttonFont", 
				new FontUIResource(new Font("Tahoma", Font.PLAIN, screenHeight/36)));
		UIManager.put("OptionPane.messageFont", 
				new FontUIResource(new Font("Times New Roman", Font.PLAIN, 2*screenHeight/45)));
		String message = "The game is locked! please click \"ok\" to go back.";
		JOptionPane.showMessageDialog(app.getJoinGamePanel(), message, "Error!",
        JOptionPane.ERROR_MESSAGE);
	}
	
	/** join game successful pop up */
	public void PopUpJoinSuccess()
	{
		// Popup for the lock game
		UIManager.put("OptionPane.buttonFont", 
				new FontUIResource(new Font("Tahoma", Font.PLAIN, screenHeight/36)));
		UIManager.put("OptionPane.messageFont", 
				new FontUIResource(new Font("Times New Roman", Font.PLAIN, 2*screenHeight/45)));
		String message = "You successfully joined the game (TODO show game board view)";
		JOptionPane.showMessageDialog(app.getJoinGamePanel(), message, "OK!",
        JOptionPane.OK_OPTION);
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