package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.BasePage;
import com.automation.utils.ElementUtils;

public class FooterComponent extends BasePage{
	
	public FooterComponent(WebDriver driver) {
		super(driver);
	}
	
	private By subscribeEmail 			= By.xpath("//input[@id='susbscribe_email']");
	private By submitSubscription		= By.xpath("//button[@id='subscribe']");
	private By subscribeSuccessMessage	= By.xpath("//div[@class='alert-success alert']");
	
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
		return eleUtil.getText(submitSubscription);
	}
}
