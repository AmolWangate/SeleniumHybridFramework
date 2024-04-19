package com.test.customexception;

public class InvalidKeyException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5451337175644384392L;

	public InvalidKeyException(String message) {
		super(message);
	}

	public InvalidKeyException(String message, Throwable cause) {
		super(message, cause);
	}
}
