package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;
import com.automation.models.User;
import com.automation.pages.HomePage;

public class LoginForm extends BaseComponent {

    public LoginForm(WebDriver driver) {
        super(driver);
    }
	
	private By loginFormContainer	= By.cssSelector(".login-form");
	private By loginFormHeader 		= By.xpath("//div[@class='login-form']//h2");
    private By emailField 			= By.cssSelector("[data-qa='login-email']");
    private By passwordField		= By.cssSelector("[data-qa='login-password']");
    private By loginButton 			= By.cssSelector("[data-qa='login-button']");


	@Override
    public boolean isDisplayed() {
    	return eleUtil.waitForVisibility(loginFormContainer).isDisplayed();
    }
    
    public boolean isHeadingDisplayed() {
    	return eleUtil.waitForVisibility(loginFormHeader).isDisplayed();
    }
    
    public String getHeading() {
    	return eleUtil.getText(loginFormHeader);
    }
    
    public void enterEmail(String email) {
        eleUtil.enterText(emailField, email);
    }

    public void enterPassword(String password) {
        eleUtil.enterText(passwordField, password);
    }

    public void clickLogin() {
    	eleUtil.click(loginButton);
    }
    public HomePage login(User user) {
        enterEmail(user.getEmail());
        enterPassword(user.getPassword());
        clickLogin();
        logger.info("Logged in as user {}", user.getEmail(), user.getPassword());
        return new HomePage(driver);
    }
}
