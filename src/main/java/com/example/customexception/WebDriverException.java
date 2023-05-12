package com.example.customexception;

public class WebDriverException extends FrameworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3699877977752261819L;

	public WebDriverException(String message) {
		super(message);
	}

	public WebDriverException(String message, Throwable cause) {
		super(message, cause);
	}

}
