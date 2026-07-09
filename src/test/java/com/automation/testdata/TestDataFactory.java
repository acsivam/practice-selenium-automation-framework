package com.automation.testdata;

import com.automation.models.CreditCard;
import com.automation.models.User;

public class TestDataFactory {

	public TestDataFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public static User createValidSignupUser() {
        User user = new User();
        user.setName("John");
        user.setEmail("john" + System.currentTimeMillis() + "@test.com");
        return user;
    }
	
	public static User createExitingSignupUser() {
		User user = new User();
        user.setName("John");
        user.setEmail("john" + System.currentTimeMillis() + "@test.com");
        return user;
	}
	
	public static User createValidLoginCredentials() {
		User user = new User();
		user.setEmail("johnwilliam@gmail.com");
		user.setPassword("Test1234");
		return user;
	}
	
	public static User createValidCreateAccountUser() {
		User user = new User();
		user.setTitle("Mr");
		user.setName("Mark");
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

	
}
