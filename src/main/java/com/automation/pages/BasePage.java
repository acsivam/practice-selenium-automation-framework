package com.automation.pages;

import org.openqa.selenium.WebDriver;

import com.automation.components.FooterComponent;
import com.automation.components.HeaderComponent;
import com.automation.components.TopMenuComponent;
import com.automation.utils.ElementUtils;

public class BasePage {
	protected WebDriver driver;
	protected ElementUtils eleUtil;
	
	public HeaderComponent header;
	public FooterComponent footer;
	public TopMenuComponent topMenu;
	
	public BasePage(WebDriver driver) {
		this.driver 	= driver;
		this.eleUtil 	= new ElementUtils(driver);
        this.footer 	= new FooterComponent(driver);
        this.header 	= new HeaderComponent(driver);
        this.topMenu	= new TopMenuComponent(driver);
	}
	
    // page-level navigation helper
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

}
