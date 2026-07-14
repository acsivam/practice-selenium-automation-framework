package com.automation.tests;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.components.AddToCartModal;
import com.automation.components.CheckoutModal;
import com.automation.pages.AccountCreatedPage;
import com.automation.pages.AccountDeletedPage;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.PaymentConfimationPage;
import com.automation.pages.PaymentPage;
import com.automation.pages.SignupPage;

public class TC14_PlaceOrderRegisterWhileCheckout extends BaseTest {
	/*/
	@Test
	public void verifyUserCanRegisteWhileCheckout() {
		SoftAssert softAssert = new SoftAssert();
		String actualResults;

		HomePage homePage = new HomePage(driver);
		actualResults = homePage.getPageTitle();
		softAssert.assertEquals(actualResults, "Automation Exercise");
		
		AddToCartModal addToCartPage = homePage.clickAddToCartByProductId("3");
		CartPage cartPage = addToCartPage.viewCart();
		CheckoutModal checkoutModal = cartPage.proceedToCheckoutAsGuest();
		LoginPage loginPage = checkoutModal.clickRegisterLogin();
		
		SignupPage signupPage = loginPage.signup("Mark", "mark123@gmail.com");
		AccountCreatedPage accountCreatedPage =signupPage.createAccount(
				"MarK", 
				"pass123", 
				"8", 
				"May",
				"1999",
				true, 
				false, 
				"Mark", 
				"William", 
				"Yates Pvt Ltd", 
				"Main Road", 
				"Address line 2", 
				"India", 
				"State", 
				"City", 
				"1234", 
				"12345566");
		actualResults = accountCreatedPage.getAccountCreatedHeading();
		softAssert.assertEquals(actualResults, "ACCOUNT CREATED!");
		
		homePage = accountCreatedPage.clickContinue();
		
		boolean value = homePage.getTopMenu().isLoginAsDisplayed();
		softAssert.assertEquals(value, true); 
		
		cartPage = homePage.getTopMenu().goToCartPage();
		CheckoutPage checkoutPage = cartPage.proceedToCheckoutAsLoggedInUser();
		List<String> deliveryAddress = checkoutPage.getDelliveryAddress();
		System.out.println(deliveryAddress);
		
		checkoutPage.enterMessage("Test Order");
		PaymentPage paymentPage = checkoutPage.placeOder();
		paymentPage.isPaymentHeadingDisplayed();
		PaymentConfimationPage paymentConfirmationPage = 
				paymentPage.fillPyamentDetails("Mark", "4929768900837248", "123", "09", "2030");
		
		AccountDeletedPage accountDeletedPage = paymentConfirmationPage.getTopMenu().deleteAccount();		
		actualResults = accountDeletedPage.getAccountDeletedHeading();
		softAssert.assertEquals(actualResults, "ACCOUNT DELETED!");
		
		softAssert.assertAll();
		/*
		paymentPage.enterName("John");
		paymentPage.enterCardnumber("4929768900837248");
		paymentPage.enterCVC("123");
		paymentPage.enterExpirationMonth("09");
		paymentPage.enterExpirationYear("2030");
		actualResults = paymentPage.clickPay();
		//
		
		//System.out.println(actualResults);
		//PaymentConfimationPage paymentConfirmationPage = paymentPage.waitForPaymentConfirmationPage();
		
	}
*/
}
