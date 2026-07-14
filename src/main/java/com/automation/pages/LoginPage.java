package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.automation.base.BasePage;
import com.automation.components.LoginForm;
import com.automation.components.SignupForm;
import com.automation.constants.AppConstants;

public class LoginPage extends BasePage {

    private LoginForm loginForm;
    private SignupForm signupForm;

    public LoginPage(WebDriver driver) {
        super(driver);

        this.loginForm = new LoginForm(driver);
        this.signupForm = new SignupForm(driver);
    }

    private By loginPageContainer = By.id("form");
    
    
    
    public LoginForm getLoginForm() {
        return loginForm;
    }

    public SignupForm getSignupForm() {
        return signupForm;
    }

    private boolean isFormContainerDisplayed() {
    	return eleUtil.isDisplayed(loginPageContainer);
    }
    
    public boolean isLoaded() {
    	return getCurrentUrl().contains(AppConstants.LOGIN_PAGE_PATH)
    			&& isFormContainerDisplayed();
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
