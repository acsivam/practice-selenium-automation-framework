package com.automation.components;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductGrid extends BaseComponent{

	public ProductGrid(WebDriver driver) {
		super(driver);
	}
	
	private By products 		= By.cssSelector(".features_items .product-image-wrapper");
	private By productGrid 		= By.cssSelector(".features_items");
	private By productHeading 	= By.cssSelector(".features_items h2.title");
	private By productCards		= By.cssSelector(".product-image-wrapper");
	private By productNames 	= By.cssSelector(".productinfo p");
	
	
	public boolean isDisplayed(){
        return eleUtil.isDisplayed(productGrid);
    }

    public String getHeading(){
        return eleUtil.getText(productHeading);
    }

    public int getProductCount(){
        return eleUtil.getCount(products);
    }
    
    public boolean isProductDisplayed(String expectedProductName) {
        List<WebElement> productElements = eleUtil.getElements(productNames);

        for(WebElement product : productElements) {
            if(product.getText().equals(expectedProductName)) {
                return true;
            }
        }
        return false;
    }
    
    public ProductCard getProductById(String productId) {
        List<WebElement> cards = eleUtil.getElements(productCards);
        for (WebElement card : cards) {
            String id = card.findElement(By.cssSelector(".add-to-cart"))
                            .getAttribute("data-product-id");

            if (id.equals(productId)) {
                return new ProductCard(driver, card);
            }
        }
        throw new NoSuchElementException("Product not found: " + productId);
    }
    
    public ProductCard getProductByName(String name) {
        for (WebElement card : eleUtil.getElements(productCards)) {
            if (card.findElement(productNames).getText().equals(name)) {
                return new ProductCard(driver, card);
            }
        }
        throw new NoSuchElementException("Product not found: " + name);
    }
}
