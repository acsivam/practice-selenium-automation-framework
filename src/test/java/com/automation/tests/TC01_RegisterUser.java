package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.base.DriverFactory;
import com.automation.models.User;
import com.automation.pages.AccountCreatedPage;
import com.automation.pages.AccountDeletedPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.SignupPage;

public class TC01_RegisterUser extends BaseTest{
	
    private HomePage homePage;
    private LoginPage LoginPage;
    private User user;
	
	@BeforeMethod
    public void setUpTest() {
		//launchApplication();
        homePage	= new HomePage(driver);
       // LoginPage 	= homePage.getTopMenu().goToLoginPage();
        
    	user = new User();
		user.setName("John");
		user.setEmail("john123@testnow.com");
    }
	
	@Test
	public void tc01_verifyUserCanSignup() {
		logger.info("**** Starting tc01_verifyUserCanSignup ****");
		SoftAssert softAssert = new SoftAssert();
	
		String title = homePage.getPageTitle();
		softAssert.assertEquals(title, "Automation Exercise");
		
		LoginPage loginPage = homePage.getTopMenu().goToLoginPage();
		Assert.assertTrue(
				loginPage.getSignupForm().isDisplayed(),
				"Signup form is not displayed"
				);
		
		SignupPage signupPage = loginPage.getSignupForm().signup(user);
		Assert.assertTrue(
				signupPage.isAccountInfoSectionDisplayed(),
				"Account Information Section not displayed"
				);
		
		softAssert.assertAll();
		
		logger.info("**** Finished tc01_verifyUserCanSignup ****");
	}	
	
	@Test
	public void tc02_verifyUserCanCreateAccount() {
		logger.info("**** Starting tc01_verifyUserCanSignup ****");
		SoftAssert softAssert = new SoftAssert();
		
		LoginPage loginPage = homePage.getTopMenu().goToLoginPage();
		SignupPage signupPage = loginPage.getSignupForm().signup(user);
		
		User usr = new User();
		usr.setTitle("Mr");
		usr.setName("John");
		usr.setPassword("pass123");
		usr.setDay("19");
		usr.setMonth("August");
		usr.setYear("1999");
		usr.setNewsletter(true);
		usr.setSpecialOffers(false);
		usr.setFirstName("John");
		usr.setLastName("William");
		usr.setCompany("Baur And Company");
	    usr.setAddress1("Main Road");
	    usr.setAddress2("Galaxy Path");
	    usr.setCountry("India");
	    usr.setState("ABCD");
	    usr.setCity("Mumbai");
	    usr.setZipcode("1234");
	    usr.setMobile("123456");

		AccountCreatedPage accCreated= signupPage.createAccount(usr);
		Assert.assertTrue(
				accCreated.isAccountCreatedHeadingDisplayed(),
				"Account Created");
		homePage = accCreated.clickContinue();
		softAssert.assertTrue(
				homePage.getTopMenu().isLoginAsDisplayed(),
				"Login As not displayed");
		AccountDeletedPage accDel = homePage.getTopMenu().deleteAccount();
		softAssert.assertEquals(
				accDel.getAccountDeletedHeading(),
				"ACCOUNT DELETED!");
		accDel.clickContinue();
		
		softAssert.assertAll();		
	}
		/*
		SignupPage signupPage = new SignupPage(driver);
		String accountInfo = signupPage.getSignupAccountForm().getHeading();
		softAssert.assertEquals(accountInfo, "ENTER ACCOUNT INFORMATION");
		
		signupPage.getSignupAccountForm().fill(User user);
		
		String addressInfo = signupPage.getAddressForm().getAddressInfoHeading();
		softAssert.assertEquals(addressInfo, "ADDRESS INFORMATION");
		
		signupPage.selectTitle("mrs");
		signupPage.enterName("John");
		signupPage.enterPassword("1234asd");
		signupPage.selectDateOfBirth("19", "February", "1994");
		signupPage.subscribeToNewsletter(true);
		signupPage.receiveSpecialOffers(true);
		
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
		
		*/

}
