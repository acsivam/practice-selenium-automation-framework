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
		this.driver 	= driver;
		this.logger 	= LoggerUtil.getLogger(getClass());
		
		this.eleUtil 	= new ElementUtils(driver);
        this.footer 	= new FooterComponent(driver);
        this.header 	= new HeaderComponent(driver);
        this.topMenu	= new TopMenuComponent(driver);
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
