package com.test.utils;

import org.openqa.selenium.WebElement;

import com.test.enums.WaitType;
import com.test.extentreport.ExtentLogger;

public final class DriverUtilites {

	private DriverUtilites() {

	}

	public static void click(WebElement element, WaitType waitType, String elementName) {
		WaitUtility.performExplicitWait(element, waitType).click();
		ExtentLogger.pass(elementName + " is clicked", true);
	}

	public static void sendKeys(WebElement element, WaitType waitType, String textToBeEntered, String elementName) {
		WebElement element2 = WaitUtility.performExplicitWait(element, waitType);
		element2.clear();
		element2.sendKeys(textToBeEntered);
		ExtentLogger.pass("Entered " + textToBeEntered + " in " + elementName, true);
	}

	public static String getText(WebElement element, WaitType waitType, String elementName) {
		String text = WaitUtility.performExplicitWait(element, waitType).getText();
		ExtentLogger.pass("Text value for " + elementName + " is " + text, true);
		return text;
	}

	public static boolean isDisplayed(WebElement element, WaitType waitType, String elementName) {
		boolean isTrue = WaitUtility.performExplicitWait(element, waitType).isDisplayed();
		ExtentLogger.pass("is " + elementName + " displayed : " + isTrue, true);
		return isTrue;
	}
}
