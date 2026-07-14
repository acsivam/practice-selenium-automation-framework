package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseComponent;
import com.automation.pages.ProductDetailsPage;

public class ProductCard extends BaseComponent{

	private WebElement productCard;
	
	public ProductCard(WebDriver driver, WebElement productCard){
		 super(driver);
		 this.productCard = productCard;
	}
	
	private By container 	= By.cssSelector(".product-image-wrapper");
	private By productImage = By.cssSelector(".productinfo img");
	private By productName 	= By.cssSelector(".productinfo p");
	private By productPrice = By.cssSelector(".productinfo h2");
	private By addToCart 	= By.cssSelector(".add-to-cart");
	private By viewProduct 	= By.cssSelector(".choose a");
	
	
	@Override
	public boolean isDisplayed() {
		return eleUtil.isDisplayed(container);
	}
	
	public boolean isProductImageDisplayed() {
		return eleUtil.isDisplayed(productImage);
	}
	
	public String getName() {
        return productCard.findElement(productName).getText();
    }

    public String getPrice() {
        return productCard.findElement(productPrice).getText();
    }

    public CartModal clickAddToCart() {
    	productCard.findElement(addToCart).click();
        return new CartModal(driver);
    }

    public ProductDetailsPage clickViewProduct() {
    	productCard.findElement(viewProduct).click();
        return new ProductDetailsPage(driver);
    }

}
