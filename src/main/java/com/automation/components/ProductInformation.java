package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class ProductInformation extends BasePage {

    public ProductInformation(WebDriver driver) {
        super(driver);
    }

    private By productName 		= By.cssSelector(".product-information h2");
    private By category 		= By.cssSelector(".product-information p:nth-of-type(1)");
    private By price 			= By.cssSelector(".product-information span span");
    private By quantity 		= By.id("quantity");
    private By addToCartButton 	= By.cssSelector("button.cart");

    
    public String getProductName() {
        return eleUtil.getText(productName);
    }

    public String getCategory() {
    	return eleUtil.getText(category);
    }
    
    public String getPrice() {
        return eleUtil.getText(price);
    }

    public void enterQuantity(String qty) {
    	eleUtil.getElement(quantity).clear();
    	eleUtil.enterText(quantity, qty);
    }

    public void clickAddToCart() {
    	eleUtil.click(addToCartButton);
    }

}