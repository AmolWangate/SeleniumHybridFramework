package com.test.customexception;

public class FIFOException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2602403225686177065L;

	public FIFOException(String message) {
		super(message);
	}

	public FIFOException(String message, Throwable cause) {
		super(message, cause);
	}
}
