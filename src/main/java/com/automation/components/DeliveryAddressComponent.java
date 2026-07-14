package com.automation.components;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseComponent;

public class DeliveryAddressComponent extends BaseComponent {

    public DeliveryAddressComponent(WebDriver driver) {
        super(driver);
    }

    private By deliveryAddressContainer = By.id("address_delivery");
    private By title 					= By.cssSelector(".address_title h3");
    private By customerName 			= By.cssSelector(".address_firstname");
    private By addressLines				= By.cssSelector(".address_address1");
    private By cityStatePostcode 		= By.cssSelector(".address_city");
    private By country 					= By.cssSelector(".address_country_name");
    private By phone		 			= By.cssSelector(".address_phone");

    
    @Override
    public boolean isDisplayed() {
    	return eleUtil.isDisplayed(deliveryAddressContainer);
    }
    
    public String getTitle() {
        return eleUtil.getText(title);
    }

    public String getName() {
        return eleUtil.getText(customerName);
    }

    public List<String> getAddressLines() {
        return eleUtil
        		.getElements(addressLines)
        		.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String getCity() {
        return eleUtil.getText(cityStatePostcode);
    }

    public String getCountry() {
        return eleUtil.getText(country);
    }

    public String getPhone() {
        return eleUtil.getText(phone);
    }
}
