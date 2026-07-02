package com.automation.pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utils.ElementUtils;

public class ContactUsPage extends BasePage{
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	String noteText = "Note: Below contact form is for testing purpose.";
	
	String feedbackMessage = 
			"We really appreciate your response to our website.\n"
			+ "\n"
			+ "\n"
			+ "Kindly share your feedback with us at feedback@automationexercise.com.\n"
			+ "\n"
			+ "\n"
			+ "If you have any suggestion areas or improvements, do let us know. We will definitely work on it.\n"
			+ "\n"
			+ "\n"
			+ "Thank you";

	// "Success! Your details have been submitted successfully."
	
	private By contactUsHeading		= By.xpath("//div[@class='col-sm-12']//h2[@class='title text-center']");
	private By note					= By.xpath("//b[normalize-space()='Note:']");
	private By getInTouchHeading	= By.xpath("//h2[normalize-space()='Get In Touch']");
	private By nameField			= By.xpath("//input[@placeholder='Name']");
	private By emailField			= By.xpath("//input[@placeholder='Email']");
	private By subjectField			= By.xpath("//input[@placeholder='Subject']");
	private By messageField			= By.xpath("//textarea[@id='message']");
	private By uploadFile			= By.xpath("//input[@name='upload_file']");
	private By submitButton			= By.xpath("//input[@name='submit']");
	private By feedbackHeading		= By.xpath("//h2[normalize-space()='Feedback For Us']");
	private By feedbackAddress		= By.xpath("//div[@class='contact-info']//address");
	private By feedbackEmail		= By.xpath("//u[normalize-space()='feedback@automationexercise.com']");
	private By messageSubmitted		= By.xpath("//div[@class='status alert alert-success']");
	private By homeButton			= By.xpath("//span[normalize-space()='Home']");
	
	public boolean isContactUsHeadingDisplyed() {
		return eleUtil.isDisplayed(contactUsHeading);
	}
	
	public String getContactUsHeading() {
		return eleUtil.getText(contactUsHeading);
	}
	
	public boolean isNoteDisplayed() {
		return eleUtil.isDisplayed(note);
	}
	
	public String getNoteText() {
		return eleUtil.getText(note);
	}
	
	public boolean isGetInTouchHeadingDisplayed() {
		return eleUtil.isDisplayed(getInTouchHeading);
	}
	
	public String getGetInTouchGeading() {
		return eleUtil.getText(getInTouchHeading);
	}
	
	public void enterName(String name) {
		eleUtil.enterText(nameField, name);
	}
	
	public void enterEmail(String email) {
		eleUtil.enterText(emailField, email);
	}
	
	public void enterSubject(String subject) {
		eleUtil.enterText(subjectField, subject);
	}
	
	public void enterMessage(String message) {
		eleUtil.enterText(messageField, message);
	}
	
	public void uploadFile(String filePath) {
		eleUtil.uploadFile(uploadFile, filePath);
	}
	
	public void clickSubmit() {
		eleUtil.click(submitButton);
	}
	
	public boolean isSubmitSuccessMessageDisplayed() {
		return eleUtil.isDisplayed(messageSubmitted);
	}
	
	public String getSubmitSuccessMessage() {
		return eleUtil.getText(messageSubmitted);
	}
	
	public HomePage clickHomeButton() {
		eleUtil.click(homeButton);
		return new HomePage(driver);
	}
	
	public void submitMessage(
			String name, 
			String email, 
			String subject, 
			String message, 
			String filePath) {
		enterName(name);
		enterEmail(email);
		enterSubject(subject);
		enterMessage(message);
		uploadFile(filePath);
		clickSubmit();		
		acceptConfirmationAlert();
	}
	
	private void acceptConfirmationAlert() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    alert.accept(); // clicks "OK"
	}
	
	public boolean isFeedbackHeadingDisplayed() {
		return eleUtil.isDisplayed(feedbackHeading);
	}
	
	public String getFeebackHeading() {
		return eleUtil.getText(feedbackHeading);
	}
	
	public boolean isFeedbackAddressDisplayed() {
		return eleUtil.isDisplayed(feedbackAddress);
	}
	
	public String getFeedbackAddress() {
		return eleUtil.getText(feedbackAddress);
	}
	
	public boolean isFeedbackEmailDisplaye() {
		return eleUtil.isDisplayed(feedbackEmail);
	}
	
	public String getFeedbackEmaill() {
		return eleUtil.getText(emailField);
	}
	
}
