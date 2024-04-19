package com.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.customexception.FIFOException;
import com.test.customexception.FNFException;

public final class PropertyLoaderUtility {

	private static final Logger LOG = LogManager.getLogger();

	private PropertyLoaderUtility() {

	}

	public static Properties getPropertyLoader(String path) {

		FileInputStream fileInputStream = null;
		Properties properties = null;
		try {
			fileInputStream = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			LOG.fatal("File could not be located" + e.getMessage());
			throw new FNFException("file could not be located: " + e.getMessage(), e.getCause());
		}
		properties = new Properties();
		try {
			properties.load(fileInputStream);
		} catch (IOException e) {
			LOG.fatal("I/O exception has occured");
			throw new FIFOException("I/O exception occured: " + e.getMessage(), e.getCause());
		}
		return properties;

	}

}
