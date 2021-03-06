package client.controller;

import xml.Message;

/**
 * The empty handler is the tail in the controller chain. If hitting the empty 
 * 
 * handler, it means we cannot process the type of server response.
 * 
 * @author Team Pisces
 * @since 2016-10-30
 */
public final class EmptyHandler extends ControllerChain {

	/**
	 * If all response controllers cannot handle the response, just pop up an error message.
	 *
	 * @param Message Response message from server in xml format.
	 */
	@Override
	public boolean process(Message response) {
		System.err.println("Not Handled:" + response);
		
		return true;
	}
}

