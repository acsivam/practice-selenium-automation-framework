package com.automation.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.assertions.CartAssertions;
import com.automation.assertions.CartModalAssertions;
import com.automation.base.BaseTest;
import com.automation.components.CartModal;
import com.automation.components.CartRow;
import com.automation.components.CartTable;
import com.automation.models.CartItem;
import com.automation.models.Product;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.pages.ProductsPage;
import com.automation.testdata.TestDataFactory;

@Test(groups = {"AddToCart"})
public class AddToCartTest extends BaseTest {
 
	private HomePage homePage;
	private ProductsPage productsPage;
	
	
	@BeforeMethod(dependsOnMethods = "launchApplication")
	public void addToCartTestSetup() {
		homePage = new HomePage(driver);
		productsPage = homePage
				.getTopMenu()
				.goToProductsPage();
		logger.info("addToCartTestSetup()");
	}
	
	// Add -- Act -- Assert 		/**/
	public void shouldDisplayCartModalAfterAddingProduct() {
		
		CartModal cartModal = 
				productsPage.getProductGrid()
				.getProductByName("Blue Top")
				.clickAddToCart();		
		
		CartModalAssertions cartModalAssert = new CartModalAssertions(cartModal);
		cartModalAssert.hasDefaultCartModal();
	}
	
	
	public void shouldAddSingleProductToCartFromProductsPage() throws InterruptedException {
		// Test data
		Product blueTop = TestDataFactory.bluetop();
		CartItem expectedItem = new CartItem (blueTop,1);//
		
		
		// Steps
		CartTable cartTable = productsPage
				.getProductGrid()
				.getProductByName(blueTop.getName())
				.clickAddToCart()
				.viewCart()
				.getCartTable();
		
		
		// Validation 
		CartAssertions cartAssertions = new CartAssertions(cartTable);
		cartAssertions.hasProduct(expectedItem);
	}
	
	
	public void shouldAddMultipleProductsFromProductsPage() {
		// Test Data
		Product mensTshirt = TestDataFactory.mensTshirt();
		Product sleevelessDress = TestDataFactory.sleevelessDress();
		List<CartItem> expectedCartItems = List.of(
		        new CartItem(mensTshirt, 1),
		        new CartItem(sleevelessDress, 1)
		);
		
				
		productsPage
			.getProductGrid()
			.getProductByName(mensTshirt.getName())
			.clickAddToCart()
			.continueShopping();
		
		CartTable cartTable = productsPage
				.getProductGrid()
				.getProductById(sleevelessDress.getProductId())
				.clickAddToCart()
				.viewCart()
				.getCartTable();
		
		CartAssertions.verifyThat(cartTable)
			.hasProducts(expectedCartItems);
	}
	
	/*	
	public void verifySingleProductAddedToCart() { 
		SoftAssert  softAssert = new SoftAssert();
			*//*
		CartPage cartPage = 
				productsPage.getProductGrid()
					.getProductByName("Blue Top")
					.clickAddToCart()
					.viewCart();
		
		CartTable cartTable = 
				cartPage.getCartTable();
		
		softAssert.assertEquals(
				cartTable.getProductCount(), 1,
				"Number of products in the cart should match products added to the cart");
		softAssert.assertEquals(
				cartTable.getCartRows().get(0).getName(), "Blue Top",
				"Product in cart should be same as product added"
				);
		softAssert.assertEquals(
				cartTable.getProductByName("Blue Top").getQuantity(), "1",
				"Quantities of the product in the art should match the quantities added"
				);
		
		softAssert.assertAll();
	}*/
	
	
	public void verifyCart() {
		SoftAssert  softAssert = new SoftAssert();
		/*	
		Product blueTop = TestDataFactory.bluetop();
		List<CartItem> expectedCartItems = List.of(
		        new CartItem(blueTop, 1));

		List<Product> actualProducts =
				productsPage.getProductGrid()
						.getProductByName(blueTop.getName())
						.clickAddToCart()
						.viewCart()
						.getCartTable()
						.getProducts();
		
		softAssert.assertEquals(actualProducts.size(), 1);
		softAssert.assertEquals(actualProducts.get(0).getName(), product.getName());
		
		softAssert.assertAll();
			*/	
	}
	
	
	public void verifyMultipleProductsAddedToCard() {
		SoftAssert  softAssert = new SoftAssert();
		/*	*/
		Product blueTop = TestDataFactory.bluetop();
	
		
		productsPage.getProductGrid()
				.getProductByName("Blue Top")
				.clickAddToCart()
				.continueShopping();
		
		productsPage.getProductGrid()
				.getProductById("3")
				.clickAddToCart()
				.continueShopping();
		
		CartPage cartPage = 
				productsPage.getProductGrid()
				.getProductByName("Blue Top")
				.clickAddToCart()
				.viewCart(); //navigating to cart from Cart modal
				
		CartTable cartTable = 
				cartPage.getCartTable();			
		softAssert.assertEquals(
				cartTable.getProductCount(), 2,
				"Product count should match"
				);
		
		List<String> actualNames = new ArrayList<>();

		for (CartRow row : cartTable.getCartRows()) {
		    actualNames.add(row.getName());
		}

		List<String> expectedNames =
		        List.of("Blue Top", "Men Tshirt");
		softAssert.assertEquals(actualNames, expectedNames);				
		
		softAssert.assertEquals(
				cartTable.getProductByName("Blue Top").getQuantity(), 2,
				"Quantity should match"
				);	
	}

}