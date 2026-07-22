package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;
import com.automation.pages.ProductsPage;

public class EmptyCart extends BaseComponent{

    public EmptyCart(WebDriver driver) {
		super(driver);
	}

	private By emptyCart 			= By.id("empty_cart");
	private By clickBuyProducts 	= By.cssSelector("#empty_cart a");

	
	@Override
    public boolean isDisplayed() {
        return eleUtil.waitForVisibility(emptyCart).isDisplayed();
    }
    
    public String getEmptyCartMessage() {
    	return eleUtil.getText(emptyCart);
    }
    
    public ProductsPage clickBuyProducts() {
        eleUtil.click(clickBuyProducts);
        return new ProductsPage(driver);
    }
}
