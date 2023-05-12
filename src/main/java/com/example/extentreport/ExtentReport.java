package com.example.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.example.constants.Constants;

public final class ExtentReport {
	
	private static final Logger LOG = LogManager.getLogger();

	private ExtentReport() {

	}

	private static ExtentReports extentReports;

	public static void createReports() {
		if (Objects.isNull(extentReports)) {
			LOG.info("Creating report");
			extentReports = new ExtentReports();
			ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(Constants.getExtentReportPath());
			extentReports.attachReporter(extentSparkReporter);
			extentSparkReporter.config().setTheme(Theme.STANDARD);
			extentSparkReporter.config().setDocumentTitle("Selenium Report");
			extentSparkReporter.config().setReportName("Smoke Report");
		}
	}

	public static void flushReports() {
		if (Objects.nonNull(extentReports)) {
			LOG.info("Closing report");
			extentReports.flush();
		}
		try {
			Desktop.getDesktop().browse(new File(Constants.getExtentReportPath()).toURI());
		} catch (IOException e) {
			LOG.error("Could not open the report");
		}
	}

	public static void createTest(String testName) {
		ExtentManager.setTest(extentReports.createTest(testName));
	}

}
