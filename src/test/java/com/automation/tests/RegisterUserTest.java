package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.constants.AppConstants;
import com.automation.models.User;
import com.automation.pages.AccountCreatedPage;
import com.automation.pages.AccountDeletedPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.SignupPage;
import com.automation.testdata.TestDataFactory;

@Test(groups = {"Registration"})
public class RegisterUserTest extends BaseTest{

	private HomePage homePage;
	private LoginPage loginPage;
	private String email;
	
	
	@BeforeMethod(dependsOnMethods = "launchApplication")
	public void registerTestSetup() {
		homePage = new HomePage(driver);
		loginPage = homePage.getTopMenu().goToLoginPage();
	}
	
	@Test(priority = 1)
	public void verifySignupFormDisplayed() {
		Assert.assertTrue(
				loginPage.getSignupForm().isDisplayed(),
				"Signup form should be displayed."
				);
	}

	@Test(priority = 2)
	public void verifyInvalidEmailError() {
		User user = TestDataFactory.createValidSignupUser();
		user.setEmail("1234.com");
		
		loginPage.getSignupForm().signup(user);
		
		Assert.assertTrue(
				loginPage.getSignupForm().isDisplayed(),
				"User should remain on the Signup form (login page) after invalid registration.");
	}
	
	@Test(priority = 3)
	public void verifyExistingEmailError() {
		User user = TestDataFactory.createExitingSignupUser();
		
		loginPage.getSignupForm().signup(user);
		
		Assert.assertTrue(
				loginPage.getSignupForm().isErrorMessageDisplayed(),
				"Email already exists error message should be displayed.");
		Assert.assertEquals(
				loginPage.getSignupForm().getErrorMessage(),
				"Email Address already exist!");
	}
	
	@Test(priority = 4)
	public void verifyValidEmailTakesUserToSignupPage() {
		User user = TestDataFactory.createValidSignupUser();
		
		SignupPage signupPage = new SignupPage(driver);
		signupPage = loginPage.getSignupForm().signup(user);
		
		Assert.assertTrue(
				signupPage.isDisplayed(),
				"Signup Page should be displayed.");
	}
	
	@Test(priority = 5)
	public void verifyCreateAccountError() {
		User user = TestDataFactory.createValidCreateAccountUser();
		user.setPassword("");
		
		SignupPage signupPage = 
				loginPage.getSignupForm().signup(user);
		signupPage.createAccount(user);
		
		Assert.assertTrue(
				signupPage.isDisplayed(),
				"Signup page should remain displayed after invalid registration.");
	}
	
	@Test(priority = 6)
	public void verifyScuccessfulCreationOfAccount() {
		
		SoftAssert softAssert = new SoftAssert();
		
		User user = TestDataFactory.createValidCreateAccountUser();
		SignupPage signupPage = 
				loginPage.getSignupForm().signup(user);
		logger.info("User created: {}", user.getEmail());
		email = user.getEmail();
		
		signupPage.createAccount(user);
		
		
		AccountCreatedPage accountCreatedPage =
				new AccountCreatedPage(driver);
		
		Assert.assertTrue(
				accountCreatedPage.isAccountCreatedHeadingDisplayed(),
				"Account Created Page should be displayed.");
		softAssert.assertEquals(
				accountCreatedPage.getAccountCreatedHeading(),
				AppConstants.ACCOUNT_CREATED_PAGE_HEADING);
		/*
		softAssert.assertEquals(
				accountCreatedPage.getAccountSuccessMessage(),
				"Congratulations! Your new account has been successfully created!",
				"Account creation success message should be displayed.");
		softAssert.assertEquals(
				accountCreatedPage.getAccountPrivilegeMessage(),
				"You can now take advantage of member privileges to "
				+ "enhance your online shopping experience with us.");
		*/
		
		homePage = accountCreatedPage.clickContinue();
		
		softAssert.assertTrue(
				homePage.getCarousel().isDisplayed(),
				"Home page should be displayed");
		softAssert.assertTrue(
				homePage.getTopMenu().isLoginAsDisplayed(),
				"Logged in as should be displayed");
		
		loginPage = homePage.getTopMenu().logout();
		
		softAssert.assertTrue(
				loginPage.getSignupForm().isDisplayed(),
				"Login Page should be displayed after logging out"
				);
		
		softAssert.assertAll();
	}
	
	@Test(priority = 7)
	public void verifyUserCanDeleteAccount() {
		SoftAssert softAssert = new SoftAssert();
		
		homePage = loginPage.getLoginForm().login(email, "pass1234");
		
		AccountDeletedPage accountDeletedPage = 
				homePage.getTopMenu().deleteAccount();
		softAssert.assertEquals(
				accountDeletedPage.getAccountDeletedHeading(),
				AppConstants.ACCOUNT_DELETED_PAGE_HEADING);
		/*"ACCOUNT DELETED!"*/
		/*
		softAssert.assertEquals(
				accountDeletedPage.getAccountDeletedMessages(),
				" has been permanently deleted!");
		softAssert.assertEquals(
				accountDeletedPage.getAccountPrivilegeMessages(),
				"You can create new account to take advantage of "
				+ "member privileges to enhance your online shopping "
				+ "experience with us.");
		*/
		
		homePage = accountDeletedPage.clickContinue();
		softAssert.assertTrue(
				homePage.getCarousel().isDisplayed(),
				"Home page should be displayed");
		/**/
		
		softAssert.assertAll();
	}
}
