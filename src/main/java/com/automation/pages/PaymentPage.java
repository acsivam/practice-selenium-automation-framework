package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CreditCardForm;
import com.automation.constants.AppConstants;

public class PaymentPage extends BasePage {

    private CreditCardForm creditCardForm;

    public PaymentPage(WebDriver driver) {
        super(driver);
        this.creditCardForm = new CreditCardForm(driver);
    }

    private By paymentContainer =	By.id("cart_items");
    
    
    public CreditCardForm getCreditCardForm() {
        return creditCardForm;
    }
    
    public boolean isPaymentContainerDisplayed() {
    	return eleUtil.isDisplayed(paymentContainer);
    }
    
    public boolean isLoaded() {
    	return getCurrentUrl().contains(AppConstants.PAYMENT_PAGE_PATH)
    			&& isPaymentContainerDisplayed();
    }
}

