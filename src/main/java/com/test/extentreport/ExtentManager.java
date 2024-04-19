package com.test.extentreport;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {

	private ExtentManager() {

	}

	private static ThreadLocal<ExtentTest> tlExtent = new ThreadLocal<>();

	static synchronized void setExtentTest(ExtentTest extentTest) {
		tlExtent.set(extentTest);
	}

	 static synchronized ExtentTest getExtentTest() {
		return tlExtent.get();
	}

	static void unload() {
		tlExtent.remove();
	}
}
