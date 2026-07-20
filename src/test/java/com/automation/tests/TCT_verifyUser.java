package com.automation.tests;

public class TCT_verifyUser {

	/*
	
Authentication
shouldRegisterNewUserSuccessfully
	Register → Verify logged in → Delete account
shouldLoginWithValidCredentials
	Login → Verify username → Logout
shouldDeleteAccountAfterLogin
	Login → Delete account → Verify account deleted

Shopping
shouldPurchaseSingleProductAsNewUser
	Register
	Add one product
	Checkout
	Payment
	Verify order placed
	Delete account
shouldPurchaseSingleProductAsExistingUser
	Login
	Add product
	Checkout
	Payment
	Logout
shouldPurchaseMultipleProducts
	Login
	Add multiple products
	Verify cart
	Checkout
	Payment
shouldPurchaseProductFromProductDetailsPage
	Login
	Open product details
	Change quantity
	Add to cart
	Checkout
	Payment

Search & Purchase
shouldSearchProductAndPurchase
	Login
	Search product
	Verify results
	Add searched product
	Checkout
	Payment
shouldPurchaseProductFromCategoryPage
	Login
	Browse category
	Add product
	Checkout
	Payment
shouldPurchaseProductFromBrandPage
	Login
	Select brand
	Add product
	Checkout
	Payment

Cart Management
shouldUpdateCartBeforeCheckout
	Login
	Add multiple products
	Remove one
	Verify totals
	Checkout
	Payment
shouldContinueShoppingBeforeCheckout
	Add first product
	Continue Shopping
	Add second product
	Verify both products
	Checkout
shouldRemoveProductBeforeCheckout
	Add product
	Remove it
	Verify empty cart
	Guest User
shouldPromptGuestUserToLoginDuringCheckout
	Add product
	Checkout
	Verify login/signup prompt
shouldRegisterDuringCheckoutAndCompletePurchase
	Add product
	Checkout
	Register
	Complete payment
	Existing Customer
shouldPlaceMultipleOrdersInSeparateSessions
	Login
	Purchase product
	Logout
	Login again
	Purchase another product
shouldRetainCartAfterLogin
	Add product as guest
	Login
	Verify cart is retained
	Checkout
	Contact & Subscription
shouldSubmitContactUsFormSuccessfully
	Fill contact form
	Upload file
	Submit
	Verify success message
shouldSubscribeFromHomePage
	Enter email
	Subscribe
	Verify success message
shouldSubscribeFromCartPage
	Open cart
	Subscribe
	Verify success message
	
	
	 */
}
