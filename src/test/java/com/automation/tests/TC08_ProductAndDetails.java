package com.automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.ProductDetailsPage;
import com.automation.pages.ProductsPage;

public class TC08_ProductAndDetails extends BaseTest{

	@Test
	public void verifyAllProductsAndProductDetailsPage() {
		SoftAssert softAssert = new SoftAssert();

		HomePage homePage = new HomePage(driver);
		String title = homePage.getPageTitle();
		softAssert.assertEquals(title, "Automation Exercise");

		ProductsPage productsPage = homePage.topMenu.goToProductsPage();
		String productHeading = productsPage.getProductHeading();
		softAssert.assertEquals(productHeading, "ALL PRODUCTS");
		
		boolean grid = productsPage.isProductHeadingDisplayed();
		softAssert.assertTrue(grid, "Product grid is not displayed");
		
		ProductDetailsPage productDetailsPage = productsPage.viewProduct(0);
		title = productDetailsPage.getPageTitle();
		System.out.println(title);
		softAssert.assertEquals(title, "Automation Exercise - Product Details");
		
		boolean details = productDetailsPage.areProductDetailsDisplayed();
		softAssert.assertTrue(details, "Product details are not displayed");
		
		softAssert.assertAll();
	}
}
