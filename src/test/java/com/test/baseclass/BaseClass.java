package com.test.baseclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.test.driverfactory.DriverFactory;
import com.test.enums.BrowserType;
import com.test.enums.EnvConfig;
import com.test.enums.Modes;
import com.test.utils.PropertyReader;

public class BaseClass {
	
	private static final Logger LOG = LogManager.getLogger();

	@BeforeMethod
	public void setUp() {
		String browser = System.getProperty("browser", PropertyReader.getInstance().getPropertyValue(EnvConfig.BROWSER));
		String mode = System.getProperty("mode", PropertyReader.getInstance().getPropertyValue(EnvConfig.MODE));
//		EnvConfigInterface configInterface = ConfigFactory.create(EnvConfigInterface.class);
//		String browser = System.getProperty("browser", configInterface.browser());
//		String mode = System.getProperty("mode", configInterface.mode());
		DriverFactory.initDriver(BrowserType.valueOf(browser.toUpperCase()), Modes.valueOf(mode.toUpperCase()));
	}

	@AfterMethod
	public void tearDown() {
			DriverFactory.quit();
	}
}
