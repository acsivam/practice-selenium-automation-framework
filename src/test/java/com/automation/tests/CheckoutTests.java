package com.automation.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automation.assertions.AddressAssertions;
import com.automation.assertions.CartAssertions;
import com.automation.assertions.CheckoutAssertions;

//import org.openqa.selenium.devtools.v127.autofill.model.CreditCard;

import com.automation.base.BaseTest;
import com.automation.components.BillingAddress;
import com.automation.components.CartTable;
import com.automation.components.DeliveryAddress;
import com.automation.constants.AppConstants;
import com.automation.models.CartItem;
import com.automation.models.Product;
import com.automation.models.User;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.PaymentPage;
import com.automation.testdata.TestDataFactory;

@Test(groups = {"Checkout"})
public class CheckoutTests extends BaseTest{
	
	private HomePage homePage;
	@BeforeMethod
	public void checkoutTestSetup() {		 
		homePage = new HomePage(driver);
	}
	
	
	private HomePage login(User user) {
		return homePage
				.getTopMenu()
				.goToLoginPage()
				.getLoginForm()
				.login(user);
	}
	
	
	private CartPage clearCart() {
		return homePage
				.getTopMenu()
				.goToCartPage()
				.clearCart();
	}
	
	public void shouldVerifyDeliveryAddressOnCheckoutPage() {
		Product blueTop = TestDataFactory.bluetop();		
		User user = TestDataFactory.checkoutUser();
		String expectedHeader = "YOUR DELIVERY ADDRESS";
		
		login(user);
		clearCart();
		
		DeliveryAddress deliveryAdd = new CartPage (driver)
				.getEmptyCart()
				.clickBuyProducts()
				.getProductGrid()
				.getProductByName(blueTop.getName())
				.clickAddToCart()
				.viewCart()
				.proceedToCheckoutAsLoggedInUser()
				.getCheckoutInformation()
				.getDeliveryAddress();
		
		AddressAssertions
				.verifyThat(deliveryAdd)
				.hasHeader(expectedHeader)
				.hasDefaultAddressInfo(user);
	}

	public void shouldVerifyBillingAddressOnCheckoutPage() {
		Product blueTop = TestDataFactory.bluetop();		
		User user = TestDataFactory.checoutUser01();
		String expectedHeader = "YOUR BILLING ADDRESS";
		
		
		login(user);
		clearCart();
		
		BillingAddress billingAdd = new CartPage(driver)
				.getEmptyCart()
				.clickBuyProducts()
				.getProductGrid()
				.getProductByName(blueTop.getName())
				.clickAddToCart()
				.viewCart()
				.proceedToCheckoutAsLoggedInUser()
				.getCheckoutInformation()
				.getBillingAddress();
		
		AddressAssertions
				.verifyThat(billingAdd)
				.hasHeader(expectedHeader)
				.hasDefaultAddressInfo(user);
	}
	
	
	public void shouldVerifyCartDetailsBeforePlacingOrder() {
		
		Product blueTop = TestDataFactory.bluetop();
		CartItem item = new CartItem(blueTop, 1);
		User user = TestDataFactory.checoutUser02();
		List<String> expectedHeaders = List.of(
				"Item", "Description", "Price", "Quantity", "Total");
		String grandTotal = "Rs. 500";
		
		login(user);
		clearCart();
		
		CartTable cart = new CartPage(driver)
				.getEmptyCart()
				.clickBuyProducts()
				.getProductGrid()
				.getProductByName(blueTop.getName())
				.clickAddToCart()
				.viewCart()
				.proceedToCheckoutAsLoggedInUser()
				.getCartTable();
				
		CartAssertions
				.verifyThat(cart)
				.hasTableHeaders(expectedHeaders)
				.hasProduct(item)
				.hasGrandTotal(grandTotal);		
	}
	
	
	public void shouldAddOrderCommentSuccessfully() {
		Product blueTop = TestDataFactory.bluetop();	
		User user = TestDataFactory.existingUser();
		String orderComment = "Please deliver during business hours.";
		
		
		login(user);
		clearCart();
		
		CheckoutPage chheckoutPage = new CartPage(driver)	
				.getEmptyCart()
				.clickBuyProducts()
				.getProductGrid()
				.getProductByName(blueTop.getName())
				.clickAddToCart()
				.viewCart()
				.proceedToCheckoutAsLoggedInUser();
		
		chheckoutPage.getOrderCommentSection()
				.enterComment(orderComment);
		
		CheckoutAssertions
				.verifyThat(chheckoutPage)
				.hasComment(orderComment);
	}
	
	
	public void shouldNavigateToPaymentPageAfterPlacingOrder(){
		Product blueTop = TestDataFactory.bluetop();	
		User user = TestDataFactory.paymentUser();		
		
		login(user);
		clearCart();
		
		PaymentPage paymentPage =  new CartPage(driver)	
				.getEmptyCart()
				.clickBuyProducts()
				.getProductGrid()
				.getProductByName(blueTop.getName())
				.clickAddToCart()
				.viewCart()
				.proceedToCheckoutAsLoggedInUser()
				.placeOder();
		
		Assert.assertTrue(paymentPage.isLoaded());
	}
	
	
	@AfterMethod
	public void cleanup() {
		driver.get(AppConstants.BASE_URL);
		clearCart();
	}
}
