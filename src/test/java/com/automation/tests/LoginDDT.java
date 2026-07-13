package com.automation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.dataproviders.TestDataProvider;
import com.automation.models.User;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.testdata.TestDataFactory;

public class LoginDDT extends BaseTest{

	private HomePage homePage;
	private LoginPage loginPage;
	//private String email;
	
	
	@BeforeMethod(dependsOnMethods = "launchApplication")
	public void loginTestSetup() {
		HomePage homePage = new HomePage(driver);
		loginPage = homePage.getTopMenu().goToLoginPage();
	}
	
	@Test(dataProvider = "registerData", dataProviderClass = TestDataProvider.class)
	public void verifyLogin(String email, String password) {
		//User user = TestDataFactory
		
		loginPage.getLoginForm().login(email, password);
		
	}
	
	
	@Test(dataProvider = "registerData", dataProviderClass = TestDataProvider.class)
	public void verifyLoginPojo(User user) {
		//User user = TestDataFactory
		
		loginPage.getLoginForm().login(user.getEmail(), user.getPassword());
		
	}
}
