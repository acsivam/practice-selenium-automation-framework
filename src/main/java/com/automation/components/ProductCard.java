package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.pages.ProductDetailsPage;

public class ProductCard extends BaseComponent{

	private WebElement productCard;
	
	public ProductCard(WebDriver driver, WebElement productCard){
		 super(driver);
		 this.productCard = productCard;
	}
	
	private By productName 	= By.cssSelector(".productinfo p");
	private By productPrice = By.cssSelector(".productinfo h2");
	private By addToCart 	= By.cssSelector(".add-to-cart");
	private By viewProduct 	= By.cssSelector(".choose a");
	
	
	public String getName() {
        return productCard.findElement(productName).getText();
    }

    public String getPrice() {
        return productCard.findElement(productPrice).getText();
    }

    public AddToCartModal clickAddToCart() {
    	productCard.findElement(addToCart).click();
        return new AddToCartModal(driver);
    }

    public ProductDetailsPage clickViewProduct() {
    	productCard.findElement(viewProduct).click();
        return new ProductDetailsPage(driver);
    }

}
