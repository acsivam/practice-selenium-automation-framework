package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class TC02_UserLoginSuccessfully extends BaseTest{

	@Test
	public void verifyUserLoginWithValidCredentials() {
		HomePage homePage = new HomePage(driver);
		String title = homePage.getPageTitle();
		Assert.assertEquals(title, "Automation Exercise");
		
		LoginPage loginPage = homePage.getTopMenu().goToLoginPage();
		String loginHeading = loginPage.getLoginHeading();
		Assert.assertEquals(loginHeading, "Login to your account");
		
		homePage = loginPage.login("johnwilliam@gmail.com", "Test1234");
		boolean loggedIn = homePage.getTopMenu().isLoginAsDisplayed();
		Assert.assertTrue(loggedIn, "Loggedin As not displayed");
		/*
		AccountDeletedPage accountDeletedPage = homePage.topMenu.deleteAccount();
		String accDeleted = accountDeletedPage.getAccountDeletedHeading();
		Assert.assertEquals(accDeleted, "ACCOUNT DELETED!");
		*/
	}
}
