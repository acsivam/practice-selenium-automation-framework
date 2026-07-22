package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;
import com.automation.pages.HomePage;

public class HeaderComponent extends BaseComponent{
	
	public HeaderComponent(WebDriver driver) {
		super(driver);
	}
	
	private By header 	= By.id("header");
	private By logo		= By.xpath("//img[@alt='Website for automation practice']");
	
	
	@Override
	public boolean isDisplayed() {
		return eleUtil.waitForVisibility(header).isDisplayed();
	}
	
	public boolean isLogoDisplayed() {
		return eleUtil.isDisplayed(logo);
	}
	
	public HomePage clickLogo() {
		eleUtil.click(logo);
		return new HomePage(driver);
	}
}
