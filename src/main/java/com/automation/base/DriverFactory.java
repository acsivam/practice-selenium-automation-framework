package com.automation.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.automation.utils.LoggerUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static final Logger logger =
            LoggerUtil.getLogger(DriverFactory.class);

    public static WebDriver createDriver(String browser) {

        switch(browser.trim().toLowerCase()) {

        case "chrome":
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        case "safari":
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();

        default:
            throw new IllegalArgumentException(
                "Browser not supported: " + browser
            );
        }
    }
}