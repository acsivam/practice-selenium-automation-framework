package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class TestCasesPage extends BasePage {

	public TestCasesPage(WebDriver driver) {
		super(driver);
	}
	
	private By testCasesSection 	= By.id("form");
	private By testCasesHeading		= By.xpath("//b[normalize-space()='Test Cases']");
	
	
	
	public boolean isLoaded() {
	    return eleUtil.isDisplayed(testCasesSection);
	}
	
	
	public String getTestCasesHeading() {
		return eleUtil.getText(testCasesHeading);
	}

}
