package com.example.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.example.util.DriverUtilities;
import com.example.util.WaitStrategy;

public class DemoPage extends DriverUtilities {

	public DemoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//textarea[@name='q']")
	private WebElement textBox;

	public void enterTextInSearchBox(String textToBeEntered) {
		sendKeys(textBox, WaitStrategy.CLICKABLE, textToBeEntered, "Google search box");

	}
}
