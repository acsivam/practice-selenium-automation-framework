package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupForm extends BaseComponent {

    private By name = By.cssSelector("[data-qa='signup-name']");
    private By email = By.cssSelector("[data-qa='signup-email']");
    private By signupButton = By.cssSelector("[data-qa='signup-button']");

    public SignupForm(WebDriver driver) {
        super(driver);
    }

    public void signup(String userName, String emailText) {
        eleUtil.enterText(name, userName);
        eleUtil.enterText(email, emailText);
        eleUtil.click(signupButton);
    }
}
