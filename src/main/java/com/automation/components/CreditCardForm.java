package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.models.CreditCard;


public class CreditCardForm extends BaseComponent {

    private By nameOnCard 	= By.cssSelector("[data-qa='name-on-card']");
    private By cardNumber 	= By.cssSelector("[data-qa='card-number']");
    private By cvc 			= By.cssSelector("[data-qa='cvc']");
    private By expiryMonth 	= By.cssSelector("[data-qa='expiry-month']");
    private By expiryYear 	= By.cssSelector("[data-qa='expiry-year']");
    private By payButton 	= By.cssSelector("[data-qa='pay-button']");

    
    public CreditCardForm(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
    	eleUtil.enterText(nameOnCard, name);
    }
    
    public void enterCardNumber(String number) {
    	 eleUtil.enterText(cardNumber, number);
    }
    
    public void enterCVC(String cvcValue) {
    	 eleUtil.enterText(cvc, cvcValue);
    }
    
    public void enterExpiryMonth(String month) {
    	 eleUtil.enterText(expiryMonth, month);
    }
    
    public void enterExpiryYear(String year) {
    	eleUtil.enterText(expiryYear, year);
    }
    
    public void enterCardDetails(CreditCard card) {
    	enterName(card.getName());
    	enterCardNumber(card.getNumber());
    	enterCVC(card.getCvc());
    	enterExpiryMonth(card.getMonth());
    	enterExpiryYear(card.getYear());
    }

    public void submitPayment() {
        eleUtil.click(payButton);
    }
}
