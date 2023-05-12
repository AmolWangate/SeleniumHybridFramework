package com.example.util;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.constants.Constants;
import com.example.driverfactory.DriverManager;

public class ExplicitWaitStrategy {
	
	public static WebElement performExplicitWait(WebElement webElement, WaitStrategy waitStrategy) {
		WebElement element = null;
		if (waitStrategy == WaitStrategy.CLICKABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitWait()))
					.until(ExpectedConditions.elementToBeClickable(webElement));
		} else if (waitStrategy == WaitStrategy.VISIBLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitWait()))
					.until(ExpectedConditions.visibilityOf(webElement));
		} else if (waitStrategy == WaitStrategy.REFRESHABLE) {
			element = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitWait()))
					.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(webElement)));
		}
		return element;
	}
}
