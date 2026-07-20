package com.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.ContactForm;
import com.automation.components.FeedbackInfo;
import com.automation.constants.AppConstants;

public class ContactUsPage extends BasePage{
	
	private ContactForm contactForm;
    private FeedbackInfo feedbackInfo;
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
		
		this.contactForm 	= new ContactForm(driver);
        this.feedbackInfo	= new FeedbackInfo(driver);
	}
	
	private By contactUsContainer 	= By.id("contact-page");
	private By pageHeading 			= By.cssSelector("#contact-page > .bg h2.title");
	private By homeButton  			= By.xpath("//span[normalize-space()='Home']");

	
	public ContactForm getContactForm() {
		return contactForm;
	}
	
	public FeedbackInfo getFeedbackInfo() {
		return feedbackInfo;
	}
	
	private boolean isContactUsContainerDisplayed() {
	    return eleUtil.isDisplayed(contactUsContainer);
	}

	public String getHeading() {
	    return eleUtil.getText(pageHeading);
	}
    
	public HomePage ClickContinue() {
		eleUtil.click(homeButton);
		return new HomePage(driver);
	}
	
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.CONTACT_US_PAGE_PATH)
				&& isContactUsContainerDisplayed();
				
	}
	
	
	/*
	
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
	
	*/
	
}
