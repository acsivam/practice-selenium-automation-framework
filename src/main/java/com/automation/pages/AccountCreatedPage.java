package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.ElementUtils;

public class AccountCreatedPage extends BasePage{
	
	private ElementUtils eleUtil;
	
	public AccountCreatedPage(WebDriver driver) {
		super(driver);
		this.eleUtil = new ElementUtils(driver);
	}
	
	private By accountCreatedHeading 	= By.xpath("//b[normalize-space()='Account Created!']");
	private By congratsMessage			= By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]");
	private By memberMessage			= By.xpath("//p[contains(text(),'You can now take advantage of member privileges to')]");
	private By continueButton			= By.xpath("//a[@class='btn btn-primary']");
	
	public boolean isAccountCreatedHeadingDisplayed() {
		return eleUtil.isDisplayed(accountCreatedHeading);
		//		return driver.findElement(accountCreatedHeading).isDisplayed();
	}
	
	public String getAccountCreatedHeading() {
		return eleUtil.getText(accountCreatedHeading);
		//		return driver.findElement(accountCreatedHeading).getText();
	}
	
	public boolean isCongratsMessageDisplayed() {
		return eleUtil.isDisplayed(congratsMessage);
		//		return driver.findElement(congratsMessage).isDisplayed();
	}
	
	public String getCongratsMessage() {
		return eleUtil.getText(congratsMessage);
		//		return driver.findElement(congratsMessage).getText();
	}
	
	public boolean isMemberMessageDisplayed() {
		return eleUtil.isDisplayed(memberMessage);
		//		return driver.findElement(memberMessage).isDisplayed();
	}
	
	public String getMemberMessage() {
		return eleUtil.getText(congratsMessage);
		//			return driver.findElement(memberMessage).getText();
	}
	
	public HomePage clickContinue() {
		eleUtil.click(continueButton);
		return new HomePage(driver);
	}

}
