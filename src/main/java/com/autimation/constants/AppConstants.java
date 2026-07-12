package com.autimation.constants;

public class AppConstants {
	
	private AppConstants() {}

	// ******** Framework Constants // ********
	public static final int DEFAULT_TIMEOUT = 5; 
	public static final int DEFAULT_EXPLICIT_WAIT = 1;
	
	// ********PAGE CONSTANTS********************
	public static final String ACCOUNT_CREATED_PAGE_TITLE = "Automation Exercise - Account Created" ; 
	public static final String ACCOUNT_CREATED_PAGE_PATH = "/account_created" ; 
	public static final String ACCOUNT_CREATED_PAGE_HEADING = "ACCOUNT CREATED!" ;
	
	public static final String ACCOUNT_DELETED_PAGE_TITLE = "Automation Exercise - Account Created" ; 
	public static final String ACCOUNT_DELETED_PAGE_PATH = "/delete_account" ; 
	public static final String ACCOUNT_DELETED_PAGE_HEADING = "ACCOUNT DELETED!" ;
	
	public static final String BRAND_PRODUCT_PAGE_TITLE = "Automation Exercise - " ; 
	public static final String BRAND_PRODUCT_PAGE_PATH = "/brand_products" ; 
	// public static final String BRAND_PRODUCT_PAGE_HEADING = "" ;
	
	public static final String CART_PAGE_TITLE = "Automation Exercise - Checkout" ; 
	public static final String CART_PAGE_PATH = "/view_cart" ; 
	public static final String CART_PAGE_HEADING = "" ;
	
	public static final String CATEGORY_PRODUCTS_PAGE_TITLE = "Automation Exercise - " ; 
	public static final String CATEGORY_PRODUCTS_PAGE_PATH = "/category_products/" ; 
	// public static final String CATEGORY_PRODUCTS_PAGE_HEADING = "" ;
	
	public static final String CHECKOUT_PAGE_TITLE = "Automation Exercise - Checkout" ; 
	public static final String CHECKOUT_PAGE_PATH = "/checkout" ; 
	public static final String CHECKOUT_PAGE_HEADING = "" ;
	
	public static final String CONTACT_US_PAGE_TITLE = "Automation Exercise - Contact Us" ; 
	public static final String CONTACT_US_PAGE_PATH = "/contact_us" ; 
	public static final String CONTACT_US_PAGE_HEADING = "" ;
	
	public static final String HOME_PAGE_TITLE = "Automation Exercise";
	public static final String HOME_PAGE_PATH = "/" ; 
	public static final String HOME_PAGE_HEADING = "" ;
	
	public static final String LOGIN_PAGE_TITLE = "Automation Exercise - Signup / Login" ; 
	public static final String LOGIN_PAGE_PATH = "/login" ; 
	public static final String LOGIN_PAGE_HEADING = "" ;
	
	public static final String PAYMENT_CONFIRMATION_PAGE_TITLE = "Automation Exercise - Order Placed" ; 
	public static final String PAYMENT_CONFIRMATION_PAGE_PATH = "/payment_done/" ; 
	public static final String PAYMENT_CONFIRMATION_PAGE_HEADING = "" ;
	
	public static final String PAYMENT_PAGE_TITLE = "Automation Exercise - Payment" ; 
	public static final String PAYMENT_PAGE_PATH = "/payment" ; 
	public static final String PAYMENT_PAGE_HEADING = "" ;
	
	public static final String PRODUCT_DETAILS_PAGE_TITLE = "Automation Exercise - " ; 
	public static final String PRODUCT_DETAILS_PAGE_PATH = "/product_details/" ; 
	public static final String PRODUCT_DETAILS_PAGE_HEADING = "" ;
	
	public static final String PRODUCTS_PAGE_TITLE = "Automation Exercise - All Products" ; 
	public static final String PRODUCTS_PAGE_PATH = "/products" ; 
	public static final String PRODUCTS_PAGE_HEADING = "ALL PRODUCTS" ;
	
	public static final String SIGNUP_PAGE_TITLE = "Automation Exercise - Signup" ; 
	public static final String SIGNUP_PAGE_PATH = "/signup" ; 
	public static final String SIGNUP_PAGE_HEADING = "" ;
	
	public static final String TESTCASES_PAGE_TITLE = "Automation Practice Website for UI Testing - Test Cases" ; 
	public static final String TESTCASES_PAGE_PATH = "/test_cases" ;
	public static final String TESTCASES_PAGE_HEADING = "TEST CASES" ;
	
	
	// ******** COMP ***********
	public static final String BRAND_PANEL_HEADING = "BRANDS" ;
	public static final String CATEGORY_PANEL_HEADING = "CATEGORY" ;
	
	public static final String ALL_PRODUCTS_HEADING = "ALL PRODUCTS";
	public static final String BRAND_PRODUCTS_PREFIX = "BRANDS - ";
	public static final String BRAND_CATEGOTY_PRODUCTS_SUFFIX = " PRODUCTS";
	public static final String CATEGORY_PRODUCTS_HEADING = "%s - %s - PRODUCTS" ;
	public static final String FEATURED_ITEMS_HEADING = "FEATURED ITEMS";

	
	/*
	String expected = String.format(
        AppConstants.CATEGORY_HEADING,
        brandName,
        category
		);
	*/
	
	public static String getBrandProductsHeading(String brandName) {
        return String.format(CATEGORY_PRODUCTS_HEADING, brandName.toUpperCase());
	}
}
