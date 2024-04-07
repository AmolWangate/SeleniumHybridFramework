package com.test.customexception;

public class FNFException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2831350880627314607L;

	public FNFException(String message) {
		super(message);
	}

	public FNFException(String message, Throwable cause) {
		super(message, cause);
	}

}
