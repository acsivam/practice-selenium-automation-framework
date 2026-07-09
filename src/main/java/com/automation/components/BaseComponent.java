package com.automation.components;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.automation.utils.ElementUtils;
import com.automation.utils.LoggerUtil;

public class BaseComponent {

	protected WebDriver driver;
	protected ElementUtils eleUtil;
	protected Logger logger;
	 
	public BaseComponent(WebDriver driver) {
		this.driver		= driver;
		this.eleUtil 	= new ElementUtils(driver);
		this.logger		= LoggerUtil.getLogger(getClass());
	}

}
