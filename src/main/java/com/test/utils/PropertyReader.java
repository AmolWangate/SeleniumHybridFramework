package com.test.utils;

import java.util.Objects;
import java.util.Properties;

import com.test.constants.FrameworkConstants;
import com.test.customexception.InvalidKeyException;
import com.test.enums.EnvConfig;

public class PropertyReader {

	private static PropertyReader propertyReader;
	Properties properties;

	private PropertyReader() {
		properties = PropertyLoaderUtility.getPropertyLoader(FrameworkConstants.getEnvConfigPath());
	}

	public static PropertyReader getInstance() {
		if (propertyReader == null) {
			propertyReader = new PropertyReader();
		}
		return propertyReader;
	}

	public String getPropertyValue(EnvConfig key) {
		if (Objects.isNull(key) || Objects.isNull(properties.getProperty(key.name().toLowerCase()))) {
			throw new InvalidKeyException(String.format("provided key %s is not correct: " + key));
		}
		return properties.getProperty(key.name().toLowerCase());
	}

}
