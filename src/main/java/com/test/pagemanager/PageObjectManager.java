package com.test.pagemanager;

import org.openqa.selenium.WebDriver;

import com.test.pompages.InventoryPage;
import com.test.pompages.LoginPage;

public class PageObjectManager {

	private WebDriver driver;
	private LoginPage loginPage;
	private InventoryPage inventoryPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPage getTestPage() {
		if (loginPage == null) {
			loginPage = new LoginPage(driver);
		}
		return loginPage;
	}

	public InventoryPage getInventoryPage() {
		if (inventoryPage == null) {
			inventoryPage = new InventoryPage(driver);
		}
		return inventoryPage;
	}
}
