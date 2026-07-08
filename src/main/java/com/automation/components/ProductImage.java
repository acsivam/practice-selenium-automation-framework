package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class ProductImage extends BasePage {

	public ProductImage(WebDriver driver) {
        super(driver);
    }
    
    private By productImage = By.cssSelector(".view-product img");

    public String getProductImageUrl() {
        return eleUtil.getAttribute(productImage, "src");
    }


    public boolean isProductImageDisplayed() {
        return eleUtil.isDisplayed(productImage);
    }
}
