package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;

public class CheckoutInformation extends BaseComponent {

	private DeliveryAddressComponent deliveryAddress;
	private BillingAddressComponent billingAddress;
	
    public CheckoutInformation(WebDriver driver) {
        super(driver);
        
        this.deliveryAddress = new DeliveryAddressComponent(driver);
        this.billingAddress  = new BillingAddressComponent(driver);
    }

    private By checkoutInfoContainer	= By.cssSelector("[data-qa='checkout-info']");

    @Override 
    public boolean isDisplayed() {
    	return eleUtil.waitForVisibility(checkoutInfoContainer).isDisplayed();
    }
    
    public DeliveryAddressComponent getDeliveryAddress() {
        return deliveryAddress;
    }


    public BillingAddressComponent getBillingAddress() {
        return billingAddress;
    }
}
