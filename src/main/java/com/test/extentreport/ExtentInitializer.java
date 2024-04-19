package com.test.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.constants.FrameworkConstants;

public final class ExtentInitializer {

	private ExtentInitializer() {

	}

	private static ExtentReports extentReports;

	public static void createReport() {
		if (Objects.isNull(extentReports)) {
			extentReports = new ExtentReports();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setDocumentTitle("Automation Report");
			sparkReporter.config().setDocumentTitle("Report");
			sparkReporter.config().setEncoding("UTF-8");
			extentReports.attachReporter(sparkReporter);
		}
	}

	public static void flushReport() {
		if (Objects.nonNull(extentReports)) {
			extentReports.flush();
		}
		try {
			Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
	}

}
