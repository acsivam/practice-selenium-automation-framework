package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;


public class ReviewForm extends BaseComponent {

    public ReviewForm(WebDriver driver) {
        super(driver);
    }

    private By container     	= By.cssSelector(".replay-box");
    private By heading      	= By.tagName("h2");
    private By nameField 		= By.id("name");
    private By emailField 		= By.id("email");
    private By reviewField 		= By.id("review");
    private By submitButton 	= By.id("button-review");
    private By successMessage 	= By.cssSelector(".alert-success");


	@Override
    public boolean isDisplayed() {
    	return eleUtil.isDisplayed(container);
    }
    
    public boolean isHeaderDisplayed() {
    	return eleUtil.isDisplayed(heading);
    }
    
    public String getHeader() {
    	return eleUtil.getText(heading);
    }
    
    public void enterName(String name) {
        eleUtil.enterText(nameField, name);
    }

    public void enterEmail(String email) {
    	eleUtil.enterText(emailField, email);
    }

    public void enterReview(String review) {
    	eleUtil.enterText(reviewField, review);
    }

    public void clickSubmit() {
        eleUtil.click(submitButton);
    }

    public void submitReview(String name, String email, String review) {
    	enterName(name);
    	enterEmail(email);
    	enterReview(review);
    	clickSubmit();
    }
    
    public boolean isSuccessMessageDisplayed() { //isReviewSubmitted()
        return eleUtil.isDisplayed(successMessage);
    }

    public String getSuccessMessage() {
    	return eleUtil.getText(successMessage);
    }
}
