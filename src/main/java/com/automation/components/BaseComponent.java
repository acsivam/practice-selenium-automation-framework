package com.automation.components;

import org.openqa.selenium.WebDriver;

import com.automation.utils.ElementUtils;

public class BaseComponent {

	protected WebDriver driver;
	protected ElementUtils eleUtil;
	
	public BaseComponent(WebDriver driver) {
		this.driver		= driver;
		this.eleUtil 	= new ElementUtils(driver);
	}

}
