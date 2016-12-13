package client.controller;

import xml.Message;
import client.model.Model;
import client.view.Application;

public class JoinGameResponseController extends ControllerChain {
	/** Reference <code>Application</code> for easy navigation. */
	Application app;
	
	/** Reference <code>Model</code> for easy navigation. */
	Model model;
	
	/** Set <code>boolean</code> to skip pop up window in tests */
	boolean skipWarningDialog = false;
	
	/** Store <code>String</code> to indicate the join failed reason for testing */
	String failReason = "";
	
	/**
	 * JoinGameResponseController constructor
	 *
	 * @param app  	 initialize the reference of application
	 * @param model  initialize the reference of model
	 */
	public JoinGameResponseController(Model model, Application app) {
		this.app = app;
		this.model = model;
	}
	
	/**
	 * process join game responses from server if fail when join a specific game
	 *
	 * @param Message  join game response message from server in xml format
	 */
	public boolean process(Message response) {
		String type = response.contents.getFirstChild().getLocalName();
		if (!type.equals ("joinGameResponse")) {
			return next.process(response);
		}
		
		String reason = response.reason();

		if (reason.contains("lock"))
		{
			this.failReason = "locked";
		} else if (reason.contains("does not exist")) {
			this.failReason = "does not exist";
		}
		
		//Show warning message and get password.
		String password = "";
		if (!this.skipWarningDialog)
		{	
			password = app.getJoinGamePanel().popupNeedPassword(reason);
		}
	    
	    if (password.length() > 0){
	    	String nickname = app.getJoinGamePanel().getTextFieldNickname().getText();
			String gameId = app.getJoinGamePanel().getTextFieldGameID().getText();
			String joinGameRequest = "<joinGameRequest gameId='" + gameId
					+ "' name='" + nickname + "' password='" + password
					+ "'/></request>";
			String xmlString = Message.requestHeader() + joinGameRequest;
			Message m = new Message (xmlString);

			app.getServerAccess().sendRequest(m);
	    }
		
		return true;
	}
	
	/**
	 * Get failed reason string to verify in tests
	 * @return The join failed reason
	 */
	public String getFailReason()
	{
		return this.failReason;
	}

	/**
	 * Set to skip warning dialog for automated tests
	 */
	public void setSkipWarningDialog()
	{
		this.skipWarningDialog = true;
	}
}