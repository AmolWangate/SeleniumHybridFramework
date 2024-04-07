package com.test.driverfactory;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.test.constants.FrameworkConstants;
import com.test.enums.BrowserType;
import com.test.enums.EnvConfig;
import com.test.utils.PropertyReader;

public final class DriverFactory {

	private static final Logger LOG = LogManager.getLogger();

	private DriverFactory() {

	}

	public static void initDriver(BrowserType browserType) {
		switch (browserType) {
		case CHROME:
			LOG.info("launching chrome browser");
			DriverManager.setDriver(new ChromeDriver());
			break;
		case FIREFOX:
			LOG.info("launching firefox browser");
			DriverManager.setDriver(new FirefoxDriver());
			break;
		case EDGE:
			LOG.info("launching edge browser");
			DriverManager.setDriver(new EdgeDriver());
			break;
		default:
			LOG.info("launching default chrome browser");
			DriverManager.setDriver(new ChromeDriver());
			break;
		}
		LOG.info("Deleting all cookies");
		DriverManager.getDriver().manage().deleteAllCookies();
		LOG.info("Maximizing browser");
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts()
				.pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.getPageTimeoutWait()));
		LOG.info("launching url");
		DriverManager.getDriver().get(PropertyReader.getInstance().getPropertyValue(EnvConfig.URL));
	}

	public static void quit() {
		LOG.info("quitting browser");
		DriverManager.getDriver().quit();
	}
}
