package com.test.driverfactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.test.customexception.DriverInitalizationException;
import com.test.enums.BrowserType;

public class BrowserStackDriver implements IDriver {

	@Override
	public WebDriver getDriverInstance(BrowserType browserType) {
		WebDriver driver = null;
		MutableCapabilities capabilities = new MutableCapabilities();
		HashMap<String, Object> bstackOptions = new HashMap<>();
		capabilities.setCapability("browserName", "Chrome");
		bstackOptions.put("os", "Windows");
		bstackOptions.put("userName", "jondoe_YaEDIQ");
		bstackOptions.put("accessKey", "zFESey2RQRXDzCrFWpTo");
		bstackOptions.put("osVersion", "11");
		bstackOptions.put("browserVersion", "latest");
		bstackOptions.put("consoleLogs", "info");
		bstackOptions.put("seleniumVersion", "4.18.1");
		capabilities.setCapability("bstack:options", bstackOptions);
		try {
			driver = new RemoteWebDriver(new URL("http://hub.browserstack.com/wd/hub/"), capabilities);
		} catch (MalformedURLException e) {
			throw new DriverInitalizationException("Driver could not be launched: " + e.getMessage(), e.getCause());
		}

		return driver;
	}

}
