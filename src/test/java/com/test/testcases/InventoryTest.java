package com.test.testcases;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.baseclass.BaseClass;
import com.test.customannotation.TestAnnotation;
import com.test.driverfactory.DriverManager;
import com.test.extentreport.ExtentLogger;
import com.test.pagemanager.PageObjectManager;

public class InventoryTest extends BaseClass {

	@TestAnnotation(deviceName = "Desktop", module = "Inventory", user = "Bot")
	@Parameters("demo")
	@Test(groups = { "regression" }, description = "verify products title is displayed on inventory page")
	public void verifyProductTitle(String xmlParmValue) {
		ExtentLogger.info("param value from testngXML file : " + xmlParmValue);
		PageObjectManager pageObjectManager = new PageObjectManager(DriverManager.getDriver());
		pageObjectManager.getTestPage().sendUserName("standard_user").sendUserPWD("secret_sauce").clickLoginBtn();
		String productsTitle = pageObjectManager.getInventoryPage().getProductsTitle();
		assertThat(productsTitle).isNotNull().hasSize(8).isEqualTo("products");
	}
}
