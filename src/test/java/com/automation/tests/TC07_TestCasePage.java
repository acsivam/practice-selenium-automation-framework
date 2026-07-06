package com.automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.TestCasesPage;

public class TC07_TestCasePage extends BaseTest{

	@Test
	public void verifyUserCanBavigateToTestCasesPage() {
		SoftAssert softAssert = new SoftAssert();
		
		HomePage homePage = new HomePage(driver);
		String title = homePage.getPageTitle();
		softAssert.assertEquals(title, "Automation Exercise");
		
		TestCasesPage testCasesPage = homePage.getTopMenu().goToTestCasesPage();
		String heading = testCasesPage.getTestCasesHeading();
		softAssert.assertEquals(heading, "TEST CASES");
		
		softAssert.assertAll();
	}
}
