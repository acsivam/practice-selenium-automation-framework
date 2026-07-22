package com.automation.testdata;

import java.util.ArrayList;
import java.util.List;

import com.automation.models.CartItem;
import com.automation.models.CreditCard;
import com.automation.models.Product;
import com.automation.models.User;

public class TestDataFactory {

	public TestDataFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static User validSignupUser() {
        User user = new User();
        user.setName("John");
        user.setEmail("john" + System.currentTimeMillis() + "@test.com");
        return user;
    }
	
	public static User exitingSignupUser() {
		User user = new User();
        user.setName("John");
        user.setEmail("johnwilliam@gmail.com");
        return user;
	}
	
	public static User validLoginCredentials() {
		User user = new User();
		user.setEmail("johnwilliam@gmail.com");
		user.setPassword("Test1234");
		return user;
	}
	
	public static User validCreateAccountUser() {
		User user = new User();
		user.setTitle("Mr");
		user.setName("Mark");
		user.setEmail("john" + System.currentTimeMillis() + "@test.com");
		user.setPassword("pass1234");
		user.setDay("19");
		user.setMonth("August");
		user.setYear("1999");
		user.setNewsletter(true);
		user.setSpecialOffers(true);
		user.setFirstName("Mark");
		user.setLastName("William");
		user.setCompany("Baur && Company");
		user.setAddress1("Main Road");
		user.setAddress2("Galaxy Path");
		user.setCountry("India");
		user.setState("HYD");
		user.setCity("Hydrabad");
		user.setZipcode("1234");
		user.setMobile("12345678");
		return user;
	}
	
	public static CreditCard createValidVisaCard() {
		CreditCard visaCard = new CreditCard();
		visaCard.setName("John");
		visaCard.setNumber("4929768900837248");
		visaCard.setCvc("123");
		visaCard.setMonth("09");
		visaCard.setYear("2035");
		return visaCard;
	}
	
	public static CreditCard createValidMasterCard() {
		CreditCard masterCard = new CreditCard();
		masterCard.setName("John");
		masterCard.setNumber("5307732125531191");
		masterCard.setCvc("123");
		masterCard.setMonth("09");
		masterCard.setYear("2035");
		return masterCard;
	}

	public static CreditCard createInsufficientFundsCard() {
		CreditCard insufficientFundCard = new CreditCard();
		insufficientFundCard.setName("John");
		insufficientFundCard.setNumber("4024007194349121"); //Visa
		insufficientFundCard.setCvc("123");
		insufficientFundCard.setMonth("09");
		insufficientFundCard.setYear("2035");
		return insufficientFundCard;
	}
	
	public static CreditCard createLimitExceededCard() {
		CreditCard limitExceededCard = new CreditCard();
		limitExceededCard.setName("John");
		limitExceededCard.setNumber("4929119799365646"); //Visa
		limitExceededCard.setCvc("123");
		limitExceededCard.setMonth("09");
		limitExceededCard.setYear("2035");
		return limitExceededCard;
	}
	
	public static CreditCard createNetworkErrorCard() {
		CreditCard networkError = new CreditCard();
		networkError.setNumber("4024007120869333"); //Visa
		networkError.setCvc("123");
		networkError.setMonth("09");
		networkError.setYear("2035");
		return networkError;
	}
	
	//
	public static List<Product> createProducts(){
		List<Product> products = new ArrayList<>();
		
		Product bluetop = new Product();
		bluetop.setAvailability("In Stock");
		bluetop.setBrand("Polo");
		bluetop.setCategory("Women");
		bluetop.setCondition("New");
		bluetop.setName("Blue Top");
		//	bluetop.setPrice("Rs. 500");
		bluetop.setProductId("1");
		//bluetop.setQuantity("1");
		bluetop.setSubCategory("Tops");
		
		products.add(bluetop);
		
		Product sleeveless = new Product();
		sleeveless.setAvailability("In Stock");
		sleeveless.setBrand("Madame");
		sleeveless.setCategory("Women");
		sleeveless.setCondition("New");
		sleeveless.setName("Sleeveless Dress");
		//	sleeveless.setPrice("Rs. 1000");
		sleeveless.setProductId("3");
		//sleeveless.setQuantity("1");
		sleeveless.setSubCategory("Dress");
		
		products.add(sleeveless);
		
		Product tshirt = new Product();
		tshirt.setAvailability("In Stock");
		tshirt.setBrand("H&M");
		tshirt.setCategory("Men");
		tshirt.setCondition("New");
		tshirt.setName("Men Tshirt");
		//	tshirt.setPrice("Rs. 400");
		tshirt.setProductId("2");
		//tshirt.setQuantity("1");
		tshirt.setSubCategory("Tshirts");
		
		products.add(tshirt);
		
		return products;
	}
	
	public static Product createAddToCartProductBlueTop() {
		Product product = new Product();	
		product.setProductId("1");
		product.setName("Blue Top");
		product.setCategory("Women");
		product.setSubCategory("Top");
		//	product.setPrice("Rs. 500");
		return product;
	}
	
	public static Product createAddToCartProductId3() {
		Product product = new Product();	
		product.setProductId("3");
		product.setName("Sleeveless Dress");
		product.setCategory("Women");
		product.setSubCategory("Dress");
		//	product.setPrice("Rs. 1000");
		return product;
	}
		
	//
	public static List<CartItem> getCartItem() {
		List<CartItem> cartItems = new ArrayList<>();
		
		CartItem blueTop = new CartItem();
		//blueTop.setProductName("Blue Top");
		//blueTop.setCategory("Women > Tops");
		//blueTop.setPrice("Rs. 500");
		//blueTop.setQuantity(1);
		//blueTop.setTotal("Rs. 500");
		
		cartItems.add(blueTop);
		
		return cartItems;
	}
	
	public static List<CartItem> getCartItems() {
		List<CartItem> cartItems = new ArrayList<>();
		
		CartItem blueTop = new CartItem();
		//blueTop.setProductName("Blue Top");
		//blueTop.setCategory("Women > Tops");
		//blueTop.setPrice("Rs. 500");
		//blueTop.setQuantity(2);
		//blueTop.setTotal("Rs. 1000");
		
		cartItems.add(blueTop);
		
		CartItem sleeveless = new CartItem();
		//sleeveless.setProductName("Sleeveless Dress");
		//sleeveless.setCategory("Women > Dress");
		//sleeveless.setPrice("Rs. 1000");
		//sleeveless.setQuantity(1);
		//sleeveless.setTotal("Rs. 1000");
		
		cartItems.add(sleeveless);
		
		return cartItems;
	}
	
	//------------------------------------------------------------------
	public static User newUser() {
		
		return new User(
				"Mr", "John", "john.william" + System.currentTimeMillis() + "@yahoo.com", "pass1234", 
				"8", "August", "1999", 
				true, false, "John", "William", "Boring & Company", 
				"120 Main Road", "Galaxy Gateway", "India", 
				"ABC State", "C City", "AB 1234", "777123456");
	}
	
	
	public static User existingUser() {
		
		return new User("Mr", "John", "johnwilliam@gmail.com", "Test1234", 
				"8", "August", "1999", 
				true, false, "John", "William", "Boring & Company", 
				"120 Main Road", "Galaxy Gateway", "Australia", 
				"ABC State", "C City", "AB 1234", "777123456");

	}
	
	public static User checkoutUser() {
		
		return new User("Mr", "Mark", "mark.william@gmail.com", "Test1234", 
				"8", "August", "1999", 
				true, false, "Mark", "William", "Boring & Company", 
				"120 Main Road", "Galaxy Gateway", "Australia", 
				"ABC State", "C City", "AB 1234", "777123456");

	}
	
	public static User paymentUser() {
		
		return new User("Mr", "Nathan", "nathan.william@gmail.com", "Test1234", 
				"8", "August", "1999", 
				true, false, "Nathan", "William", "Boring & Company", 
				"120 Main Road", "Galaxy Gateway", "Australia", 
				"ABC State", "C City", "AB 1234", "777123456");

	}
	
	
	public static User checoutUser01() {
		
		return new User("Mr", "George", "george.william@gmail.com", "Test1234", 
				"8", "August", "1999", 
				true, false, "George", "William", "Boring & Company", 
				"120 Main Road", "Galaxy Gateway", "Australia", 
				"ABC State", "C City", "AB 1234", "777123456");

	}
	
	public static User checoutUser02() {
		
		return new User("Mr", "Louise", "louise.william@gmail.com", "Test1234", 
				"8", "August", "1999", 
				true, false, "Louise", "William", "Boring & Company", 
				"120 Main Road", "Galaxy Gateway", "Australia", 
				"ABC State", "C City", "AB 1234", "777123456");

	}
	/*
			return new User("Mr", "John", "johnwilliam@yahoo.com", "Test1234", 
				"8", "August", "1999", 
				true, false, "John", "William", "Harbour", 
				"Main Road", "Highway", "Australia", 
				"WA", "Perth", "1234", "23432423");
	} */
	//------------------------------------------------------------------
	
	public static Product bluetop() {
		return new Product(
				"1", "Blue Top", "Women", "Tops", "Polo", 500, "In Stock", "New");
	}
	
	public static Product mensTshirt() {
		return new Product(
				"2", "Men Tshirt", "Men", "Tshirts", "H&M", 400, "In Stock", "New");
	}
	
	public static Product sleevelessDress() {
		return new Product(
				"3", "Sleeveless Dress", "Women", "Dress", "Madame", 1000, "In Stock", "New");
	}
	
	
	public static Product stylishDress() {
		return new Product(
				"4", "Stylish Dress", "Women", "Dress", "Madame", 1500, "In Stock", "New");
	}
	
	public static Product nonExisting() {
		return new Product(
				"99", "Blazer", "Women", "Dress", "Madame", 1000, "In Stock", "New");
	}
	//------------------------------------------------------------------
}

//
