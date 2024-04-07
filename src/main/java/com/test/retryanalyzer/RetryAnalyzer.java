package com.test.retryanalyzer;

import org.aeonbits.owner.ConfigFactory;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.test.onwerinterface.EnvConfigInterface;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int count = 0;
	private int maxTry = ConfigFactory.create(EnvConfigInterface.class).retrycount();

	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			if (count < maxTry) {
				count++;
				result.setStatus(ITestResult.FAILURE);
				return true;
			} else {
				result.setStatus(ITestResult.FAILURE);
			}

		} else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
