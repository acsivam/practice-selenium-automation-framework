package com.automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;

public class TC11_SubscriptionInCart extends BaseTest{

	@Test
	public void verifyUserCanSubscribeFromCartPage() {
		SoftAssert softAssert = new SoftAssert();
		String actualResults;

		HomePage homePage = new HomePage(driver);
		actualResults = homePage.getPageTitle();
		softAssert.assertEquals(actualResults, "Automation Exercise");
		
		CartPage cartPage = homePage.getTopMenu().goToCartPage();
		actualResults = cartPage.getFooter().getSubscriptionHeading();
		softAssert.assertEquals(actualResults,  "SUBSCRIPTION");
		
		cartPage.getFooter().subscribe("jks@gmail.com");
		boolean value = cartPage.getFooter().isSubscribeSuccessMessageDisplayed();
		softAssert.assertTrue(value, "Success message is not displayed");
		
		actualResults = cartPage.getFooter().getSubscriberSuccessMessage();
		softAssert.assertEquals(actualResults,  "You have been successfully subscribed!");
		
		softAssert.assertAll();
	}

}
