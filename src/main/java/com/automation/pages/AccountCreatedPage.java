package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class AccountCreatedPage extends BasePage{
	
	public AccountCreatedPage(WebDriver driver) {
		super(driver);
	}
	
	private By accountCreatedHeading 	= By.xpath("//b[normalize-space()='Account Created!']");
	private By accountSuccessMessages 	= By.xpath("//div[@id='content']//p");
	private By continueButton			= By.xpath("//a[@class='btn btn-primary']");
	
	
	public boolean isAccountCreatedHeadingDisplayed() {
		return eleUtil.isDisplayed(accountCreatedHeading);
	}
	
	public String getAccountCreatedHeading() {
		return eleUtil.getText(accountCreatedHeading);
	}
	
	public boolean isAccountSuccessMessageDisplayed() {
		return eleUtil.isDisplayed(accountSuccessMessages);
	}
	
	public List<String> getAccountSuccessMessages() {
	    return eleUtil.getElementsText(accountSuccessMessages);
	}
	
	public HomePage clickContinue() {
		eleUtil.click(continueButton);
		return new HomePage(driver);
	}

}
