package client.controller;

import xml.Message;

/**
 * The empty handler is the tail in the controller chain.
 * If hitting the empty handler, it means we cannot process the type of server response.
 * 
 * @author Team Pisces
 * @since 2016-10-30
 */

public final class EmptyHandler extends ControllerChain {

	@Override
	public boolean process(Message response) {
		System.err.println("Not Handled:" + response);
		return true;
	}
}

