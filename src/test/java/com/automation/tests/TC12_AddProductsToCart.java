package com.automation.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.components.AddToCartModal;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductsPage;

public class TC12_AddProductsToCart extends BaseTest{

	@Test
	public void verifyUserCanAddProductsToCart() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		String actualResults;

		HomePage homePage = new HomePage(driver);
		actualResults = homePage.getPageTitle();
		softAssert.assertEquals(actualResults, "Automation Exercise");
		
		ProductsPage productsPage = homePage.getTopMenu().goToProductsPage();
		String expectedProductId0 = productsPage.getProductNameByIndex(0);
		AddToCartModal addToCartModal = productsPage.clickAddToCartByProductId("1");

		addToCartModal.continueShopping();
		addToCartModal = productsPage.clickAddToCartByProductId("21");
		CartPage cartPage = addToCartModal.viewCart();
		
		System.out.println(cartPage.getPageUrl());
		int productCount =	cartPage.getCartItemCount();
		softAssert.assertEquals(productCount, 2);
		
		List<String> list = cartPage.getCartProductIds();
		softAssert.assertTrue(list.contains("1"));
		softAssert.assertTrue(list.contains("21"));
		
		softAssert.assertAll();	
	}

}
