package com.automation.assertions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.automation.pages.CheckoutPage;

public class CheckoutAssertions {

	private CheckoutPage checkoutPage;
	
	public CheckoutAssertions(CheckoutPage checkoutPage) {
		this.checkoutPage = checkoutPage;
	}
	
	public static CheckoutAssertions verifyThat (CheckoutPage checkoutPage) {
		return new CheckoutAssertions(checkoutPage);
	}
	
	public CheckoutAssertions hasAddressDetailsHeading() {
		SoftAssert softly = new SoftAssert();
		
		softly.assertTrue(
				checkoutPage.isAddresDetailsHeadingDisplayed(),
				"Address details heading is missing"
				);
		softly.assertEquals(
				checkoutPage.getAddressDetailsHeading(),
				"Address Details!",
				"Address details heading mismatch");
		softly.assertAll();
		
		return this;
	}
	
	public CheckoutAssertions hasReviewOrderHeading() {
		SoftAssert softly = new SoftAssert();
		
		softly.assertTrue(
				checkoutPage.isRevieworderHeadingDisplayed(),
				"Review order heading is missing"
				);
		softly.assertEquals(
				checkoutPage.getAddressDetailsHeading(),
				"Address Details!",
				"Review order heading mismatch");
		return this;
	}
	
	public CheckoutAssertions hasComment(String expectedComment) {
		Assert.assertEquals(
				checkoutPage.getOrderCommentSection().getComment(),
				expectedComment,
				"Review comment mismatch"
				);
		return this;
	}
}
