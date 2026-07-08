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
		this.driver 	= driver;
		this.eleUtil 	= new ElementUtils(driver);
        this.footer 	= new Footer(driver);
        this.header 	= new Header(driver);
        this.topMenu	= new TopMenu(driver);
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
