package com.example.util;

import org.openqa.selenium.WebElement;

import com.example.extentreport.ExtentLogger;

public class DriverUtilities {

	public void click(WebElement element, WaitStrategy waitStrategy, String locatorName) {
		ExplicitWaitStrategy.performExplicitWait(element, waitStrategy).click();
		ExtentLogger.pass("Clicked on " + locatorName, true);
	}

	public void sendKeys(WebElement element, WaitStrategy waitStrategy, String textToBeEntered, String locatorName) {
		WebElement textElement = ExplicitWaitStrategy.performExplicitWait(element, waitStrategy);
		textElement.clear();
		textElement.sendKeys(textToBeEntered);
		ExtentLogger.pass("Entered " + textToBeEntered + " in " + locatorName, true);
	}

}
