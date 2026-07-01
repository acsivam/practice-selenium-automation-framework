package com.automation.pages;

import org.openqa.selenium.WebDriver;

import com.automation.components.FooterComponent;
import com.automation.components.HeaderComponent;
import com.automation.components.TopMenuComponent;

public class BasePage {
	protected WebDriver driver;
	
	public HeaderComponent header;
	public FooterComponent footer;
	public TopMenuComponent topMenu;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
		header 	= new HeaderComponent(driver);
		footer 	= new FooterComponent(driver);
		topMenu	= new TopMenuComponent(driver);
	}
	
    // page-level navigation helper
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

}
