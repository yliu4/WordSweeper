package client.view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
public class Application extends JFrame {
	/** GUI application maintains reference to Model for ease of navigation. */
	Model model;

	/** <code>JPanel</code> for main menu. */
	MenuPanel menuPanel;

	/** <code>JPanel</code> for practice game view. */
	PracticeGamePanel practiceGamePanel;

	/** <code>JPanel</code> for create game window. */
	CreateGamePanel createGamePanel;

	/** <code>JPanel</code> for join game window. */
	JoinGamePanel joinGamePanel;

	/** <code>JPanel</code> for online game view. */
	OnlineGamePanel onlineGamePanel;

	/** Controller for joining a game. */
	JoinGameController joinGameController;

	/** Controller for opening a join game window. */
	OpenJoinGamePanelController openJoinGamePanelController;

	/** Controller for creating a practice game. */
	PracticeGameController practiceGameController;
	
	/** Access server. */
	ServerAccess serverAccess;
	
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

		setBounds(width/4, height/8, width/2, 3*height/4);

		menuPanel = new MenuPanel(model, this);
		joinGamePanel = new JoinGamePanel(model, this);
		onlineGamePanel = new OnlineGamePanel(model,this);
//		practiceGamePanel = new PracticeGamePanel(model, this);
		
		add(menuPanel);
	}

	/** 
	 * Record the means to communicate with server. 
	 * 
	 * @param access Access to a server.
	 */
	public void setServerAccess(ServerAccess access) {
		this.serverAccess = access;
	}
	
	/** 
	 * Get the server access object. 
	 * 
	 * @return Current <code>ServerAccess</code> object.
	 */
	public ServerAccess getServerAccess() {
		return serverAccess;
	}

	/** 
	 * Get the <code>MenuPanel</code> object.
	 * 
	 * @return Current <code>MenuPanel</code> object.
	 */
	public MenuPanel getMenuPanel() {
		return menuPanel;
	}

	/** 
	 * Get the <code>PracticeGamePanel</code> object. 
	 * 
	 * @return Current <code>PracticeGamePanel</code> object.
	 */
	public PracticeGamePanel getPracticeGamePanel() {
		return practiceGamePanel;
	}

	/** 
	 * Get the <code>CreateGamePanel</code> object. 
	 * 
	 * @return Current <code>CreateGamePanel</code> object.
	 */
	public CreateGamePanel getCreateGamePanel() {
		return createGamePanel;
	}

	/** 
	 * Get the <code>JoinGamePanel</code> object. 
	 * 
	 * @return Current <code>JoinGamePanel</code> object. 
	 */
	public JoinGamePanel getJoinGamePanel() {
		return joinGamePanel;
	}

	/** 
	 * Get the <code>OnlineGamePanel</code> object. 
	 * 
	 *  Current <code>OnlineGamePanel</code> object. 
	 */
	public OnlineGamePanel getOnlineGamePanel()
	{
		return onlineGamePanel;
	}

	/** Go to practice game panel. */
	public void gotoPraticeGamePanel() {
		menuPanel.setVisible(false);
		remove(menuPanel);

		practiceGamePanel = new PracticeGamePanel(model, this);
		practiceGamePanel.setVisible(true);
		add(practiceGamePanel);
	}
	
	
	/** Go to join game panel. */
	public void gotoJoinGamePanel(){
		menuPanel.setVisible(false);
		remove(menuPanel);
		
		joinGamePanel.setVisible(true);
		add(joinGamePanel);
	}
	
	/** Go to online game panel. */
    public void gotoOnlineGamePanel()
    {
		if (createGamePanel != null) {
			createGamePanel.setVisible(false);
			remove(createGamePanel);
		}

		if (joinGamePanel != null) {
	    	joinGamePanel.setVisible(false);
			remove(joinGamePanel);
		}
		
		onlineGamePanel.setVisible(true);
		add(onlineGamePanel);
		onlineGamePanel.repaint();
		onlineGamePanel.revalidate();
    }
	
	/** Go to main menu. */
	public void gotoMainMenu() {
		if (practiceGamePanel != null) {
			practiceGamePanel.setVisible(false);
			remove(practiceGamePanel);
			practiceGamePanel = null;
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
	
	/** Go to the create game panel. */
	public void gotoCreateGamePanel() {
		menuPanel.setVisible(false);
		remove(menuPanel);
		createGamePanel = new CreateGamePanel(model, this);
		createGamePanel.setVisible(true);
		add(createGamePanel);
	}

	// Not needed?
	public void setJoinGameController(JoinGameController joinGameController) {
//		this.onlineGamePanel.setGame(joinGameController.getGame());
		this.joinGameController = joinGameController;
	}

	/**
	 * Set the <code>PracticeGameController</code> for the <code>PracticeGamePanel</code>.
	 * 
	 * @param practiceController Controller for creating a practice game.
	 */
	public void setPracticeGameController(PracticeGameController practiceController) {
//		this.practiceGamePanel.setGame(model.getGame());
		this.practiceGameController = practiceController;
	}
	
	/**  get the practiceController */
	public PracticeGameController getPracticeGameController()
	{
		return this.practiceGameController;
	}
	
	/** Reset the the board in practice game. */
	public void resetGame() {
		this.practiceGameController.generateNewBoard();
	}

	/**	
	 * Show a popup thats warns the player.
	 * 
	 * @param warningMsg The warning message.
	 */
	public void popupWarnig(String warningMsg) {
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		Object[] options = {"OK"};
		
		UIManager.put("OptionPane.buttonFont", 
				new FontUIResource(new Font("Tahoma", Font.PLAIN, height/36)));
		UIManager.put("OptionPane.messageFont", 
				new FontUIResource(new Font("Times New Roman", Font.PLAIN, 2*height/45)));
		
		JOptionPane.showOptionDialog(this,
				warningMsg, "Warning", 
				JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE,
				null, options, options[0]);
	}
}
