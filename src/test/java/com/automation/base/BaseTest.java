package com.automation.base;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.automation.driver.DriverManager;
import com.automation.utils.ConfigReader;
import com.automation.utils.LoggerUtil;

public class BaseTest {
	
	protected Logger logger = LoggerUtil.getLogger(getClass());
	protected WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(@Optional("chrome")String browser) {
		System.out.println(">>> SET UP RUNNING");
		DriverManager.initializeDriver(browser);
		driver = DriverManager.getDriver();
	}
	
	@BeforeMethod
	public void launchApplication() {
		logger.info("Preparing browser. Deleting cookies....");
		DriverManager.getDriver().manage().deleteAllCookies();

	    logger.info("Lauching application....");
		DriverManager.getDriver().get(ConfigReader.getProperty("appUrl"));
		DriverManager.getDriver().manage().window().maximize();
	}
	
	@AfterClass
	public void teardown() {
		DriverManager.quitDriver();
	}

}
