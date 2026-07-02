package com.automation.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.BasePage;
import com.automation.pages.BrandProductsPage;
import com.automation.pages.CategoryProductsPage;

public class CategoryBrandSidebar extends BasePage{

	public CategoryBrandSidebar(WebDriver driver) {
		super(driver);
	}

	private By categoryHeading			= By.xpath("//h2[normalize-space()='Category']");
	private By categoryNames 			= By.cssSelector("#accordian .panel-title a");
	private By brandHeading				= By.xpath("//h2[normalize-space()='Brands']");
	private By brandNames				= By.cssSelector(".brands-name");
	
	
	public boolean isCategoryHeadingDisplayed() {
		return eleUtil.isDisplayed(categoryHeading);
	}
	
	public String getCategoryHeading() {
		return eleUtil.getText(categoryHeading);
	}
	
	public List<String> getCategoryNames(){
		return eleUtil.getElementsText(categoryNames);
	}
	
	private By getCategoryLocator(String category) {
	    return By.cssSelector("a[href='#" + category + "']");
	}
		
	public void expandCategory(String category) {
	    eleUtil.click(getCategoryLocator(category));
	}
	
	public void getSubCategoryNames(String category, String subCategory) {
	    expandCategory(category);
	    By locator = By.xpath("//div[@id='" + category + "']//a[normalize-space()='" + subCategory + "']");
	    eleUtil.getElementsText(locator);
	}
	
	public CategoryProductsPage selectSubCategory(String category, String subCategory) {
		expandCategory(category);
		By locator = By.xpath("//div[@id='" + category + "']//a[normalize-space()='" + subCategory + "']");
		eleUtil.click(locator);
		return new CategoryProductsPage(driver);
	}
	
	public boolean isBrandHeadingDisplayed() {
		return eleUtil.isDisplayed(brandHeading);
	}
	
	public String getBrandHeading() {
		return eleUtil.getText(brandHeading);
	}
	
	public List<String> getBrandNames(){
		return eleUtil.getElementsText(brandNames);
	}
	
	public BrandProductsPage selectBrand(String brand) {
		By locator = By.xpath("//a[href='/brand_products/" + brand + "']");
		eleUtil.click(locator);
		return new BrandProductsPage(driver);
	}
}
