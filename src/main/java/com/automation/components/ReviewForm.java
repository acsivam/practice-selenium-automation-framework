package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class ReviewForm extends BasePage {

    public ReviewForm(WebDriver driver) {
        super(driver);
    }

    private By name 			= By.id("name");
    private By email 			= By.id("email");
    private By review 			= By.id("review");
    private By submitButton 	= By.id("button-review");
    private By successMessage 	= By.cssSelector(".alert-success");


    public void enterName(String value) {
        eleUtil.enterText(name, value);
    }


    public void enterEmail(String value) {
    	eleUtil.enterText(email, value);
    }


    public void enterReview(String value) {
    	eleUtil.enterText(review, value);
    }


    public void submitReview() {
        eleUtil.click(submitButton);
    }


    public boolean isReviewSubmitted() {
        return eleUtil.isDisplayed(successMessage);
    }

    public void writeReview(String name, String email, String reviewText) {

        enterName(name);
        enterEmail(email);
        enterReview(reviewText);
        submitReview();
    }

}
