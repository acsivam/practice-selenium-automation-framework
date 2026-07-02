package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class TC04_LogoutUser extends BaseTest{

	@Test
	public void verifyUserCanLogut() {
		HomePage homePage = new HomePage(driver);
		String title = homePage.getPageTitle();
		Assert.assertEquals(title, "Automation Exercise");
		
		LoginPage loginPage = homePage.topMenu.goToLoginPage();
		String loginHeading = loginPage.getLoginHeading();
		Assert.assertEquals(loginHeading, "Login to your account");
		
		homePage = loginPage.login("johnwilliam@gmail.com", "Test1234");
		boolean loggedIn = homePage.topMenu.isLoginAsDisplayed();
		Assert.assertTrue(loggedIn, "Loggedin As not displayed");
		
		loginPage = homePage.topMenu.logout();
		String loginUrl  = "https://automationexercise.com/login";
		String actualPage = loginPage.getPageUrl();
		Assert.assertTrue(loginUrl==actualPage, "Didnt navigate to Login Page afte logging out");
	}
}
