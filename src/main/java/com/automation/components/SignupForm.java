package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;
import com.automation.models.User;
import com.automation.pages.SignupPage;

public class SignupForm extends BaseComponent {

    public SignupForm(WebDriver driver) {
        super(driver);
    }
    
	private By signupForm 		= By.cssSelector(".signup-form");
	private By signupFormHeader = By.xpath("//div[@class='signup-form']//h2");
    private By name 			= By.cssSelector("[data-qa='signup-name']");
    private By email 			= By.cssSelector("[data-qa='signup-email']");
    private By signupButton 	= By.cssSelector("[data-qa='signup-button']");
    private By errorEmail		= By.xpath("//p[normalize-space()='Email Address already exist!']");


	@Override
    public boolean isDisplayed() {
    	return eleUtil.isDisplayed(signupForm);
    }
    
    public boolean isHeaderDisplayed() {
    	return eleUtil.isDisplayed(signupFormHeader);
    }
    
    public String getHeader() {
    	return eleUtil.getText(signupFormHeader);
    }
    
    public void enterName(String userName) {
    	 eleUtil.enterText(name, userName);
    }
    
    public void enterEmail(String userEmail) {
    	eleUtil.enterText(email, userEmail);
    }
    
    public void clickSignup() {
    	eleUtil.click(signupButton);
    }
    
    public boolean isErrorMessageDisplayed() {
    	return eleUtil.isDisplayed(errorEmail);
    }
    
    public String getErrorMessage() {
    	return eleUtil.getText(errorEmail);
    }
    
    public SignupPage signup(User user) {
    	enterName(user.getName());
    	enterEmail(user.getEmail());
    	clickSignup();
    	
    	return new SignupPage(driver);
    }
}
