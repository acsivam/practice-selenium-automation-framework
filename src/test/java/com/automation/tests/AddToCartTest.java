package com.automation.tests;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.automation.components.AddToCartModal;
import com.automation.components.CartRow;
import com.automation.components.CartTable;
import com.automation.components.ProductCard;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductsPage;

public class AddToCartTest {

	private HomePage homePage;
	private ProductsPage productsPage;
	
	
	public void addToCartTestSetup() {
		
	}
	
	public void verifyAddSignleProductToCart() {
		SoftAssert  softAssert = new SoftAssert();
				
		ProductCard productCard = productsPage
				.getProductGrid()
				.getProductByName("blue top");
		
		AddToCartModal addToCartModal = productCard
				.clickAddToCart();
		
		Assert.assertTrue(
				addToCartModal.isDisplayed(),
				"AddToCartModal should be displayed"
				);
		softAssert.assertEquals(
				addToCartModal.getAddedTitle(),
				"Your product has been added to cart.",
				"Should diplay Added tile"
				);
		softAssert.assertEquals(
				addToCartModal.getAddedMessage(),
				"Your product has been added to cart.",
				"Should display confimation message"
				);
		
		CartPage cartPage = addToCartModal.viewCart();
		softAssert.assertTrue(
				cartPage.getCartTable().isDisplayed(),
				"CartT table should be displayed");
		softAssert.assertEquals(
				cartPage.getCartTable().getProductCount(), 1,
				"Product count should be 1"
				);
		
		CartRow cartRow = cartPage.getCartTable()
				.getProductByName("blue top");
		softAssert.assertEquals(
				cartRow.getName(),"blue top",
				"Product name should match"
				);
		softAssert.assertEquals(
				cartRow.getQuantity(), 1,
				"Quantity should match"
				);
		
		softAssert.assertAll();
	}
	
	
	public void verifyAddMultipleProductToCard() {
		
	}

}
/*
Purpose: Verify cart functionality from Products page.

TC_009: Add single product to cart

Steps

Navigate to Products page
Select product
Click Add to Cart
Verify confirmation popup

Expected

Product added successfully
TC_010: Add multiple products to cart

Steps

Add Product A
Continue shopping
Add Product B
Open cart

Expected

Both products displayed in cart

*/