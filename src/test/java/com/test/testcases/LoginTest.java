package com.test.testcases;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;
import com.test.baseclass.BaseClass;
import com.test.customannotation.TestAnnotation;
import com.test.dataprovider.DataProviderClass;
import com.test.driverfactory.DriverManager;
import com.test.pagemanager.PageObjectManager;

public class LoginTest extends BaseClass {

	@TestAnnotation(module = "login", deviceName = "All", user = "Amol")
	@Test(dataProvider = "loginData", dataProviderClass = DataProviderClass.class, groups = "smoke", description = "Verify login functionality")
	public void login(String userName, String password) {
		PageObjectManager pageObjectManager = new PageObjectManager(DriverManager.getDriver());
		pageObjectManager.getTestPage().sendUserName(userName).sendUserPWD(password).clickLoginBtn();
		boolean isProductsTitleDisplayed = pageObjectManager.getInventoryPage().isProductsTitleDisplayed();
		assertThat(isProductsTitleDisplayed).isTrue();
	}
}
