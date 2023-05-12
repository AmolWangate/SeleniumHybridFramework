package com.example.driverfactory;

import java.time.Duration;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.example.constants.Constants;
import com.example.constants.Environment;
import com.example.customexception.WebDriverException;

public final class Driver {
	
	private static final Logger LOG = LogManager.getLogger();

	private Driver() {

	}

	public static void initializeDriver(Environment browserName) {
		try {
			switch (browserName) {
			case CHROME:
				if (Objects.isNull(DriverManager.getDriver())) {
					DriverManager.setDriver(new ChromeDriver());
					LOG.info("Chrome is launched");
				}
				break;
			case FIREFOX:
				if (Objects.isNull(DriverManager.getDriver())) {
					DriverManager.setDriver(new FirefoxDriver());
					LOG.info("Firefox is launched");
				}
				break;
			case EDGE:
				if (Objects.isNull(DriverManager.getDriver())) {
					DriverManager.setDriver(new EdgeDriver());
					LOG.info("Edge is launched");
				}
				break;
			case SAFARI:
				if (Objects.isNull(DriverManager.getDriver())) {
					DriverManager.setDriver(new SafariDriver());
					LOG.info("Safari is launched");
				}
				break;
			default:
				if (Objects.isNull(DriverManager.getDriver())) {
					DriverManager.setDriver(new ChromeDriver());
					LOG.info("Default Chrome is launched");
				}
				break;
			}
			DriverManager.getDriver().get("https://www.google.com");
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().deleteAllCookies();
			DriverManager.getDriver().manage().timeouts()
					.pageLoadTimeout(Duration.ofSeconds(Constants.getPageLoadingTimeout()));
		} catch (Exception e) {
			throw new WebDriverException("Driver Exception has occured");
		}
	}

	public static void quitBrowser() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}

}
