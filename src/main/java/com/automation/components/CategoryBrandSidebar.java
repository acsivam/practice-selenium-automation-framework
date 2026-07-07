package com.automation.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.BrandProductsPage;
import com.automation.pages.CategoryProductsPage;

public class CategoryBrandSidebar extends BaseComponent{

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
		
	public void expandCategory(String categotyName) {
	    eleUtil.click(category(categotyName));
	}

	private By category(String categoryName) {
	    return By.cssSelector("a[href='#" + categoryName + "']");
	}
	
	public List<String> getSubCategoryNames(String categoryName) {
	    return eleUtil.getElementsText(subCategory(categoryName));
	}
	
	private By subCategory(String categoryName) {
	    return By.xpath("//div[@id='" + categoryName + "']//li/a");
	}
	
	public CategoryProductsPage selectSubCategory(String categoryName, String subCategotyName) {
		expandCategory(categoryName);
		eleUtil.click(subCategory(categoryName, subCategotyName));
		return new CategoryProductsPage(driver);
	}
	
	private By subCategory(String categoryName, String subCategotyName) {
		return By.xpath("//div[@id='" + categoryName + "']//a[normalize-space()='" + subCategotyName + "']");
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
	
	public BrandProductsPage selectBrand(String brandName) {
		eleUtil.click(brand(brandName));
		return new BrandProductsPage(driver);
	}
	
	private By brand(String brandName) {
		return By.xpath("//a[href='/brand_products/" + brandName + "']");
	}
}
