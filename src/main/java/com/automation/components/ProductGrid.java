	package com.automation.components;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseComponent;
import com.automation.models.Product;

public class ProductGrid extends BaseComponent implements ProductContainer{

	
	
	public ProductGrid(WebDriver driver) {
		super(driver);
	}

	
	//private By products 			= By.cssSelector(".features_items .product-image-wrapper");
	private By productGrid 			= By.cssSelector(".features_items");
	private By productHeading 		= By.cssSelector("h2.title");
	private By productCardsLocator	= By.cssSelector(".product-image-wrapper");
	private By productNames 		= By.cssSelector(".productinfo p");
	
	
	@Override
	public boolean isDisplayed(){
        return eleUtil.waitForVisibility(productGrid).isDisplayed();
    } 
	 
	private WebElement getProductGrid(){
        return eleUtil.getElement(productGrid);
    }
	
	public boolean isHeadingDisplayed() {
        return getProductGrid().findElement(productHeading).isDisplayed();
	}
	
    public String getHeading(){
        return getProductGrid().findElement(productHeading).getText();
    }

    public int getProductCount(){
        return getProductGrid().findElements(productCardsLocator).size();
    }
    
    public List<ProductCard> getProducts() {
        List<ProductCard> productCards = new ArrayList<>();
       
        List<WebElement> cards = getProductGrid().findElements(productCardsLocator); //driver.findElements(products);
       
        for (WebElement card : cards) {
            productCards.add(new ProductCard(driver, card));
        }

        return productCards;
    }
    
    public boolean isProductDisplayed(String expectedProductName) {
        List<WebElement> productElements = getProductGrid().findElements(productNames);

        for(WebElement product : productElements) {
            if(product.getText().equals(expectedProductName)) {
                return true;
            }
        }
        return false;
    }
    
    public ProductCard getProductById(String productId) {
        List<WebElement> cards = getProductGrid().findElements(productCardsLocator);
        for (WebElement card : cards) {
            String id = card.findElement(By.cssSelector(".add-to-cart"))
                            .getAttribute("data-product-id");

            if (id.equals(productId)) {
                return new ProductCard(driver, card);
            }
        }
        throw new NoSuchElementException("Product not found: " + productId);
    }
    
    @Override
    public ProductCard getProductByName(String name) {
    	for (WebElement card : getProductGrid().findElements(productCardsLocator)) {
            if (card.findElement(productNames).getText().equals(name)) {
                return new ProductCard(driver, card);
            }
        }
        throw new NoSuchElementException("Product not found: " + name);
    }
    /**/

}
