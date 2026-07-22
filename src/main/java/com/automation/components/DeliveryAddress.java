package com.automation.components;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseComponent;

public class DeliveryAddress extends BaseComponent implements Address{

    public DeliveryAddress(WebDriver driver) {
        super(driver);
    }

    private By deliveryAddressContainer = By.id("address_delivery");
    private By title 					= By.cssSelector("#address_delivery h3.page-subheading");
    private By customerName 			= By.cssSelector("#address_delivery li.address_firstname.address_lastname");
    private By addressLines				= By.cssSelector("#address_delivery li.address_address1.address_address2");
    private By cityStatePostcode 		= By.cssSelector("#address_delivery li.address_city.address_state_name.address_postcode");
    private By country 					= By.cssSelector("#address_delivery li.address_country_name");
    private By phone		 			= By.cssSelector("#address_delivery li.address_phone");

    
    @Override
    public boolean isDisplayed() {
    	return eleUtil.waitForVisibility(deliveryAddressContainer).isDisplayed();
    }
    
    @Override
    public String getTitle() {
        return eleUtil.getText(title);
    }
  
	@Override
	public boolean isAddressHeadingDispalyed() {
		return eleUtil.isDisplayed(title);
	}
	
	@Override
    public String getName() {
        return eleUtil.getText(customerName);
    }

	@Override
    public List<String> getAddressLines() {
        return eleUtil
        		.getElements(addressLines)
        		.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

	@Override
    public String getCity() {
        return eleUtil.getText(cityStatePostcode);
    }

	@Override
    public String getCountry() {
        return eleUtil.getText(country);
    }

	@Override
    public String getPhone() {
        return eleUtil.getText(phone);
    }

}
