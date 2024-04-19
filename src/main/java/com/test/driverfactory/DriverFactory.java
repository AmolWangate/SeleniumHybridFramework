package com.test.driverfactory;

import java.time.Duration;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.test.constants.FrameworkConstants;
import com.test.enums.BrowserType;
import com.test.enums.EnvConfig;
import com.test.enums.Modes;
import com.test.utils.PropertyReader;

public final class DriverFactory {

	private static final Logger LOG = LogManager.getLogger();

	private DriverFactory() {

	}

	public static void initDriver(BrowserType browserType, Modes modes) {
		if (Objects.isNull(DriverManager.getDriver())) {
			if (modes.equals(Modes.LOCAL)) {
				LOG.info("launching local driver");
				DriverManager.setDriver(new LocalDriver().getDriverInstance(browserType));
			} else if (modes.equals(Modes.BROWSERSTACK)) {
				LOG.info("launching remote browserstack driver");
				DriverManager.setDriver(new BrowserStackDriver().getDriverInstance(browserType));
			}
			LOG.info("deleting all cookies");
			DriverManager.getDriver().manage().deleteAllCookies();
			LOG.info("maximizing browser");
			DriverManager.getDriver().manage().window().maximize();
			DriverManager.getDriver().manage().timeouts()
					.pageLoadTimeout(Duration.ofSeconds(FrameworkConstants.getPageTimeoutWait()));
			LOG.info("launching url");
			DriverManager.getDriver().get(PropertyReader.getInstance().getPropertyValue(EnvConfig.URL));
		}
	}

	public static void quit() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			LOG.info("quitting browser");
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
	}
}
