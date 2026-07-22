package com.automation.testdata;

import com.automation.models.CreditCard;

public class TestPaymentBuilder {
	
	private String cardHolder;
	private String cardNumber;
	private String expiryMonth;
	private String expiryYear;
	private String cvc;
	
	
	public static TestPaymentBuilder from(CreditCard card) {
		TestPaymentBuilder builder = new TestPaymentBuilder();
		
		builder.cardHolder = card.getName();
		builder.cardNumber = card.getNumber();
		builder.expiryMonth = card.getMonth();
		builder.expiryYear = card.getYear();
		builder.cvc = card.getCvc();
		return builder;
		
	}
	
	public TestPaymentBuilder withCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	    return this;
	}
	 
	public TestPaymentBuilder withCardNumber(String cardNumber) {
	    this.cardNumber = cardNumber;
	    return this;
	}

	public TestPaymentBuilder withExpiryMonth(String expiry) {
	     this.expiryMonth = expiry;
	     return this;
	}
	    
	public TestPaymentBuilder withExpiryYear(String expiry) {
	    this.expiryYear = expiry;
	    return this;
	}

	public TestPaymentBuilder withCvv(String cvc) {
	    this.cvc = cvc;
	    return this;
	}
	    
	public CreditCard build() {
        return new CreditCard(
        		cardHolder,
	            cardNumber,
	            expiryMonth,
	            expiryYear,
	            cvc
	        	);
	    }	
}
