package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.pages.ProductDetailsPage;

public class ProductCard extends BaseComponent{

	private By productLocator;
	
	public ProductCard(WebDriver driver, By productLocator){
		 super(driver);
		 this.productLocator = productLocator;
	}
	
	private By productName 	= By.cssSelector(".productinfo p");
	private By productPrice = By.cssSelector(".productinfo h2");
	private By addToCart 	= By.cssSelector(".add-to-cart");
	private By viewProduct 	= By.cssSelector(".choose a");
	
	
	private WebElement getProduct() {
        return driver.findElement(productLocator);
    }
	
	public String getName() {
        return getProduct().findElement(productName).getText();
    }

    public String getPrice() {
        return getProduct().findElement(productPrice).getText();
    }

    public AddToCartModal clickAddToCart() {
    	getProduct().findElement(addToCart).click();
        return new AddToCartModal(driver);
    }

    public ProductDetailsPage clickViewProduct() {
    	getProduct().findElement(viewProduct).click();
        return new ProductDetailsPage(driver);
    }

}
