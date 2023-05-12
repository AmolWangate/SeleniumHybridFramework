package com.example.objectmanager;

import org.openqa.selenium.WebDriver;

import com.example.driverfactory.DriverManager;
import com.example.pompages.DemoPage;

public class PageObjectManager {

	private WebDriver driver;
	private DemoPage demoPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	public DemoPage getDemoPage() {
		if (demoPage == null) {
			demoPage = new DemoPage(driver);
		}
		return demoPage;
	}

}
