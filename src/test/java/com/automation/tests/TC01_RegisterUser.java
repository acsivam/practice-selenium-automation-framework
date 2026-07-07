package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.pages.AccountCreatedPage;
import com.automation.pages.AccountDeletedPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.SignupPage;

public class TC01_RegisterUser extends BaseTest{
	

	@Test
	public void verifyRegisterUser() {
		logger.info("**** Starting verifyRegisterUser ****");
		SoftAssert softAssert = new SoftAssert();
	
		HomePage homePage = new HomePage(driver);
		String title = homePage.getPageTitle();
		//Assert.assertEquals(title, "Automation Exercise"); //hard assert
		softAssert.assertEquals(title, "Automation Exercise");
		
		LoginPage loginPage = homePage.getTopMenu().goToLoginPage();
		boolean b = loginPage.isSignupHeadingDisplayed();
		//Assert.assertTrue(b, "Signup section is not visible");
		softAssert.assertTrue(b, "Signup section is not visible");
		
		loginPage.enterName("Adam");
		loginPage.enterSingupEmail("abcd@123.com");
		loginPage.clickSignup();
		SignupPage signupPage = new SignupPage(driver);
		String accountInfo = signupPage.getAccountInfoHeading();
		//Assert.assertEquals(accountInfo, "ENTER ACCOUNT INFORMATION");
		softAssert.assertEquals(accountInfo, "ENTER ACCOUNT INFORMATION");
		
		String addressInfo = signupPage.getAddressInfoHeading();
		//Assert.assertEquals(addressInfo, "ADDRESS INFORMATION");
		softAssert.assertEquals(addressInfo, "ADDRESS INFORMATION");
		
		signupPage.selectTitle("mrs");
		signupPage.enterName("John");
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
		//Assert.assertEquals(accCreated, "ACCOUNT CREATED!");
		softAssert.assertEquals(accCreated, "ACCOUNT CREATED!");
		
		acountCreatedPage.clickContinue();
		AccountDeletedPage accountDeletedPage = homePage.getTopMenu().deleteAccount();
		String accDeleted = accountDeletedPage.getAccountDeletedHeading();
		Assert.assertEquals(accDeleted, "ACCOUNT DELETED!");
		softAssert.assertEquals(accDeleted, "ACCOUNT DELETED!");

		title = homePage.getPageTitle();
		Assert.assertEquals(title, "Automation Exercise - Account Created");
		
		softAssert.assertAll();
		
		logger.info("**** Finished verifyRegisterUser ****");
	}
}
