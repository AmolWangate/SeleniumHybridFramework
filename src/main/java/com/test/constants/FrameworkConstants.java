package com.test.constants;

import java.io.File;

import org.aeonbits.owner.ConfigFactory;

import com.test.onwerinterface.EnvConfigInterface;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final int EXPLICIT_WAIT = 40;
	private static final int PAGE_TIMEOUT_WAIT = 60;
	private static final String USER_DIR = System.getProperty("user.dir");
	private static final String MAIN_RESOURCES_PATH = USER_DIR + File.separator + "src" + File.separator + "main"
			+ File.separator + "resources";
	private static final String TEST_RESOURCES_PATH = USER_DIR + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources";
	private static final String ENV_CONFIG_PATH = TEST_RESOURCES_PATH + File.separator + "envconfig.properties";
	private static final String EXTENT_REPORT_FOLDER_PATH = USER_DIR + File.separator + "Extent-Report";
	private static String extentReportFilePath = "";

	public static int getExplicitWait() {
		return EXPLICIT_WAIT;
	}

	public static int getPageTimeoutWait() {
		return PAGE_TIMEOUT_WAIT;
	}

	public static String getMainResourcesPath() {
		return MAIN_RESOURCES_PATH;
	}

	public static String getTestResourcesPath() {
		return TEST_RESOURCES_PATH;
	}

	public static String getEnvConfigPath() {
		return ENV_CONFIG_PATH;
	}

	public static String getExtentReportPath() {
		return EXTENT_REPORT_FOLDER_PATH;
	}

	public static String getExtentReportFilePath() {
		if (extentReportFilePath.isEmpty()) {
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() {
		if (ConfigFactory.create(EnvConfigInterface.class).overridereport()) {
			return EXTENT_REPORT_FOLDER_PATH + File.separator + "index.html";
		} else {
			return EXTENT_REPORT_FOLDER_PATH + File.separator + System.currentTimeMillis() + File.separator
					+ "index.html";
		}

	}
}
