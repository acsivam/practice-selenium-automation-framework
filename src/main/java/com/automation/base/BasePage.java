package com.automation.base;

import org.openqa.selenium.WebDriver;

import com.automation.components.Footer;
import com.automation.components.Header;
import com.automation.components.TopMenu;
import com.automation.utils.ElementUtils;

public class BasePage {
	protected WebDriver driver;
	protected ElementUtils eleUtil;
	
	private Header header;
	private Footer footer;
	private TopMenu topMenu;
	
	public BasePage(WebDriver driver) {
		this.driver 	= DriverManager.getDriver();
		this.eleUtil 	= new ElementUtils(DriverManager.getDriver());
        this.footer 	= new Footer(DriverManager.getDriver());
        this.header 	= new Header(DriverManager.getDriver());
        this.topMenu	= new TopMenu(DriverManager.getDriver());
	}
	
	
	public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }
    
    public TopMenu getTopMenu() {
    	return topMenu;
    }

    // page-level navigation helper
    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}
