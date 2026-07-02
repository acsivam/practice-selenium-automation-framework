package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.BasePage;
import com.automation.utils.ElementUtils;

public class HeaderComponent extends BasePage{
	
	public HeaderComponent(WebDriver driver) {
		super(driver);
	}
	
	private By logo	= By.xpath("//img[@alt='Website for automation practice']");
	
	
	public void clickLogo() {
		eleUtil.click(logo);
	}
	
	public boolean isLogoDisplayed() {
		return eleUtil.isDisplayed(logo);
	}

}
