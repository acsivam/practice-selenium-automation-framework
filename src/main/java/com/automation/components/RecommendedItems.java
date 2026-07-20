package com.automation.components;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseComponent;

public class RecommendedItems extends BaseComponent implements ProductContainer{

    public RecommendedItems(WebDriver driver) {
        super(driver);
    }
    
    private By recommendedItems 	= By.cssSelector(".recommended_items");
    private By heading 				= By.cssSelector("h2.title");
    private By productCardsLocator 	= By.cssSelector(".product-image-wrapper");
    private By nextButton 			= By.cssSelector(".carousel-control-next");
    private By previousButton 		= By.cssSelector(".carousel-control-prev");
	private By productNames 		= By.cssSelector(".productinfo p");


    
    @Override
    public boolean isDisplayed() {
        return eleUtil.isDisplayed(recommendedItems);
    }
    
    
    private WebElement getRecommendedItems() {
        return eleUtil.getElement(recommendedItems);
    }
    
    public String getHeading() {
        return getRecommendedItems().findElement(heading).getText();
    }
    
    public int getProductCount() {
        return getRecommendedItems().findElements(productCardsLocator).size();
    }
    
    public List<ProductCard> getProducts() {

        List<ProductCard> products = new ArrayList<>();

        for (WebElement card : getRecommendedItems().findElements(productCardsLocator)) {
            products.add(new ProductCard(driver, card));
            
        	if (!card.isDisplayed()) {//  filtering out hidden products so only active slides are returned
    	        continue;
    	    }

        }
        return products;
    }
    
    @Override
    public ProductCard getProductByName(String name) {
    	for (WebElement card : getRecommendedItems().findElements(productCardsLocator)) {
            if (card.findElement(productNames).getText().equals(name)) {
                return new ProductCard(driver, card);
            }
        }
        throw new NoSuchElementException("Either recommended product not found (or not active): " + name);
        
    }
    
    public RecommendedItems clickNext() {
    	getRecommendedItems().findElement(nextButton).click();
        return this;
    }


    public RecommendedItems clickPrevious() {
    	getRecommendedItems().findElement(previousButton).click();
        return this;
    }
}