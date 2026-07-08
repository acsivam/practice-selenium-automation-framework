package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class AccountDeletedPage extends BasePage{
	
	public AccountDeletedPage(WebDriver driver) {
		super(driver);
	}
	
	private By accountDeletedHeading	= By.xpath("//b[normalize-space()='Account Deleted!']");
	private By accountDeletedMessage 	= By.xpath("//h2[@data-qa='account-deleted']/following-sibling::p");
	private By continueButton			= By.xpath("//a[@class='btn btn-primary']");
	
	
	public String getAccountDeletedHeading() {
		return eleUtil.getText(accountDeletedHeading);
	}
	
	public List<String> getAccountDeletedMessages() {
	    return eleUtil.getElementsText(accountDeletedMessage);
	}
	
	public HomePage clickContinue() {
		eleUtil.click(continueButton);
		return new HomePage(driver);
	}
}
