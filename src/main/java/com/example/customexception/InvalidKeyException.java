package com.example.customexception;

public class InvalidKeyException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6932846945917356282L;

	public InvalidKeyException(String message) {
		super(message);
	}

	public InvalidKeyException(String message, Throwable cause) {
		super(message, cause);
	}

}
