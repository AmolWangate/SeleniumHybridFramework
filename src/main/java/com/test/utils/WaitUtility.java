package com.test.utils;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.test.driverfactory.DriverManager;
import com.test.enums.WaitType;

public final class WaitUtility {

	private WaitUtility() {

	}

	public static WebElement performExplicitWait(WebElement element, WaitType waitStrategy) {
		WebElement webElement = null;
		switch (waitStrategy) {
		case CLICKABLE:
			webElement = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(0))
					.until(ExpectedConditions.elementToBeClickable(element));
			break;
		case VISIBLE:
			webElement = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(0))
					.until(ExpectedConditions.visibilityOf(element));
			break;
		case NONE:
			webElement = element;
			break;
		default:
			break;
		}
		return webElement;
	}

}
