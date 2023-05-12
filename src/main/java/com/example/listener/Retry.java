package com.example.listener;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.example.constants.Environment;
import com.example.util.ConfigLoader;

public class Retry implements IRetryAnalyzer {

	int count = 0;
	int max = Integer.parseInt(ConfigLoader.getInstance().getPropertyValue(Environment.RETRYCOUNT));

	@Override
	public boolean retry(ITestResult result) {
		if (count < max) {
			count++;
			return true;
		}
		return false;

	}

}
