package client.view;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import client.ServerAccess;
import client.controller.PracticeGameController;
import client.model.Game;
import client.model.Model;


public class Application extends JFrame {

	/** GUI application maintains reference to Model for ease of navigation. */
	public Model model;
	MenuPanel menuPanel;
	PracticeGamePanel practiceGamePanel;
	PracticeGameController practiceGameController;

	ServerAccess serverAccess;
	
	/**
	 * Create the frame.
	 */
	public Application(Model model) {
		super("WordSweeper");
		this.model = model;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int height = d.height;
		int width = d.width;

		setBounds(100, 100, 25*height/36, 5*width/16);
		
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
	
	//go to practice game panel
	public void gotoPraticeGamePanel(){
		menuPanel.setVisible(false);
		remove(menuPanel);
		practiceGamePanel.setVisible(true);
		add(practiceGamePanel);
	}
	
	// go to main menu
	public void gotoMainMenu()
	{
		practiceGamePanel.setVisible(false);
		remove(practiceGamePanel);
		menuPanel.setVisible(true);
		add(menuPanel);
	}
	
	public void setPracticeGameController(PracticeGameController practiceController)
	{
		this.practiceGamePanel.setGame(practiceController.getGame());
		this.practiceGameController = practiceController;
	}
	
	// reset the game
	public void resetGame()
	{
		this.practiceGameController.resetGame();
		this.practiceGamePanel.repaintBoard();
	}
}
