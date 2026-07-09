package com.automation.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

public class ScreenshotUtil {
	
	private static final Logger logger =
            LoggerUtil.getLogger(ScreenshotUtil.class);
	
    public static String captureScreenshot(WebDriver driver, String testName) {
    	
    	logger.info("Capturing screenshot for: " + testName);
        String screenshotPath = System.getProperty("user.dir") 
        		+ "./screenshots/" 
        		+ testName 
        		+ ".png";

        TakesScreenshot ts = (TakesScreenshot) driver;

        File source = ts.getScreenshotAs(OutputType.FILE);

        File destination = new File(screenshotPath);

        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return screenshotPath;
    }
}
