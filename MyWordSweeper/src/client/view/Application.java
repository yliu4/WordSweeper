package client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import client.ServerAccess;
import client.controller.OpenJoinGamePanelController;
import client.controller.JoinGameController;
import client.controller.PracticeGameController;
import client.model.Model;


/**
 * <code>Application</code> is the top-level boundary class that has access to
 * 
 * all other boundary classes.
 * 
 * @author Team Pisces
 *
 */
/**
 * @author mitian
 *
 */

public class Application extends JFrame {

	/** GUI application maintains reference to Model for ease of navigation. */
	Model model;
	ServerAccess serverAccess;

	MenuPanel menuPanel;
	PracticeGamePanel practiceGamePanel;
	CreateGamePanel createGamePanel;
	JoinGamePanel joinGamePanel;
	OnlineGamePanel onlineGamePanel;
	JoinGameController joinNormalGameController;
	OpenJoinGamePanelController joinGameController;
	PracticeGameController practiceGameController;
	
	/**
	 * Create the frame for WordSweeper.
	 * 
	 * @param model
	 */
	public Application(Model model) {
		super("WordSweeper");
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;

		setBounds(100, 100, 25*width/64, 5*height/9);

		menuPanel = new MenuPanel(model, this);
		joinGamePanel = new JoinGamePanel(model, this);
		onlineGamePanel = new OnlineGamePanel(model,this);
		practiceGamePanel = new PracticeGamePanel(model, this);
		
		add(menuPanel);
	}

	/** Record the means to communicate with server. */
	public void setServerAccess(ServerAccess access) {
		this.serverAccess = access;
	}
	
	/** Get the server access object. */
	public ServerAccess getServerAccess() {
		return serverAccess;
	}
	
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}
	
	public PracticeGamePanel getPracticeGamePanel() {
		return practiceGamePanel;
	}
	
	public CreateGamePanel getCreateGamePanel() {
		return createGamePanel;
	}
	
	public JoinGamePanel getJoinGamePanel() {
		return joinGamePanel;
	}

	/** Go to practice game panel */
	public void gotoPraticeGamePanel() {
		menuPanel.setVisible(false);
		remove(menuPanel);
		practiceGamePanel.setVisible(true);
		add(practiceGamePanel);
	}
	
	
	/**
	 *  Go to Join game register panel
	 */
	public void gotoJoinGamePanel(){
		menuPanel.setVisible(false);
		remove(menuPanel);
		joinGamePanel.setVisible(true);
		add(joinGamePanel);
	}
	
	
    public void gotoOnlineGamePanel()
    {
    	joinGamePanel.setVisible(false);
		remove(joinGamePanel);
		onlineGamePanel.setVisible(true);
		add(onlineGamePanel);
    }
	
	/** Go to main menu. */
	public void gotoMainMenu() {
		if (practiceGamePanel != null) {
			practiceGamePanel.setVisible(false);
			remove(practiceGamePanel);
		}

		if (createGamePanel != null) {
			createGamePanel.setVisible(false);
			remove(createGamePanel);
		}

		if (joinGamePanel != null){
			joinGamePanel.setVisible(false);
			remove(joinGamePanel);
		}

		if (onlineGamePanel != null){
			onlineGamePanel.setVisible(false);
			remove(onlineGamePanel);
		}

		menuPanel.setVisible(true);
		add(menuPanel);
	}
	
	/** Go to create game panel */
	public void gotoCreateGamePanel() {
		menuPanel.setVisible(false);
		remove(menuPanel);
		createGamePanel = new CreateGamePanel(model, this);
		createGamePanel.setVisible(true);
		add(createGamePanel);
	}
	
	public void setJoinGameController(JoinGameController joinGameController) {
		this.onlineGamePanel.setGame(joinGameController.getGame());
		this.joinNormalGameController = joinGameController;
	}
	
	public void setPracticeGameController(PracticeGameController practiceController) {
		this.practiceGamePanel.setGame(practiceController.getGame());
		this.practiceGameController = practiceController;
	}
	
	/** Reset the game. */
	public void resetGame() {
		this.practiceGameController.generateNewBoard();
	}
	
	/**	Show a popup thats warns the player to enter a nickname. */
	public void popupEmptyNicknameWarnig() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		
		Object[] options = {"OK"};
		UIManager.put("OptionPane.buttonFont", 
				new FontUIResource(new Font("Tahoma", Font.PLAIN, height/36)));
		UIManager.put("OptionPane.messageFont", 
				new FontUIResource(new Font("Times New Roman", Font.PLAIN, 2*height/45)));
		
		JOptionPane.showOptionDialog(this.getCreateGamePanel(),
				"Please enter a nickname!", "Warning", 
				JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
	}

	/**	Show a popup thats warns the player to enter a password. */
	public void popupEmptyPasswordWarnig() {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		
		Object[] options = {"OK"};
		UIManager.put("OptionPane.buttonFont", 
				new FontUIResource(new Font("Tahoma", Font.PLAIN, height/36)));
		UIManager.put("OptionPane.messageFont", 
				new FontUIResource(new Font("Times New Roman", Font.PLAIN, 2*height/45)));
		
		JOptionPane.showOptionDialog(this.getCreateGamePanel(),
				"Please enter a password!", "Warning", 
				JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
	}
}
