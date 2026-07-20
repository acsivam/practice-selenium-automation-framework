package com.automation.assertions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.automation.constants.AppConstants;
import com.automation.models.User;
import com.automation.pages.AccountCreatedPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.SignupPage;

public class AuthenticationAssertions {
	
	private HomePage homePage;
	private LoginPage loginPage;
	private SignupPage signupPage;
	private AccountCreatedPage accCreatedPage;
	
	public AuthenticationAssertions(HomePage homePage) {
		this.homePage = homePage;
	}
	
	public AuthenticationAssertions(LoginPage loginPage) {
		this.loginPage = loginPage;
	}
	
	public AuthenticationAssertions(SignupPage singupPage) {
		this.signupPage = singupPage;
	}
	
	public AuthenticationAssertions(AccountCreatedPage accCreatedPage) {
		this.accCreatedPage = accCreatedPage;
	}
	
	public AuthenticationAssertions hasSignupFormDisplayed() {
		Assert.assertTrue(
				loginPage.getSignupForm().isDisplayed(),
				"Signup form should be displayed"
				);
		return this;
	}
	
	public AuthenticationAssertions hasSignupHeading() {
		SoftAssert softly = new SoftAssert();
		
		softly.assertTrue(
				loginPage.getSignupForm().isHeaderDisplayed(),
				"Signup heading should be displayed"
				);
		softly.assertEquals(
				loginPage.getSignupForm().getHeader(),
				"New User Signup!",
				"Signup heading mismatch"
				);
		softly.assertAll();
		return this;
	}
	
	public AuthenticationAssertions hasDefaultSignupForm() {
		hasSignupFormDisplayed();
		hasSignupHeading();
		return this;
	}
	
	public AuthenticationAssertions hasExisitingEmailError() {
		SoftAssert softly = new SoftAssert();
		
		softly.assertTrue(
				loginPage.getSignupForm().isErrorMessageDisplayed(),
				"Existing email message should be displayed"
				);
		softly.assertEquals(
				loginPage.getSignupForm().getErrorMessage(),
				"Email Address already exist!",
				"Error message mismatch");
		return this;
	}
	
	public AuthenticationAssertions hasNavigatedAccountInfo() { //hasNavigatedAccountInfo()
		Assert.assertTrue(
				signupPage.isLoaded(),
				"Signup Page should be displayed");
		return this;
	}
	
	public AuthenticationAssertions hasAccountCreatedPageDisplayed() {
		Assert.assertTrue(
				accCreatedPage.isLoaded(),
				"User should be navigated to Accounts Created Page"
				);
		return this;
	}
	
	public AuthenticationAssertions hasAccountCreatedMessage(){
		SoftAssert softly = new SoftAssert();
		
		softly.assertEquals(
				accCreatedPage.getAccountCreatedHeading(),
				AppConstants.ACCOUNT_CREATED_PAGE_HEADING,
				"Account created page heading should be \"Account Created!\""
				);
		softly.assertTrue(
				accCreatedPage.isAccountSuccessMessageDisplayed(),
				"Account creation success mesage should be displayed"
				);
		softly.assertEquals(
				accCreatedPage.getAccountSuccessfulCreatedMessages(),
				"Congratulations! Your new account has been successfully created!",
				"Account created message mismatch"
				);
		softly.assertEquals(
				accCreatedPage.getAccountPrivilegeMessage(),
				"You can now take advantage of member privileges to "
				+ "enhance your online shopping experience with us.",
				"Member prvileage mesage mismatch"
				);
		softly.assertAll();
		return this;
	}
	
	public AuthenticationAssertions hasAccountCreated() {
		hasAccountCreatedPageDisplayed();
		hasAccountCreatedMessage();
		return this;
	}
	
	public AuthenticationAssertions hasLoginFormDisplayed() {
		Assert.assertTrue(
				loginPage.getLoginForm().isDisplayed(),
				"Login form should be displayed"
				);
		return this;
	}
	
	public AuthenticationAssertions hasLoginHeading() {
		SoftAssert softly = new SoftAssert();
		
		softly.assertTrue(
				loginPage.getLoginForm().isHeadingDisplayed(),
				"Login page ehading should be displayed");
		softly.assertEquals(
				loginPage.getLoginForm().getHeading(),
				"Login to your account",
				"Login heading mismatch"
				);
		softly.assertAll();
		return this;
	}
	
	public AuthenticationAssertions hasDefaultLoginForm() {
		hasLoginFormDisplayed();
		hasLoginHeading();
		return this;
	}
	
	public AuthenticationAssertions hasLoggedInSuccessfully(User user) {
		SoftAssert softly = new SoftAssert();
		
		softly.assertTrue(
				homePage.isLoaded(),
				"Home page should be displayed"
				);
		softly.assertTrue(
				homePage.getTopMenu().isLoggedInAsDisplayed(),
				"LoginAs should be displayed");
		softly.assertEquals(
				homePage.getTopMenu().getLoggedInAs(),
				"Logged in as " + user.getName(),
				"Logged in as mismatch"
				);
		softly.assertAll();
		return this;
	}
	
	public AuthenticationAssertions hasLoggedOutSuccessfully() {
		SoftAssert softly = new SoftAssert();
		
		softly.assertTrue(
				loginPage.isLoaded(),
				"Login page should be displayed"
				);
		softly.assertFalse(
				loginPage.getTopMenu().isLoggedInAsDisplayed(),
				"LoginAs should NOT be displayed");
		softly.assertAll();
		return this;
	}
}
