package com.test.customexception;

public class InvalidWaitTypeException extends FrameworkException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5451337175644384392L;

	public InvalidWaitTypeException(String message) {
		super(message);
	}

	public InvalidWaitTypeException(String message, Throwable cause) {
		super(message, cause);
	}

}
