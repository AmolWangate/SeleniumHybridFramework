package com.test.customexception;

public class DriverInitalizationException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9094584474865712490L;

	public DriverInitalizationException(String message) {
		super(message);
	}

	public DriverInitalizationException(String message, Throwable cause) {
		super(message, cause);
	}
}
