package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterComponent extends BaseComponent{
	
	public FooterComponent(WebDriver driver) {
		super(driver);
	}
	
	private By footer 					= By.cssSelector("div.footer-widget");
	private By subcriptionHeading		= By.xpath("//h2[normalize-space()='Subscription']");
	private By subscribeEmail 			= By.xpath("//input[@id='susbscribe_email']");
	private By submitSubscription		= By.xpath("//button[@id='subscribe']");
	private By subscribeSuccessMessage	= By.xpath("//div[@class='alert-success alert']");
	
	
	public boolean isDisplayed() {
		return eleUtil.isDisplayed(footer);
	}
	
	public String getSubscriptionHeading() {
		return eleUtil.getText(subcriptionHeading);
	}
	
	public void enterEmail(String email) {
		eleUtil.enterText(subscribeEmail, email);
	}
	
	public void clickSubscribe() {
		eleUtil.click(submitSubscription);
	}
	
	public void subscribe(String email) {
		enterEmail(email);
		clickSubscribe();
	}
	
	public boolean isSubscribeSuccessMessageDisplayed() {
		return eleUtil.isDisplayed(subscribeSuccessMessage);
	}
	
	public String getSubscriberSuccessMessage() {
		return eleUtil.waitForVisibility(subscribeSuccessMessage).getText();
	}
}
