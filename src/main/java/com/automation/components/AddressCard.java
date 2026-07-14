package com.automation.components;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressCard extends BaseComponent {

    private WebElement addressElement;

    public AddressCard(WebDriver driver, WebElement addressElement) {
        super(driver);
        this.addressElement = addressElement;
    }


    private By title 		= By.cssSelector(".address_title h3");
    private By name 		= By.cssSelector(".address_firstname");
    private By addressLines = By.cssSelector(".address_address1");
    private By city 		= By.cssSelector(".address_city");
    private By country 		= By.cssSelector(".address_country_name");
    private By phone 		= By.cssSelector(".address_phone");


    public String getTitle() {
        return addressElement.findElement(title).getText();
    }


    public String getName() {
        return addressElement.findElement(name).getText();
    }


    public List<String> getAddressLines() {
        return addressElement
                .findElements(addressLines)
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public String getCity() {
        return addressElement.findElement(city).getText();
    }


    public String getCountry() {
        return addressElement.findElement(country).getText();
    }


    public String getPhone() {
        return addressElement.findElement(phone).getText();
    }
}
