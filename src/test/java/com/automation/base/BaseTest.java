package com.automation.base;

import java.sql.DriverManager;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.automation.base.DriverFactory;

public class BaseTest {

	//protected WebDriver driver;
	protected Logger logger;
	
	/*
	public WebDriver getDriver() {
	    return driver;
	}
	*/
	
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String browser) {
		System.out.println(">>> SET UP RUNNING");
		
		logger = LogManager.getLogger(this.getClass());
		
		DriverFactory.initDriver(browser);
		DriverFactory.getDriver()
			.manage().deleteAllCookies();
		DriverFactory.getDriver()
			.get("https://automationexercise.com/");
		DriverFactory.getDriver()
			.manage().window().maximize();
		
		//driver = new ChromeDriver();
		//driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.get("https://automationexercise.com/");
		//driver.manage().window().maximize();
	}
	
	
	@AfterClass
	public void teardown() {
		DriverFactory.quitDriver();
	}

}
