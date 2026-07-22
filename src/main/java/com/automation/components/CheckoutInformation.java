package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;

public class CheckoutInformation extends BaseComponent {

	private DeliveryAddress deliveryAddress;
	private BillingAddress billingAddress;
	
    public CheckoutInformation(WebDriver driver) {
        super(driver);
        
        this.deliveryAddress = new DeliveryAddress(driver);
        this.billingAddress  = new BillingAddress(driver);
    }

    private By checkoutInfoContainer	= By.cssSelector("[data-qa='checkout-info']");

    @Override 
    public boolean isDisplayed() {
    	return eleUtil.waitForVisibility(checkoutInfoContainer).isDisplayed();
    }
    
    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }


    public BillingAddress getBillingAddress() {
        return billingAddress;
    }
}
