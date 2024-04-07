package com.test.baseclass;

import java.util.Objects;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.test.driverfactory.DriverFactory;
import com.test.driverfactory.DriverManager;
import com.test.enums.BrowserType;
import com.test.enums.EnvConfig;
import com.test.onwerinterface.EnvConfigInterface;
import com.test.utils.PropertyReader;

public class BaseClass {
	
	private static final Logger LOG = LogManager.getLogger();

	@BeforeMethod
	public void setUp() {
//		String browser = System.getProperty("browser", PropertyReader.getInstance().getPropertyValue(EnvConfig.BROWSER));
		EnvConfigInterface configInterface = ConfigFactory.create(EnvConfigInterface.class);
		String browser = System.getProperty("browser", configInterface.browser());
		DriverFactory.initDriver(BrowserType.valueOf(browser.toUpperCase()));
	}

	@AfterMethod
	public void tearDown() {
		if (Objects.nonNull(DriverManager.getDriver())) {
			DriverFactory.quit();
		}
	}
}
