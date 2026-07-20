package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;

public class ProductInformation extends BaseComponent {

    public ProductInformation(WebDriver driver) {
        super(driver);
    }

    
    private By container        = By.cssSelector(".product-information");
    private By productName 		= By.cssSelector(".product-information h2");
    private By category 		= By.cssSelector(".product-information p:nth-of-type(1)");
    private By price 			= By.cssSelector(".product-information span span");
    private By quantity 		= By.id("quantity");
    private By addToCartButton 	= By.cssSelector("button.cart");
    private By availability     = By.xpath("//p[b[text()='Availability:']]");
    private By condition        = By.xpath("//p[b[text()='Condition:']]");
    private By brand            = By.xpath("//p[b[text()='Brand:']]");

    
	@Override
    public boolean isDisplayed() {
    	return eleUtil.isDisplayed(container);
    }
    
    public String getProductName() {
        return eleUtil.getText(productName);
    }

    public String getCategory() {
    	return eleUtil.getText(category);
    }
    
    public String getPrice() {
        return eleUtil.getText(price);
    }

    public boolean isQuantityinputDisplayed() {
    	return eleUtil.isDisplayed(quantity);
    }
    
    public void enterQuantity(String qty) {
    	eleUtil.getElement(quantity).clear();
    	eleUtil.enterText(quantity, qty);
    }

    public boolean isAddToCartuttonDisplayed() {
    	return eleUtil.isDisplayed(addToCartButton);
    }
    
    public CartModal clickAddToCart() {
    	eleUtil.click(addToCartButton);
    	return new CartModal(driver);
    }

    public String getAvailability() {
    	return eleUtil.getText(availability);
    }
    
    public String getCondition() {
    	return eleUtil.getText(condition);
    }
    
    public String getBrand() {
    	return eleUtil.getText(brand);
    }
}