package com.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager {

	 private static ExtentReports extentReport;
	 private static String reportPath;

	    public static ExtentReports getExtentReports() {


        	
	        if(extentReport == null) {	        
		    	String timeStamp  = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	        	String reportName = "Test Report - " + timeStamp + ".html";
	        	reportPath = System.getProperty("user.dir") + "/reports/" + reportName;
	        	
	        	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/" + reportName);
	    		sparkReporter.config().setDocumentTitle("Automation Test Report");
	    		sparkReporter.config().setReportName("Automation Exercises Functional Testing");
	    		sparkReporter.config().setTheme(Theme.DARK);
	    		
	            extentReport = new ExtentReports();
	            extentReport.attachReporter(sparkReporter);
	            extentReport.setSystemInfo("Application", "opencart");
	            extentReport.setSystemInfo("Module", "Admin");
	            extentReport.setSystemInfo("Submodule", "Customers");
	            extentReport.setSystemInfo("Username", System.getProperty("user.name"));
	            extentReport.setSystemInfo("Environmanet", "QA");
	            // extentReport.setSystemInfo("OS", os);	 
	            // extentReport.setSystemInfo("Browser", browser);
	            }

	        return extentReport;
	    }
	    
	    
	    public static String getReportPath() {
	        return reportPath;
	    }

}
