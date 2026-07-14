package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class TC03_UserLoginError extends BaseTest{
/*
	@Test
	public void verifyUserLoginWithIncorrectCredential() {
		
		HomePage homePage = new HomePage(driver);
		String title = homePage.getPageTitle();
		Assert.assertEquals(title, "Automation Exercise");
		
		LoginPage loginPage = homePage.getTopMenu().goToLoginPage();
		String loginHeading = loginPage.getLoginHeading();
		Assert.assertEquals(loginHeading, "Login to your account");
		
		loginPage.enterLoginEmail("johnwilliam@gmail.com");
		loginPage.enterPassword("1234abcd");
		loginPage.clickLogin();
		String loginError = loginPage.getLoginErrorMessage();
		Assert.assertEquals(loginError, "Your email or password is incorrect!");
	}
*/
}
