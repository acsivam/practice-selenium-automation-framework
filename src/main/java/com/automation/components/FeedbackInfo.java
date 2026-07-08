package com.automation.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FeedbackInfo extends BaseComponent {

    public FeedbackInfo(WebDriver driver) {
        super(driver);
    }

    private By feedbackSection 	= By.cssSelector(".contact-info");
    private By heading 			= By.cssSelector(".contact-info h2.title");
    private By messages 		= By.cssSelector(".contact-info address p");
    private By email 			= By.cssSelector(".contact-info address a[href^='mailto:']");


    public boolean isDisplayed() {
        return eleUtil.isDisplayed(feedbackSection);
    }


    public String getHeading() {
        return eleUtil.getText(heading);
    }


    public List<String> getMessages() {
        return eleUtil.getElementsText(messages);
    }


    public String getEmail() {
        return eleUtil.getText(email);
    }
}
