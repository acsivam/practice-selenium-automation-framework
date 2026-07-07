package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductGrid extends BaseComponent{

	public ProductGrid(WebDriver driver) {
		super(driver);
	}
	
	private By products 		= By.cssSelector(".features_items .product-image-wrapper");
	private By productGrid 		= By.cssSelector(".features_items");
	private By productHeading 	= By.cssSelector(".features_items h2.title");
	private By productCards 	= By.cssSelector(".product-image-wrapper");
	
	
	public boolean isDisplayed(){
        return eleUtil.isDisplayed(productGrid);
    }

    public String getHeading(){
        return eleUtil.getText(productHeading);
    }

    public int getProductCount(){
        return eleUtil.getCount(productCards);
    }
    
    public ProductCard getProductById(String productId) {
    	//eleUtil.getElement(productIdLocator(productId));
        return new ProductCard(driver,productIdLocator(productId));
    }

    private By productIdLocator(String productId) {
    	return By.cssSelector(".product-image-wrapper a[data-product-id='" + productId + "']");
    }
    
    public ProductCard getProductByName(String productName) {
    	//eleUtil.getElement(productNameLocator(productName));
    	return new ProductCard(driver, productNameLocator(productName));
    }
    
    private By productNameLocator(String productName) {
    	return By.xpath("//div[@class='productinfo text-center']" +
                        "[p[normalize-space()='" + productName + "']]");
    }
}
