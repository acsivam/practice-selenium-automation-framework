package com.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {

    	switch(browser.trim().toLowerCase()) {
    	
    	case "chrome":
    		WebDriverManager.chromedriver().setup();
    		driver.set(new ChromeDriver());
    		break;
    		
    	case "firefox":
    		WebDriverManager.firefoxdriver().setup();
    		driver.set(new FirefoxDriver());
    		break;
    		
    	case "safari":
    		WebDriverManager.safaridriver().setup();
    		driver.set(new SafariDriver());
    		break;
   
    	default:
    		throw new IllegalArgumentException(
                    "Browser not supported: " + browser
                );
    	}
    
    }
    	
   
    public static WebDriver getDriver() {
        return driver.get();
    }


    public static void quitDriver() {
        if(driver.get() != null) {
            driver.get().quit();
            driver.remove();

        }
    }
    
}
