package com.automation.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.automation.base.BaseTest;
import com.automation.base.DriverFactory;
import com.automation.base.DriverManager;
import com.automation.utils.ExtentReportManager;
import com.automation.utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements ITestListener {

    private static ExtentTest extendTest; 
    
    @Override
    public void onTestStart(ITestResult result) {
    	
        extendTest = ExtentReportManager
                .getExtentReports()
                .createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extendTest.pass("Test Passed");
        extendTest.assignCategory(result.getMethod().getGroups());
        extendTest.log(Status.PASS, result.getName() + " got successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extendTest.fail(result.getThrowable());
        extendTest.assignCategory(result.getMethod().getGroups());
        extendTest.log(Status.FAIL, result.getName() + " got failed");
        
        //BaseTest baseTest 	= (BaseTest) result.getInstance();
        //WebDriver driver	= baseTest.getDriver();
        
        String screenshotPath =
                ScreenshotUtil.captureScreenshot(
                		DriverManager.getDriver(),
                        result.getMethod().getMethodName()
                );
        System.out.println("Driver in listener: " + DriverManager.getDriver());
        extendTest.addScreenCaptureFromPath(screenshotPath, "Failed Screenshot");
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        extendTest.skip(result.getThrowable());
        extendTest.assignCategory(result.getMethod().getGroups());
        extendTest.log(Status.SKIP, result.getName() + "got skipped");
        extendTest.log(Status.INFO, result.getThrowable().getMessage());

    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentReportManager
                .getExtentReports()
                .flush();
		String pathOfExtentReport = ExtentReportManager.getReportPath();
		File extentReport = new File(pathOfExtentReport);
		
		/*
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch(IOException e) {
			e.printStackTrace();
		}
		/*/
    }
}
