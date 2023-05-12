package com.example.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class PropertyFileUtils {

	private PropertyFileUtils() {

	}

	public static Properties loadPropertyFile(String filePath) {

		Properties properties = new Properties();
		try {
			FileInputStream inputStream = new FileInputStream(filePath);
			properties.load(inputStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;

	}
}
