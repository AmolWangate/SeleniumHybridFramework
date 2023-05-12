package com.exampple.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.example.baseclass.BaseClass;
import com.example.customannotation.TestAnnotation;
import com.example.driverfactory.DriverManager;
import com.example.listener.*;
import com.example.objectmanager.PageObjectManager;

@Listeners(ListenerClass.class)
public class DemoClass extends BaseClass {
	
	@TestAnnotation(user = "Jon", category = "Smoke", deviceName = "iPhone")
	@Test(testName = "Demo test case B", description = "This is A Test case")
	public void TestCaseA(){	
		SoftAssert assert1=new SoftAssert();
		PageObjectManager manager=new PageObjectManager(DriverManager.getDriver());
		manager.getDemoPage().enterTextInSearchBox("Performing google search");
		assert1.assertEquals(0, 1,"Not Matching");
		manager.getDemoPage().enterTextInSearchBox("Performing google search 1");
		assert1.assertEquals("A", "B","Not matching");
		manager.getDemoPage().enterTextInSearchBox("Performing google search 2");
		assert1.assertAll();
	}
	
	@TestAnnotation(user = "Doe", category = "Regression", deviceName = "Android")
	@Test(testName = "Demo test case B", description = "This is B Test case")
	public void TestCaseB(){	
		PageObjectManager manager=new PageObjectManager(DriverManager.getDriver());
		manager.getDemoPage().enterTextInSearchBox("Performing google search");
	}

}
