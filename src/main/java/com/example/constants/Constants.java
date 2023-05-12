package com.example.constants;

import java.io.File;
import java.sql.Time;

import com.example.util.ConfigLoader;

public final class Constants {

	private Constants() {

	}

	private static final String EXTETNT_REPORT_PATH = System.getProperty("user.dir") + File.separator + "ExtentReport";
	private static final String ENV_CONFIG_FILE_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "EnvConfig.properties";
	private static final int PAGE_LOADING_TIMEOUT = 60;
	private static final int EXPLICIT_WAIT = 40;
	private static String extentReportFilePath = "";

	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}

	public static int getPageLoadingTimeout() {
		return PAGE_LOADING_TIMEOUT;
	}

	public static String getEnvConfigFilePath() {
		return ENV_CONFIG_FILE_PATH;
	}

	public static String getExtentReportPath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportpath();
		}
		return extentReportFilePath;
	}

	public static String createReportpath() {
		if (ConfigLoader.getInstance().getPropertyValue(Environment.OVERRIDE).equalsIgnoreCase("no")) {
			return EXTETNT_REPORT_PATH + File.separator + System.currentTimeMillis() + File.separator + "index.html";
		} else {
			return EXTETNT_REPORT_PATH + File.separator + File.separator + "index.html";
		}
	}
}
