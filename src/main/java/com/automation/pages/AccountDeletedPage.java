package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.constants.AppConstants;

public class AccountDeletedPage extends BasePage{
	
	public AccountDeletedPage(WebDriver driver) {
		super(driver);
	}
	
	private By accountDeletedHeading	= By.xpath("//b[normalize-space()='Account Deleted!']");
	private By accountDeleteConfirm		= By.xpath("//h2[@data-qa='account-deleted']/following-sibling::p");
	private By accountDeletedMessage 	= By.xpath("//p[contains(text(),'Your account')]");
	private By accountPrivilegeMessage	= By.xpath("//p[contains(text(),'You can create')]");
	private By continueButton			= By.xpath("//a[@class='btn btn-primary']");
	 
	
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.ACCOUNT_DELETED_PAGE_PATH)
				&& isAccountDeletedHeadingDisplayed();
	}
	
	public boolean isAccountDeletedHeadingDisplayed() {
		return eleUtil.waitForClickable(accountDeletedHeading).isDisplayed();
	}
	
	public String getAccountDeletedHeading() {
		return eleUtil.getText(accountDeletedHeading);
	}
	
	public List<String> getAccountDeletedConfirmationMessage(){
		return eleUtil.getElementsText(accountDeleteConfirm);
	}
	
	public List<String> getAccountDeletedMessages() {
	    return eleUtil.getElementsText(accountDeletedMessage);
	}
	
	public List<String> getAccountPrivilegeMessages() {
	    return eleUtil.getElementsText(accountPrivilegeMessage);
	}
	
	public HomePage clickContinue() {
		eleUtil.click(continueButton);
		return new HomePage(driver);
	}

}
