package com.test.driverfactory;

import org.openqa.selenium.WebDriver;

public final class DriverManager {

	private DriverManager() {

	}

	static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	static synchronized void setDriver(WebDriver driver) {
		tlDriver.set(driver);
	}

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	public synchronized void unload() {
		tlDriver.remove();
	}
}
