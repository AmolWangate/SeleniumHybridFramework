package com.test.driverfactory;

import org.openqa.selenium.WebDriver;

import com.test.enums.BrowserType;

public interface IDriver {
	
	public WebDriver getDriverInstance(BrowserType browserType);
}
