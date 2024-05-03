package com.test.extentreport;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.test.constants.FrameworkConstants;
import com.test.onwerinterface.EnvConfigInterface;

public final class ExtentInitializer {

	private static final Logger LOG = LogManager.getLogger();
	
	private ExtentInitializer() {

	}

	private static ExtentReports extentReports;

	public static void createReport() {
		if (Objects.isNull(extentReports)) {
			LOG.info("Creating extent report");
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
			LOG.info("Flushing report");
			extentReports.flush();
			ExtentManager.unload();
			openReportPostExectuion();
		}
	}
	
	public static void openReportPostExectuion() {
		if (ConfigFactory.create(EnvConfigInterface.class).openreport()) {
			try {
				LOG.info("opening report...");
				Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
			} catch (IOException e) {
				LOG.error(String.format("Report could not be opeded due to %s ", e.getCause()));
				e.printStackTrace();
			}
		}
	}

	public static void createTest(String testCaseName) {
		ExtentManager.setExtentTest(extentReports.createTest(testCaseName));
	}

}
