package com.automation.driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserOptionsFactory {

	public static ChromeOptions getChromeOptions() {
		
		ChromeOptions options = new ChromeOptions();
		
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--headless=new");
        options.addArguments("--incognito");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-notifications");
		
        return options;
	}
	
	public static FirefoxOptions getFirefoxOptions() {
		
		FirefoxOptions options = new FirefoxOptions();
		
		 options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	     options.addArguments("-headless");
	     options.addArguments("-private");
	     options.addPreference("layers.acceleration.disabled", true);
	     options.addPreference("dom.webnotifications.enabled", false);
	     options.addArguments("--width=1920");
	     options.addArguments("--height=1080");
		
	     return options;
	}
	
	public static SafariOptions  getSafariOptions() {
		
		SafariOptions options = new SafariOptions();
		
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	
	    return options;
	}
	
	
    public static EdgeOptions getEdgeOptions() {

        EdgeOptions options = new EdgeOptions();

        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
	    options.addArguments("--headless=new");
	    options.addArguments("--inprivate");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--disable-gpu");
	    options.addArguments("--window-size=1920,1080");
       
	    return options;
    }
}
