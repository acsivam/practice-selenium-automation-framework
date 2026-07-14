package com.automation.base;

import org.apache.hc.client5.http.entity.mime.Header;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Footer;
import org.openqa.selenium.WebDriver;

import com.automation.components.FooterComponent;
import com.automation.components.HeaderComponent;
import com.automation.components.TopMenuComponent;
import com.automation.driver.DriverManager;
import com.automation.utils.ElementUtils;
import com.automation.utils.LoggerUtil;

public abstract class BasePage {
	
	protected WebDriver driver;
	protected ElementUtils eleUtil;
	protected Logger logger;
	
	private HeaderComponent header;
	private FooterComponent footer;
	private TopMenuComponent topMenu;
	
	public BasePage(WebDriver driver) {
		this.driver 	= DriverManager.getDriver();
		this.logger 	= LoggerUtil.getLogger(getClass());
		
		this.eleUtil 	= new ElementUtils(DriverManager.getDriver());
        this.footer 	= new FooterComponent(DriverManager.getDriver());
        this.header 	= new HeaderComponent(DriverManager.getDriver());
        this.topMenu	= new TopMenuComponent(DriverManager.getDriver());
	}
	
	public abstract boolean isLoaded();
	
	public HeaderComponent getHeader() {
        return header;
    }

    public FooterComponent getFooter() {
        return footer;
    }
    
    public TopMenuComponent getTopMenu() {
    	return topMenu;
    }

    // page-level navigation helper
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
