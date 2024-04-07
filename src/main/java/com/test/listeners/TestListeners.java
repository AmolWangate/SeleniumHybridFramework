package com.test.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.test.customannotation.TestAnnotation;
import com.test.extentreport.ExtentInitializer;
import com.test.extentreport.ExtentLogger;

public class TestListeners implements ISuiteListener, ITestListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentInitializer.createReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentInitializer.flushReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentInitializer.createTest(result.getMethod().getDescription());
		ExtentLogger.setOwner(
				result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestAnnotation.class).user());
		ExtentLogger.setCategory(
				result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(TestAnnotation.class).module());
		ExtentLogger.setDevice(result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(TestAnnotation.class).deviceName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " is failed", true);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped", true);
	}
}
