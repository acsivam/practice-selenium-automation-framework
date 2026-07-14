package com.automation.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.components.CartModal;
import com.automation.components.CartRow;
import com.automation.components.CartTable;
import com.automation.components.ProductCard;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductsPage;

//@Test(groups = {"AddToCart"})
public class AddToCartTest extends BaseTest {

	private HomePage homePage;
	private ProductsPage productsPage;
	
	@BeforeMethod(dependsOnMethods = "launchApplication")
	public void addToCartTestSetup() {
		homePage = new HomePage(driver);
		productsPage = 
				homePage.getTopMenu().goToProductsPage();
	}
	
	
	public void verifyAddToCartModalIsShouwn() {
		SoftAssert  softAssert = new SoftAssert();
		
		CartModal addToCartModal = productsPage
				.getProductGrid()
				.getProductByName("Blue Top")
				.clickAddToCart();		
		
		Assert.assertTrue(
				addToCartModal.isDisplayed(), 
				"AddToCartModal should be displayed"
				); 
		softAssert.assertEquals(
				addToCartModal.getAddedTitle(),
				"Added!",
				"Should diplay Added tile"
				);
		softAssert.assertEquals(
				addToCartModal.getAddedMessage(),
				"Your product has been added to cart.",
				"Should display confimation message"
				); 
		softAssert.assertAll();
	}
	
	
	@Test
	public void verifyAddSignleProductToCart() {
		SoftAssert  softAssert = new SoftAssert();
		
		/*
	    ProductCard productCard = productsPage
	            .getProductGrid()
	            .getProductByName("Blue Top");

	    AddToCartModal addToCartModal =
	            productCard.clickAddToCart();
	  
	    CartPage cartPage =
	            addToCartModal.viewCart();
		*/
		
		CartModal addToCartModal= productsPage
				.getProductGrid()
				.getProductByName("Blue Top")
				.clickAddToCart();		
		

		CartPage cartPage = addToCartModal.viewCart();
		
		CartTable cartTable = cartPage.getCartTable();
	
		softAssert.assertTrue(
				cartTable.isDisplayed(),
				"CartT table should be displayed");
		softAssert.assertEquals(
				cartTable.getProductCount(), 1,
				"Product count should be 1"
				);
		
		CartRow cartRow = cartTable.getProductByName("Blue Top");
		
		softAssert.assertEquals(
				cartRow.getName(),"Blue Top",
				"Product name should match"
				);
		softAssert.assertEquals(
				cartRow.getQuantity(), "1",
				"Quantity should match"
				);
	
		softAssert.assertAll();
	}

	
	public void verifyAddMultipleProductToCard() {
		SoftAssert  softAssert = new SoftAssert();
		
		/*	*/
		productsPage.getProductGrid()
				.getProductByName("Blue Top")
				.clickAddToCart()
				.continueShopping();
		
		CartTable cartTable = productsPage.getProductGrid()
				.getProductById("3")
				.clickAddToCart()
				.viewCart()
				.getCartTable();
				
		softAssert.assertEquals(
				cartTable.getProductCount(), 1,
				"Product count should match"
				);
		
		List cartRow = cartTable.getProducts();
		System.out.println(cartRow);
		/*	 Sleeveless Dress "Blue Top"
		cartPage.getCartTable().getProductByName("Blue Top").getName());
		System.out.println(
		cartPage.getCartTable().getProductByName("Blue Top").getPrice());
		cartPage.getCartTable().getProductByName("Blue Top").getQuantity();
		System.out.println(
		cartPage.getCartTable().getProducts());
		*/
	

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