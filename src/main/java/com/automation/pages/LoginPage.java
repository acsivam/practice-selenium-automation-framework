package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;
import com.automation.utils.ElementUtils;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	private By loginHeading			= By.xpath("//h2[normalize-space()='Login to your account']");
	private By loginEmailField		= By.xpath("//input[@data-qa='login-email']");
	private By passwordField		= By.xpath("//input[@placeholder='Password']");
	private By loginButton			= By.xpath("//button[normalize-space()='Login']");
	private By signupHeading		= By.xpath("//h2[normalize-space()='New User Signup!']");
	private By nameField			= By.xpath("//input[@placeholder='Name']");
	private By signupEmailField		= By.xpath("//input[@data-qa='signup-email']");
	private By signupButton			= By.xpath("//button[normalize-space()='Signup']");
	private By loginErrorMessage	= By.xpath("//p[normalize-space()='Your email or password is incorrect!']");
	private By signupErrorMessage	= By.xpath("//p[normalize-space()='Email Address already exist!']");
	
			public boolean isLoginHeadingDisplayed() {
		return eleUtil.isDisplayed(loginHeading);
	}
	
	public String getLoginHeading() {
		return eleUtil.getText(loginHeading);
	}
	
	public void enterLoginEmail(String email) {
		eleUtil.enterText(loginEmailField, email);
	}
	
	public void enterPassword(String password) {
		eleUtil.enterText(passwordField, password);
	}
	
	public void clickLogin() {
		eleUtil.click(loginButton);
	}
	
	public HomePage login(String email, String password) {
		enterLoginEmail(email);
		enterPassword(password);
		clickLogin();
		return new HomePage(driver);
	}
	
	public boolean isSignupHeadingDisplayed() {
		return eleUtil.isDisplayed(signupHeading);
	}
	
	public String getSignupHeading() {
		return eleUtil.getText(signupHeading);
	}
	
	public void enterName(String name) {
		eleUtil.enterText(nameField, name);
	}
	
	public void enterSingupEmail(String email) {
		eleUtil.enterText(signupEmailField, email);
	}
	
	public void clickSignup() {
		eleUtil.click(signupButton);
	}
	
	public SignupPage signup(String name, String email) {
		enterName(name);
		enterSingupEmail(email);
		clickSignup();
		return new SignupPage(driver);
		
	}
	
	public String getLoginErrorMessage() {
		return eleUtil.getText(loginErrorMessage);
	}
	
	public String getSignupErrorMessage() {
		return eleUtil.getText(signupErrorMessage);
	}
	/*
	public boolean isEmailInvalid() {
		
	    WebElement emailField = driver.findElement(By.name("email"));
	    return !(Boolean) ((JavascriptExecutor) driver)
	            .executeScript("return arguments[0].checkValidity();", emailField);
	}
	
	public String getEmailValidationMessage() {
	    WebElement emailField = driver.findElement(By.name("email"));
	    return (String) ((JavascriptExecutor) driver)
	            .executeScript("return arguments[0].validationMessage;", emailField);
	}
	*/
}
