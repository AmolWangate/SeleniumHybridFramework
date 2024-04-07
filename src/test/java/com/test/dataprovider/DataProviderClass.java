package com.test.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	@DataProvider(name = "loginData")
	public Object[][] getLoginData(){
		return new Object[][] {
			{"standard_user","secret_sauce"}
		};
	}
}
