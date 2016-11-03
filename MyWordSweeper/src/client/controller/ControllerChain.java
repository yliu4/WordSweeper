package client.controller;

import xml.Message;

/**
 * The controller chain is to chain all response controllers for processing server 
 * 
 * response.
 * 
 * @author Team Pisces
 * @since 2016-10-30
 */
public abstract class ControllerChain implements IClientController {
	/** Next one in the chain. Once null is reached, done. */
	IClientController next = null;
	
	/**
	 * ControllerChain constructor
	 */
	protected ControllerChain() {
		
	}
	
	/**
	 * ControllerChain constructor for chaining next response controller
	 *
	 * @param next    the next response controller for current response controller
	 */
	protected ControllerChain(ControllerChain next) {
		this.next = next;
	}
	
	/**
	 * ControllerChain constructor for chaining next response controller
	 *
	 * @param response    response from server in xml format
	 */
	public abstract boolean process(Message response);
}
