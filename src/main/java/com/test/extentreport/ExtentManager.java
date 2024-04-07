package com.test.extentreport;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> tlExtent = new ThreadLocal<>();

	public static synchronized void setExtentTest(ExtentTest extentTest) {
		tlExtent.set(extentTest);
	}

	public static synchronized ExtentTest getExtentTest() {
		return tlExtent.get();
	}

	public static void unload() {
		tlExtent.remove();
	}
}
