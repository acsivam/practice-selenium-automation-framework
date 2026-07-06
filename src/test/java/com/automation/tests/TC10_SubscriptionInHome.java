package com.automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;

public class TC10_SubscriptionInHome extends BaseTest{

	@Test
	public void verifySubscriptionInHomePage() {
		SoftAssert softAssert = new SoftAssert();
		String actualResults;

		HomePage homePage = new HomePage(driver);
		actualResults = homePage.getPageTitle();
		softAssert.assertEquals(actualResults, "Automation Exercise");
		
		actualResults = homePage.getFooter().getSubscriptionHeading();
		softAssert.assertEquals(actualResults, "SUBSCRIPTION");
		
		homePage.getFooter().subscribe("jks@gmail.com");
		boolean value = homePage.getFooter().isSubscribeSuccessMessageDisplayed();
		softAssert.assertTrue(value, "Subscription success Message is not displayed");
		
		actualResults = homePage.getFooter().getSubscriberSuccessMessage();
		softAssert.assertEquals(actualResults, "You have been successfully subscribed!");
		
		softAssert.assertAll();
	}
}
