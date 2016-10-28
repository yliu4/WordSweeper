package client.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import client.ServerAccess;
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
	public Model model;
	
	MenuPanel menuPanel;
	PracticeGamePanel practiceGamePanel;
	CreateGamePanel createGamePanel;
	
	PracticeGameController practiceGameController;

	ServerAccess serverAccess;
	
	/**
	 * Create the frame.
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
	
	public PracticeGamePanel getPracticeGamePanel(){
		return practiceGamePanel;
	}
	
	/**
	 * Go to practice game panel
	 */
	public void gotoPraticeGamePanel() {
		menuPanel.setVisible(false);
		remove(menuPanel);
		practiceGamePanel.setVisible(true);
		add(practiceGamePanel);
	}
	
	/**
	 * Go to main menu.
	 */
	public void gotoMainMenu() {
		System.out.println(this.getComponentCount());
		if (practiceGamePanel != null) {
			practiceGamePanel.setVisible(false);
			remove(practiceGamePanel);
		}
		if (createGamePanel != null) {
			createGamePanel.setVisible(false);
			remove(createGamePanel);
		}
		System.out.println(this.getComponentCount());
		System.out.println();
		menuPanel.setVisible(true);
		add(menuPanel);
	}
	
	/**
	 * Go to create game panel
	 */
	public void gotoCreateGamePanel() {
		menuPanel.setVisible(false);
		remove(menuPanel);
		createGamePanel = new CreateGamePanel(model, this);
		createGamePanel.setVisible(true);
		add(createGamePanel);
	}
	
	public void setPracticeGameController(PracticeGameController practiceController)
	{
		this.practiceGamePanel.setGame(practiceController.getGame());
		this.practiceGameController = practiceController;
	}
	
	/**
	 * Reset the game.
	 */
	public void resetGame()
	{
		this.practiceGameController.generateNewBoard();
	}
}
