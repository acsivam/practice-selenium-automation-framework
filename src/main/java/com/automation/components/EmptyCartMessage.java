package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;
import com.automation.pages.ProductsPage;

public class EmptyCartMessage extends BaseComponent{

    public EmptyCartMessage(WebDriver driver) {
		super(driver);
	}

	private By emptyCart 			= By.id("empty_cart");
	private By continueShoppingLink = By.cssSelector("#empty_cart a");

	
	@Override
    public boolean isDisplayed() {
        return eleUtil.isDisplayed(emptyCart);
    }
    
    public String getEmptyCartMessage() {
    	return eleUtil.getText(emptyCart);
    }
    
    public ProductsPage clickContinueShopping() {
        eleUtil.click(continueShoppingLink);
        return new ProductsPage(driver);
    }
}
