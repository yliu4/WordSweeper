package client.controller;

import xml.Message;

/**
 * The IClientController is the interface for all client controller 
 * 
 * @author Team Pisces
 * @since 2016-10-30
 */
public interface IClientController {
	
	/**
	 * Return TRUE if accept the response; false otherwise.
	 * 
	 * If unable to process a valid response, then must thrown a RuntimeException 
	 */
	public boolean process(Message response);
}
