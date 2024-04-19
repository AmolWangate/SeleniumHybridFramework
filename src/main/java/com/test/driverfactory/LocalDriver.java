package com.test.driverfactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.test.enums.BrowserType;

public class LocalDriver implements IDriver {

	private static final Logger LOG = LogManager.getLogger();

	@Override
	public WebDriver getDriverInstance(BrowserType browserType) {
		LOG.info("launching " + browserType.name().toLowerCase());
		WebDriver driver;
		switch (browserType) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case EDGE:
			driver = new EdgeDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		default:
			driver = new ChromeDriver();
			break;
		}
		return driver;

	}

}
