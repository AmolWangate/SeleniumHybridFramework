package com.test.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.enums.WaitType;
import com.test.utils.DriverUtilites;

public class LoginPage {

	@FindBy(xpath = "//input[@data-test='username']")
	private WebElement inputUserName;

	@FindBy(xpath = "//input[@data-test='password']")
	private WebElement inputUserPwd;

	@FindBy(xpath = "//input[@data-test='login-button']")
	private WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public LoginPage sendUserName(String userName) {
		DriverUtilites.sendKeys(inputUserName, WaitType.VISIBLE, userName, "user name");
		return this;
	}

	public LoginPage sendUserPWD(String userPWD) {
		DriverUtilites.sendKeys(inputUserPwd, WaitType.VISIBLE, userPWD, "user password");
		return this;
	}

	public void clickLoginBtn() {
		DriverUtilites.click(btnLogin, WaitType.CLICKABLE, "login button");
	}

	
}
