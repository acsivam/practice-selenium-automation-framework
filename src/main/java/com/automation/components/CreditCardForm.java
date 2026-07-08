package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    public void enterCardDetails(String name, String number,
                                 String cvcValue,
                                 String month,
                                 String year) {

        eleUtil.enterText(nameOnCard, name);
        eleUtil.enterText(cardNumber, number);
        eleUtil.enterText(cvc, cvcValue);
        eleUtil.enterText(expiryMonth, month);
        eleUtil.enterText(expiryYear, year);
    }

    public void submitPayment() {
        eleUtil.click(payButton);
    }
}
