package com.example.baseclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.example.constants.Environment;
import com.example.customannotation.TestAnnotation;
import com.example.driverfactory.Driver;
import com.example.extentreport.ExtentManager;
import com.example.util.ConfigLoader;

public class BaseClass{

	private static final Logger LOG = LogManager.getLogger();
	
	@BeforeMethod
	public void setUp() {
		String browserName = ConfigLoader.getInstance().getPropertyValue(Environment.BROWSER);
		LOG.info("Browser Name: "+browserName);
		Driver.initializeDriver(Environment.valueOf(browserName.toUpperCase()));
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		extentDetails(result);
		Driver.quitBrowser();
	}
	
	public static void extentDetails(ITestResult result) {
		ExtentManager.getTest().assignAuthor(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestAnnotation.class).user());
		ExtentManager.getTest().assignCategory(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestAnnotation.class).category());
		ExtentManager.getTest().assignDevice(result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestAnnotation.class).deviceName());
		
	}

}
