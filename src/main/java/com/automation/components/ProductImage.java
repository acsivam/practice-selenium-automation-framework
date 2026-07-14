package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;

public class ProductImage extends BaseComponent {

	public ProductImage(WebDriver driver) {
        super(driver);
    }
	
	
	private By container = By.cssSelector(".view-product");
    private By productImage = By.cssSelector(".view-product img");

    
	@Override
    public boolean isDisplayed() {
    	return eleUtil.isDisplayed(container);
    }

    public boolean isProductImageDisplayed() {
        return eleUtil.isDisplayed(productImage);
    }
    
    public String getProductImageUrl() {
        return eleUtil.getAttribute(productImage, "src");
    }

}
