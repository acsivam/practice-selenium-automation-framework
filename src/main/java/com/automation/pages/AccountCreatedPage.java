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
	private By accountCreatedMessages 	= By.xpath("//h2[@data-qa='account-created']/following-sibling::p"); 
	private By accountSuccessMessage 	= By.xpath("//p[contains(text(),'Congratulations! Your new account')]"); //::p[1]
	private By accountPrivilegeMessage 	= By.xpath("//p[contains(text(),'You can now take advantage of member privileges')]");
	private By continueButton			= By.cssSelector("[data-qa='continue-button']");
	
	  
	
	public boolean isLoaded() {
		/*
		boolean urlCheck = getCurrentUrl()
	            .contains(AppConstants.ACCOUNT_CREATED_PAGE_PATH);

	    boolean headingCheck = isAccountCreatedHeadingDisplayed();

	    System.out.println("Current URL: " + getCurrentUrl());
	    System.out.println("Expected path: " + AppConstants.ACCOUNT_CREATED_PAGE_PATH);
	    System.out.println("URL check: " + urlCheck);
	    System.out.println("Heading check: " + headingCheck);

	    return urlCheck && headingCheck;
	    */
		System.out.println(getCurrentUrl().contains(AppConstants.ACCOUNT_CREATED_PAGE_PATH));
		System.out.println(isAccountCreatedHeadingDisplayed());
		System.out.println(isAccountSuccessMessagesDisplayed());
		System.out.println();
		
		return getCurrentUrl().contains(AppConstants.ACCOUNT_CREATED_PAGE_PATH)
				&& isAccountCreatedHeadingDisplayed()
				&& isAccountSuccessMessagesDisplayed(); 
	} 
	
	public boolean isAccountCreatedHeadingDisplayed() {
		return eleUtil.waitForVisibility(accountCreatedHeading).isDisplayed();
	}
	 
	public String getAccountCreatedHeading() {
		return eleUtil.waitForVisibility(accountCreatedHeading).getText();
	}
	
	public boolean isAccountSuccessMessagesDisplayed() {
		return eleUtil.isDisplayed(accountCreatedMessages);
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
