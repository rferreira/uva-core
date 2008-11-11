package com.uvasoftware.core.exception;

/**
 * Custom exception that represents and error while converting the raw XML into java objects. It usually represents a malformed XML or a medium error
 * @author Rafael Ferreira <raf@uvasoftware.com>
 *
 */
public class ProtocolParseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8154938754993601596L;

	public ProtocolParseException(String msg) {
		super(msg);
	}
}
