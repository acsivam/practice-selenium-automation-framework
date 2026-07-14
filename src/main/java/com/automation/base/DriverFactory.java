package com.automation.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.automation.utils.ConfigReader;
import com.automation.utils.LoggerUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	private static final Logger logger =
            LoggerUtil.getLogger(DriverFactory.class);

    public static WebDriver createDriver(String browser) {

        switch(browser.trim().toLowerCase()) {

        case "chrome":
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");

            return new ChromeDriver(options);

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