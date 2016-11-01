package client.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import xml.Message;
import client.model.Cell;
import client.model.Game;
import client.model.Letter;
import client.model.Location;
import client.model.Model;
import client.view.Application;
import client.view.JoinGamePanel;


/**
 * This class handle the communication between the sever and client
 * The client need to check the response message from sever to justify if the 
 * the game is lock, private or public game
 * @author Tean Pisces
 *
 */
public class JoinGameController {
	Game game;
	Model model;
	Application application;
	
	JPanel popOutPanel;
	JPasswordField password;
	

	public JoinGameController(Model m, Application app) {
		this.model = m;
		this.application = app;
	}

	public void process() {		
		// send the request to join the game.
		
		//generate random number(hardcode)
		// TODO: receive response from server
		// parse message, if == SUCCESS: go to game panel
		// if == FAIL, display "locked" pop up dialog
		// if == PRIVATE, pop up password dialog
		
		Random rand = new Random(System.currentTimeMillis());
		int randomNum = rand.nextInt(3);
		System.out.println(randomNum);
		
		if (randomNum == 0)
		{
			this.game = new Game();
			generateNewBoard();
			application.setJoinGameController(this);
			application.joinNormalGamePanel();
		}
		else if (randomNum == 1) //Popup for the lock game
		{
			 String message = "The game is locked! please click \"ok\" to go back.";
			 JOptionPane.showMessageDialog(new JPanel(), message, "WordSweeper",
	         JOptionPane.ERROR_MESSAGE);
		}
		else //password Popup
		{
			this.popOutPanel = new JPanel();
			JLabel label = new JLabel("Please enter a password to join the game:");
			this.password = new JPasswordField(10);
			popOutPanel.add(label);
			popOutPanel.add(this.password);
			String[] options = new String[]{"OK", "Cancel"};
		
			int option = JOptionPane.showOptionDialog(null, this.popOutPanel, "WordSweeper",
		                     JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
		                     null, options, options[1]);
			if(option == 0) // pressing OK button
			{
			    char[] pass = this.password.getPassword();
			    System.out.println("Your password is: " + new String(pass));
			}
		}

		String gameID = application.getJoinGamePanel().getGameIDTextField().getText();
		System.out.println("### Game ID" + gameID);
		
		String xmlString = Message.requestHeader() + 
				"<joinGameRequest gameId='' name='nextOne'/></request>";
		Message m = new Message (xmlString);
		application.getServerAccess().sendRequest(m);
		
	}
	
	/**
	 * Generate a new <code>Board</code> for practice game.
	 * 
	 * The location of bonus is set to be outside the range of a <code>Board</code>
	 */
	public void generateNewBoard()
	{
		/** The location of bonus is set to be outside the range of a <code>Board</code> */
		Location nomulti = new Location(10, 10);
		this.game.setBoard(this.generatecells(), nomulti);
	}
	
	/**
	 * Randomly generate 16 <code>Cells</code> for the <code>Board</code>
	 * 
	 * @return A List of <code>Cells</code>
	 */
	public ArrayList<Cell> generatecells (){
		ArrayList<Cell> cells = new ArrayList<Cell>(16);
		String[] alp = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J","K","L","M", "N", "O", "P", "Qu","R","S","T","U","V","W","X","Y","Z"};
		int l = alp.length;
		Random r = new Random(System.currentTimeMillis());
		for (int y = 0; y <= 3; y++) {
			for (int x = 0; x <= 3; x++) {
				String s = alp[r.nextInt(l)];
				Letter le = new Letter(s);
				Location lo = new Location(x, y);
				Cell ce = new Cell(lo, le);
				cells.add(ce);
			}
		}
		return cells;
	}
	
	public Game getGame()
	{
		return this.game;
	}
}

