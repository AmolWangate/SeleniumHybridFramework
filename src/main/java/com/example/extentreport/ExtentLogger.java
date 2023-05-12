package com.example.extentreport;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.example.constants.Environment;
import com.example.driverfactory.DriverManager;
import com.example.util.ConfigLoader;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getTest().skip(message);
	}

	public static void pass(String message, boolean isScreenshotNeeded) {
		if (ConfigLoader.getInstance().getPropertyValue(Environment.PASSSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isScreenshotNeeded) {
		if (ConfigLoader.getInstance().getPropertyValue(Environment.FAILSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		} else {
			ExtentManager.getTest().fail(message);
		}
	}

	public static void skip(String message, boolean isScreenshotNeeded) {
		if (ConfigLoader.getInstance().getPropertyValue(Environment.SKIPSCREENSHOT).equalsIgnoreCase("yes")
				&& isScreenshotNeeded) {
			ExtentManager.getTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		} else {
			ExtentManager.getTest().skip(message);
		}
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

}
