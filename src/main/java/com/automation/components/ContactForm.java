package com.automation.components;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactForm extends BaseComponent {

    public ContactForm(WebDriver driver) {
        super(driver);
    }


    private By name 		= By.cssSelector("[data-qa='name']");
    private By email 		= By.cssSelector("[data-qa='email']");
    private By subject 		= By.cssSelector("[data-qa='subject']");
    private By message 		= By.cssSelector("[data-qa='message']");
    private By uploadFile 	= By.name("upload_file");
    private By submit 		= By.cssSelector("[data-qa='submit-button']");
    private By successMessage = By.cssSelector(".status.alert-success");


    public void enterName(String value) {
    	eleUtil.enterText(name, value);
    }


    public void enterEmail(String value) {
        eleUtil.enterText(email, value);
    }


    public void enterSubject(String value) {
        eleUtil.enterText(subject, value);
    }


    public void enterMessage(String value) {
        eleUtil.enterText(message, value);
    }


    public void uploadFile(String path) {
        eleUtil.uploadFile(uploadFile, path);
    }

    public void submitForm() {
        eleUtil.click(submit);
        acceptConfirmationAlert();
    }

    private void acceptConfirmationAlert() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    alert.accept(); // clicks "OK"
	}
    
    public boolean isSuccessMessageDisplayed() {
        return eleUtil.isDisplayed(successMessage);
    }
}
