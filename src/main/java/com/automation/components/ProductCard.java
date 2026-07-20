package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseComponent;
import com.automation.models.Product;
import com.automation.pages.ProductDetailsPage;

public class ProductCard extends BaseComponent{

	private WebElement productCard;
	
	public ProductCard(WebDriver driver, WebElement productCard){
		 super(driver);
		 this.productCard = productCard;
	}
	
	//private By container 		= By.cssSelector(".product-image-wrapper");
	private By productOverlay	= By.cssSelector(".product-overlay");
	private By productImage 	= By.cssSelector(".productinfo img");
	private By productName 		= By.cssSelector(".productinfo p");
	private By productPrice 	= By.cssSelector(".productinfo h2");
	private By addToCart 		= By.cssSelector(".add-to-cart");
	private By viewProduct 		= By.cssSelector(".choose a");
	
	
	@Override
	public boolean isDisplayed() {
		return productCard.isDisplayed();
	}
	
	public boolean isProductOverlayDisplayed() {
		return productCard.findElement(productOverlay).isDisplayed();
	}
	
	public boolean isProductImageDisplayed() {
		return eleUtil
				.waitForVisibility(productCard, productImage)
				.isDisplayed();
	}
	
	public boolean isNameDisplayed() {
		return productCard.findElement(productName).isDisplayed();
	}
	
	public String getName() {
        if (!isDisplayed()) {
            return "";
        }
        
        return productCard.findElement(productName).getText();
    }

	public boolean isPriceDisplayed() {
		return productCard.findElement(productPrice).isDisplayed();
	}
	
    public String getPrice() {
        return productCard.findElement(productPrice).getText();
    }

    private int toInteger(String rupeeString) {
    	int numericValue = Integer.parseInt(rupeeString.replaceAll("[^\\d]", ""));
    	return numericValue;
    }
    
    public int getPriceInInteger() {
    	return toInteger(getPrice());
    }
    
    public boolean isAddToCartButtonDisplayed() {
    	return productCard.findElement(addToCart).isDisplayed();
    }
    
    public CartModal clickAddToCart() {
    	productCard.findElement(addToCart).click();
        return new CartModal(driver);
    }

    public boolean isViewProductButtonDisplayed() {
    	return productCard.findElement(viewProduct).isDisplayed();
    }
    
    public ProductDetailsPage clickViewProduct() {
    	productCard.findElement(viewProduct).click();
        return new ProductDetailsPage(driver);
    }
   
    
    public Product toProduct() {
    	Product product = new Product();
    	
    	product.setName(getName());
    	product.setPrice(getPriceInInteger());
    	return product;
    }
}
