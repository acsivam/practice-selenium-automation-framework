package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.components.AddToCartModal;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	private By productHeading			= By.xpath("//h2[@class='title text-center']");
	private By products 				= By.cssSelector(".product-image-wrapper");
	private By productsGrid 			= By.cssSelector(".features_items");

	
	public boolean isProductHeadingDisplayed() {
		return eleUtil.isDisplayed(productHeading);
	}
	
	public String getProductHeading() {
		return eleUtil.getText(productHeading);
	}
	
	private By addToCartById(String productId) {
	    return By.cssSelector("a.add-to-cart[data-product-id='" + productId + "']");
	}

	public AddToCartModal clickAddToCartByProductId(String productId) {
		WebElement btn = driver.findElement(addToCartById(productId));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
	    return new AddToCartModal(driver);
	}
	
	private By viewProductLinkId(String productId) {
		return By.cssSelector("a[href='/product_details/" + productId + "']");
	}
	
	public ProductDetailsPage viewProduct(String productId) {
		WebElement btn = driver.findElement(viewProductLinkId(productId));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
	    return new ProductDetailsPage(driver);
	}
	
	public boolean isProductsListDisplayed() {
	    return eleUtil.isDisplayed(productsGrid);
	}
}
