package com.automation.pages;

import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CreditCardForm;

public class PaymentPage extends BasePage {

    private CreditCardForm creditCardForm;

    public PaymentPage(WebDriver driver) {
        super(driver);
        this.creditCardForm = new CreditCardForm(driver);
    }

    public CreditCardForm getCreditCardForm() {
        return creditCardForm;
    }
}

