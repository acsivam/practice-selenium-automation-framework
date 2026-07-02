package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BaseComponent{
	
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
