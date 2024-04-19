package com.test.extentreport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.test.driverfactory.DriverManager;

public final class CaptureScreenshot {

	private CaptureScreenshot() {

	}

	private static String getScreenshot() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

	public static Media getBase64Screenshot() {
		return MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot()).build();
	}
}
