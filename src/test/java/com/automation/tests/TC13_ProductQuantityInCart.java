package com.automation.tests;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.components.AddToCartModal;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductDetailsPage;

public class TC13_ProductQuantityInCart extends BaseTest{
	/*/
	@Test
	public void verifyProductQuantityInCarts(){
		SoftAssert softAssert = new SoftAssert();
		String actualResults;

		HomePage homePage = new HomePage(driver);
		actualResults = homePage.getPageTitle();
		softAssert.assertEquals(actualResults, "Automation Exercise");
		
		ProductDetailsPage productDetailsPage = homePage.viewProduct("6");
		productDetailsPage.setQuantity(4);
		AddToCartModal addToCartModal = productDetailsPage.addToCart();
		CartPage cartPage = addToCartModal.viewCart();

		List<String> list = cartPage.getCartProductIds();
		softAssert.assertTrue(list.contains("6"));
		
		list = cartPage.getProductQuantyty();
		softAssert.assertTrue(list.contains("4"));
		
		softAssert.assertAll();
	}
*/
}
