package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	private By productName		= By.xpath("//h2[normalize-space()='Blue Top']");
	private By categoryName		= By.xpath("//p[normalize-space()='Category: Women > Tops']");
	private By price			= By.xpath("//p[normalize-space()='Category: Women > Tops']");
	private By quantityField	= By.xpath("//input[@id='quantity']");			
	private By addToCard		= By.name("//button[@type='button']");
	private By availablity		= By.xpath("//button[@type='button']");
	private By condition		= By.xpath("//b[normalize-space()='Condition:']");
	private By brand			= By.xpath("//b[normalize-space()='Brand:']");
	
	public boolean isProductNameDisplayed() {
		return eleUtil.isDisplayed(productName);
	}

	public boolean isCategoryDisplayed() {
		return eleUtil.isDisplayed(categoryName);
	}
	
	public boolean isPriceDisplayed() {
		return eleUtil.isDisplayed(price);
	}

	public boolean isAvailabiltyDisplayed() {
		return eleUtil.isDisplayed(availablity);
	}

	public boolean isConditionDisplayed() {
		return eleUtil.isDisplayed(availablity);
	}
	
	public boolean isBrandDisplayed() {
		return eleUtil.isDisplayed(brand);
	}
	
	public boolean areProductDetailsDisplayed() {
		return isProductNameDisplayed()
		        && isCategoryDisplayed()
	            && isPriceDisplayed()
	            && isAvailabiltyDisplayed()
	            && isConditionDisplayed()
	            && isBrandDisplayed();
	}
}
