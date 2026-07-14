package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.constants.AppConstants;

public class AccountCreatedPage extends BasePage{
	
	public AccountCreatedPage(WebDriver driver) {
		super(driver);
	}
	
	private By accountCreatedHeading 	= By.cssSelector("[data-qa='account-created']");
	private By accountCreatedMessages 	= By.xpath("//h2[@data-qa='account-created']/following::p"); 
	private By accountSuccessMessage 	= By.xpath("//p[contains(text(),'Congratulations! Your new account')]"); //::p[1]
	private By accountPrivilegeMessage 	= By.xpath("//p[contains(text(),'You can now take advantage of member privileges')]");
	private By continueButton			= By.cssSelector("[data-qa='continue-button']");
	
	
	
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.ACCOUNT_CREATED_PAGE_PATH)
				&& isAccountCreatedHeadingDisplayed();
	}
	
	public boolean isAccountCreatedHeadingDisplayed() {
		return eleUtil.isDisplayed(accountCreatedHeading);
	}
	
	public String getAccountCreatedHeading() {
		return eleUtil.getText(accountCreatedHeading);
	}
	
	public boolean isAccountSuccessMessageDisplayed() {
		return eleUtil.isDisplayed(accountSuccessMessage);
	}
	
	public List<String> getAccountSuccessfulCreatedMessages() {
	    return eleUtil.getElementsText(accountCreatedMessages);
	}
	
	public String getAccountSuccessMessage() {
	    return eleUtil.getText(accountSuccessMessage);
	}
	
	public String getAccountPrivilegeMessage() {
	    return eleUtil.getText(accountPrivilegeMessage);
	}
	
	public HomePage clickContinue() {
		eleUtil.click(continueButton);
		return new HomePage(driver);
	}
}
