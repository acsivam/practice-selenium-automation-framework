package com.automation.utils;

import org.openqa.selenium.WebDriver;

public class FileUtil {
	
	private WebDriver driver;
	
	public FileUtil(WebDriver driver) {
		this.driver = driver;
	}
	
	 public static String getTestFile(String fileName) {
	        return System.getProperty("user.dir")
	                + "/testData/files/" + fileName;
	    }

}
