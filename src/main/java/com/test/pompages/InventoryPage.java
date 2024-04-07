package com.test.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.test.enums.WaitType;
import com.test.utils.DriverUtilites;

public class InventoryPage {

	@FindBy(xpath = "//span[@data-test='title']")
	private WebElement titleProducts;

	public InventoryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getProductsTitle() {
		return DriverUtilites.getText(titleProducts, WaitType.VISIBLE, "products title");
	}

	public boolean isProductsTitleDisplayed() {
		return DriverUtilites.isDisplayed(titleProducts, WaitType.VISIBLE, "products title");
	}
}
