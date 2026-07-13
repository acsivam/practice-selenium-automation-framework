package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutInfo extends BaseComponent {

    public CheckoutInfo(WebDriver driver) {
        super(driver);
    }


    private By deliveryAddress 	= By.id("address_delivery");
    private By billingAddress 	= By.id("address_invoice");


    public AddressCard getDeliveryAddress() {
        WebElement element = eleUtil.getElement(deliveryAddress);
        return new AddressCard(driver, element);
    }


    public AddressCard getBillingAddress() {
        WebElement element = eleUtil.getElement(billingAddress);
        return new AddressCard(driver, element);
    }
}
