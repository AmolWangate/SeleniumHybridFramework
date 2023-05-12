package com.example.extentreport;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> tlExtentTest = new ThreadLocal<>();

	public static void setTest(ExtentTest extentTest) {
		tlExtentTest.set(extentTest);
	}

	public static ExtentTest getTest() {
		return tlExtentTest.get();
	}

	public static void unload() {
		tlExtentTest.remove();
	}

}
