package com.automation.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseTest;
import com.automation.components.TopMenuComponent;
import com.automation.pages.AccountCreatedPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.SignupPage;

public class TC01_RegisterUser extends BaseTest{
	

	@Test
	public void verifyRegisterUser() {
		System.out.println(">>> SET UP RUNNING");
	
		HomePage homePage = new HomePage(driver);
		String title = homePage.getPageTitle();
		Assert.assertEquals(title, "Automation Exercise");
		
		LoginPage loginPage = homePage.topMenu.goToLoginPage();
		boolean b = loginPage.isSignupHeadingDisplayed();
		Assert.assertTrue(b, "Signup section is not visible");
	
		System.out.println(">>> 1");
		loginPage.enterName("Adam a");
		loginPage.enterSingupEmail("pass@qwe.com");
		loginPage.clickSignup();
		SignupPage signupPage = new SignupPage(driver);
		String accountInfo = signupPage.getAccountInfoHeading();
		Assert.assertEquals(accountInfo, "ENTER ACCOUNT INFORMATION");
		System.out.println(">>> 2");
		
		String addressInfo = signupPage.getAddressInfoHeading();
		System.out.println(addressInfo);
		Assert.assertEquals(addressInfo, "ADDRESS INFORMATION");
		System.out.println(">>> 3");
		
		signupPage.selectTitle("mrs");
		signupPage.enterName("Hohn");
		signupPage.enterPassword("1234asd");
		signupPage.selectDateOfBirth("19", "February", "1994");
		signupPage.selectNewsLetter(true);
		signupPage.selectOffers(true);
		
		signupPage.enterFirstName("John");
		signupPage.enterLastName("Will");
		signupPage.enterCompany("Harbour");
		signupPage.enterAddress1("Main Road");
		signupPage.enterAddress2("Nowhere");
		signupPage.selectCountry("India");
		signupPage.enterState("ABCD");
		signupPage.enterCity("Honda");
		signupPage.enterZipCode("12345");
		signupPage.enterMobileNumber("1234567");
		signupPage.clickCreateAccount();
		
		AccountCreatedPage acountCreatedPage = new AccountCreatedPage(driver);
		String accCreated = acountCreatedPage.getAccountCreatedHeading();
		Assert.assertEquals(accCreated, "ACCOUNT CREATED!");
		
		acountCreatedPage.clickContinue();
		boolean loginAs = homePage.topMenu.isLoginAsDisplayed();
		Assert.assertTrue(loginAs, "Loggedin as not displayed");
		//loginPage.signup("Adam", "pass123");
		System.out.println(">>> 1");
		
		System.out.println(">>> 2");
			System.out.println(">>> here");
		//String title = homePage.getPageTitle();
		//System.out.println(title);
		//Assert.assertEquals(title, "Automation Exercise");
	}


}
