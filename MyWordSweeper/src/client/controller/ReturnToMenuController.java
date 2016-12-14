package client.controller;

import client.model.Model;
import client.view.Application;

/**
 * Controller to handle clicking the return button in practice mode
 * 
 * to return to main menu.
 * 
 * @author Team Pisces
 *
 */
public class ReturnToMenuController {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;

	/**
	 * Construct the ReturnToMenuController.
	 * 
	 * @param model The model.
	 * @param application The application.
	 */
	public ReturnToMenuController(Model model, Application application) {
		this.model = model;
		this.app = application;
	}

	/**
	 * Open the MainMenuPanel.
	 */
	public void process() {
		//clear the text field when go back to main menu
		app.getJoinGamePanel().getTextFieldNickname().setText("");
		app.getJoinGamePanel().getTextFieldGameID().setText("");
		
		if (app.getCreateGamePanel() != null) {
			app.getCreateGamePanel().getTextFieldNickname().setText("");
			app.getCreateGamePanel().getTextFieldPassword().setText("");
		}
		
		app.gotoMainMenu();
	}
}
