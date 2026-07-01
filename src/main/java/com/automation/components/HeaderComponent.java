package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.ElementUtils;

public class HeaderComponent {
	
	private WebDriver driver;
	private ElementUtils eleUtil;
	
	public HeaderComponent(WebDriver driver) {
		this.driver = driver;
	}
	
	private By logo	= By.xpath("//img[@alt='Website for automation practice']");
	
	
	public void clickLogo() {
		eleUtil.click(logo);
	}
	
	public boolean isLogoDisplayed() {
		return eleUtil.isDisplayed(logo);
	}

}
