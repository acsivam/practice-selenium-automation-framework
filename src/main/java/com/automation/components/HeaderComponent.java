package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.HomePage;

public class HeaderComponent extends BaseComponent{
	
	public HeaderComponent(WebDriver driver) {
		super(driver);
	}
	
	private By header 	= By.cssSelector("div.header-middle");
	private By logo		= By.xpath("//img[@alt='Website for automation practice']");
	
	
	public boolean isDisplayed() {
		return eleUtil.isDisplayed(header);
	}
	
	public boolean isLogoDisplayed() {
		return eleUtil.isDisplayed(logo);
	}
	
	public HomePage clickLogo() {
		eleUtil.click(logo);
		return new HomePage(driver);
	}
}
