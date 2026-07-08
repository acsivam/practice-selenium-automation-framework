package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginForm extends BaseComponent {

    private By email = By.cssSelector("[data-qa='login-email']");
    private By password = By.cssSelector("[data-qa='login-password']");
    private By loginButton = By.cssSelector("[data-qa='login-button']");

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String emailText) {
        eleUtil.enterText(email, emailText);
    }

    public void enterPassword(String passwordText) {
        eleUtil.enterText(password, passwordText);
    }

    public void login(String emailText, String passwordText) {
        enterEmail(emailText);
        enterPassword(passwordText);
        eleUtil.click(loginButton);
    }
}
