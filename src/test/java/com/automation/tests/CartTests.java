package com.automation.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.assertions.CartAssertions;
import com.automation.assertions.CartModalAssertions;
import com.automation.base.BaseTest;
import com.automation.components.CartModal;
import com.automation.components.CartTable;
import com.automation.models.CartItem;
import com.automation.models.Product;
import com.automation.pages.CartPage;
import com.automation.pages.HomePage;
import com.automation.testdata.TestDataFactory;




public class CartTests extends BaseTest{
	
	private HomePage homePage;
	
	@BeforeMethod
	public void cartTestsetup() {
		homePage = new HomePage(driver);
	}
	
	@Test
	public void shouldDisplayEmptyCartWhenNoProductsAdded() {
		
		CartPage cartPage = homePage
				.getTopMenu()
				.goToCartPage();
		
		CartAssertions.verifyThat(cartPage).isCartEmpty();
		
	}

	@Test
	public void shouldAddSingleProductToCart() throws InterruptedException {
		Product blueTop = TestDataFactory.bluetop();
		CartItem expectedItem = new CartItem(blueTop, 1);
		
		CartModal cartModal = homePage
				.getProductGrid()
				.getProductByName(blueTop.getName())
				.clickAddToCart();
		
		Assert.assertTrue(
			    cartModal.isDisplayed(),
			    "Add to cart modal did not appear"
			);
		
		CartModalAssertions.verifyThat(
			    cartModal).isDisplayed();

		CartTable cartTable = cartModal.viewCart().getCartTable();
	
		
		Thread.sleep(100);
		CartAssertions.verifyThat(cartTable)
				.hasProduct(expectedItem);	
				
				/**/
	}

	public void shouldAddMultipleProductsToCart() {}

	public void shouldVerifyProductDetailsInCart() {}

	public void shouldUpdatesProductQuantityInCart() {}

	public void shouldRemoveProductFromCart() {}

	public void shouldCalculateCartTotalCorrectly() {}

	public void shouldIncreaseQuantityWhenSameProductAddedTwice() {}

	public void shouldRetainCartAfterLogin() {}
}
