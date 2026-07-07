package com.automation.base;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

	public static WebDriver driver;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		System.out.println(">>> SET UP RUNNING");
		
		logger = LogManager.getLogger(this.getClass());
		
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://automationexercise.com/");
		driver.manage().window().maximize();
	}
	
	
	@AfterClass
	public void teardown() {
		driver.quit();
	}

}
