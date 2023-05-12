package com.example.util;

import java.util.Objects;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.example.constants.Constants;
import com.example.constants.Environment;
import com.example.customexception.InvalidKeyException;

public final class ConfigLoader {

	private final Properties properties;
	private static ConfigLoader configLoader;
	private static final Logger LOG = LogManager.getLogger();

	private ConfigLoader() {
		properties = PropertyFileUtils.loadPropertyFile(Constants.getEnvConfigFilePath());
	}

	public static ConfigLoader getInstance() {
		if (configLoader == null) {
			configLoader = new ConfigLoader();
		}
		return configLoader;
	}

	public String getPropertyValue(Environment key) {
		if (Objects.isNull(key) || Objects.isNull(properties.getProperty(key.name().toLowerCase()))) {
			LOG.fatal("Error occured while reading value from properties file");
			throw new InvalidKeyException("Please check the key again");
		}
		LOG.info("Key is: "+key+" & valus is: "+properties.getProperty(key.name().toLowerCase()));
		return properties.getProperty(key.name().toLowerCase());	
	}
}
