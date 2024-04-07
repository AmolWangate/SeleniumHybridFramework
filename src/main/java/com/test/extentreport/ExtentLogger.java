package com.test.extentreport;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.test.driverfactory.DriverManager;
import com.test.onwerinterface.EnvConfigInterface;

public final class ExtentLogger {

	static EnvConfigInterface configInterface = ConfigFactory.create(EnvConfigInterface.class);

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void info(String message) {
		ExtentManager.getExtentTest().info(message);
	}

	public static void info(String message, boolean isTrue) {
		if (isTrue && configInterface.infoscreenshot()) {
			ExtentManager.getExtentTest().info(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureScrenshot()).build());
		} else {
			pass(message);
		}
	}

	public static void pass(String message, boolean isTrue) {
		if (isTrue && configInterface.passscreenshot()) {
			ExtentManager.getExtentTest().pass(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureScrenshot()).build());
		} else {
			pass(message);
		}
	}

	public static void fail(String message, boolean isTrue) {
		if (isTrue && configInterface.failscreenshot()) {
			ExtentManager.getExtentTest().fail(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureScrenshot()).build());
		} else {
			fail(message);
		}
	}

	public static void skip(String message, boolean isTrue) {
		if (isTrue && configInterface.skipscreenshot()) {
			ExtentManager.getExtentTest().skip(message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(captureScrenshot()).build());
		} else {
			skip(message);
		}
	}

	private static String captureScrenshot() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}

	public static void setOwner(String authorName) {
		ExtentManager.getExtentTest().assignAuthor(authorName);
	}

	public static void setCategory(String module) {
		ExtentManager.getExtentTest().assignCategory(module);
	}

	public static void setDevice(String deviceName) {
		ExtentManager.getExtentTest().assignDevice(deviceName);
	}
}
