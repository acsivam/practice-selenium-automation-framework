package com.automation.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.pages.HomePage;
import com.automation.pages.ProductsPage;

public class TC09_SearchProduct extends BaseTest{

	@Test
	public void verifyUserCanSearchProduct() {
		SoftAssert softAssert = new SoftAssert();

		HomePage homePage = new HomePage(driver);
		String title = homePage.getPageTitle();
		softAssert.assertEquals(title, "Automation Exercise");

		ProductsPage productsPage = homePage.getTopMenu().goToProductsPage();
		String productHeading = productsPage.getProductHeading();
		softAssert.assertEquals(productHeading, "ALL PRODUCTS");
		
		productsPage.searchProduct("blue top");
		productHeading = productsPage.getProductHeading();
		softAssert.assertEquals(productHeading, "SEARCHED PRODUCTS");
		
		int productCount = productsPage.getProductCount();
		softAssert.assertEquals(productCount, 1);
		
		softAssert.assertAll();
	}
}
