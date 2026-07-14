package com.automation.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static void initializeDriver(String browser) {
        driver.set(DriverFactory.createDriver(browser));
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
