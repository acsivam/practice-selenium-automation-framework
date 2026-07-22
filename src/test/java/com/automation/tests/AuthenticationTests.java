package com.automation.tests;

import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.assertions.AuthenticationAssertions;
import com.automation.base.BaseTest;
import com.automation.models.User;
import com.automation.pages.AccountCreatedPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.SignupPage;
import com.automation.testdata.TestDataFactory;


@Test(groups = {"Authentication"})
public class AuthenticationTests extends BaseTest {
	
	private HomePage homePage;
	private LoginPage loginPage;
	private User user;
	
	
	@BeforeMethod(dependsOnMethods = "launchApplication")
	public void setupAuthenticationTest(Method method) {
		homePage = new HomePage(driver);
		loginPage = homePage
				.getTopMenu()
				.goToLoginPage();
		logger.info("setupRegisterTest was successful");
		logger.info("Starting {}", method.getName());
	}
	
	
	public void shouldDisplaySignupForm(){
		
		AuthenticationAssertions  assertAuth = new AuthenticationAssertions(loginPage);
		assertAuth.hasDefaultSignupForm();
	}

	
	public void shouldPreventRegistrationWithExistingEmail() {
		User user = TestDataFactory.existingUser();
		
		loginPage
			.getSignupForm()
			.signup(user);
		
		AuthenticationAssertions  assertAuth = new AuthenticationAssertions(loginPage);
		assertAuth.hasExisitingEmailError();
	}
	 
	
	public void shouldNavigateToAccountInformationPageForNewUser() {
		User user = TestDataFactory.newUser();
		
		SignupPage signupPage =	loginPage
				.getSignupForm()
				.signup(user);
		
		AuthenticationAssertions  assertAuth = new AuthenticationAssertions(signupPage);
		assertAuth.hasNavigatedAccountInfo();
	}
	
	
	//Do DDT here later
	public void shouldPreventAccountCreationWithInvalidDetails() {
		//logger.info("Executing  ....");
	}
	
	
	public void  shouldSuccessfullyRegisterNewUser() {
		User user = TestDataFactory.newUser();
		this.user = user; 
		logger.info("User to be created: {} {} ", user.getEmail(), user.getPassword());
		
		AccountCreatedPage accCreatedPage = loginPage
				.getSignupForm()
				.signup(user)
				.createAccount(user);
		
		AuthenticationAssertions  assertAuth = new AuthenticationAssertions(accCreatedPage);
		assertAuth.hasAccountCreated();
	}
	 
	
	public void shouldDisplayLoginForm() {
		
		AuthenticationAssertions  assertAuth = new AuthenticationAssertions(loginPage);
		assertAuth.hasDefaultLoginForm();
	}
	
	
	public void shouldSuccessfullyLogin() {
		User user = TestDataFactory.existingUser();
		user = user;
		
		homePage = loginPage.getLoginForm().login(user);
		
		AuthenticationAssertions  assertAuth = new AuthenticationAssertions(homePage);
		assertAuth.hasLoggedInSuccessfully(user);
	}
	
	
	// Do DDT later. also change name to WithInvlidCredentials
	public void  shouldRejectLoginWithInvalidPassword() {
		//logger.info("Executing  ....);
	}

	
	
	public void  shouldSuccessfullyLogout() {
		User user = TestDataFactory.existingUser();
		homePage = loginAs(user);
		
		loginPage = homePage.getTopMenu().logout();
		
		AuthenticationAssertions  assertAuth = new AuthenticationAssertions(loginPage);
		assertAuth.hasLoggedOutSuccessfully();
	}
	
	
	@AfterMethod
	public void cleanup() {
		deleteAccount();
		logger.info("Cleanup completed!");
	}
	 
	/* ------------------------*
	 *  Private helper methods
	 * ------------------------*/
	
	private void deleteAccount() {
		if (user == null) {
			logger.info("No user found!");
			return;
		}
		
		try {
			new AccountCreatedPage(driver)
				.clickContinue()
				.getTopMenu()
				.deleteAccount();
			
			logger.info("Deleted user: {} ", user.getEmail());
		
		}catch(Exception e) {
			logger.error("Failed to delete user: {} ", user.getEmail(), e);
		}

	}
	
	private HomePage loginAs(User user) {
		return homePage
				.getTopMenu()
				.goToLoginPage()
				.getLoginForm()
				.login(user);
	}
	
}
