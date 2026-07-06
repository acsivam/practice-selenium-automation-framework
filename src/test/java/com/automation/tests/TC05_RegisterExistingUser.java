package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class TC05_RegisterExistingUser extends BaseTest{
	
	@Test
	public void verifyRegisterUserWithExistingEmail() {
		
		HomePage homePage = new HomePage(driver);
		String title = homePage.getPageTitle();
		Assert.assertEquals(title, "Automation Exercise");
		
		LoginPage loginPage = homePage.getTopMenu().goToLoginPage();
		boolean b = loginPage.isSignupHeadingDisplayed();
		Assert.assertTrue(b, "Signup section is not visible");
		
		loginPage.enterName("Adam");
		loginPage.enterSingupEmail("johnwilliam@gmail.com");
		loginPage.clickSignup();
		String signupError = loginPage.getSignupErrorMessage();
		Assert.assertEquals(signupError, "Email Address already exist!");
	}


}
