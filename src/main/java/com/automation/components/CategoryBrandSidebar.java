package com.automation.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;
import com.automation.pages.BrandProductsPage;
import com.automation.pages.CategoryProductsPage;

public class CategoryBrandSidebar extends BaseComponent{

	private String expandedCategory;
	
	public CategoryBrandSidebar(WebDriver driver) {
		super(driver);
	}

	private By container 				= By.cssSelector(".left-sidebar");
	private By categoryHeading			= By.xpath("//h2[normalize-space()='Category']");
	private By categoryNames 			= By.cssSelector("#accordian .panel-title a");
	private By brandHeading				= By.xpath("//h2[normalize-space()='Brands']");
	private By brandNames				= By.cssSelector(".brands-name");
	
	
	@Override
	public boolean isDisplayed() {
		return eleUtil.isDisplayed(container);
	}
	
	public boolean isCategoryHeadingDisplayed() {
		return eleUtil.isDisplayed(categoryHeading);
	}
	
	public String getCategoryHeading() {
		return eleUtil.getText(categoryHeading);
	}
	
	public List<String> getCategoryNames(){
		return eleUtil.getElementsText(categoryNames);
	}
	
	private boolean isExpanded(String categoryName) {
		return categoryName.equals(expandedCategory);
	}
	
	public CategoryBrandSidebar expandCategory(String categoryName) {
		if (!isExpanded(categoryName)) {
			// if another category is open, close it first
		     if (expandedCategory != null) {
		    	 eleUtil.click(category(expandedCategory));
		     }
		     eleUtil.click(category(categoryName));
		     expandedCategory = categoryName;
		     }
	    return this; 
	}

	private By category(String categoryName) {
	    return By.cssSelector("a[href='#" + categoryName + "']");
	}
	
	public List<String> getSubCategoryNames() {
		By subCategories = subCategory(expandedCategory);
		eleUtil.waitForVisibility(subCategories);
	    return eleUtil.getElementsText(subCategories);
	}
	
	private By subCategory(String categoryName) {
	    return By.xpath("//div[@id='" + categoryName + "']//li/a");
	}
	
	public CategoryProductsPage selectSubCategory(String subCategoryName) {
		if (expandedCategory == null) {
	        throw new IllegalStateException(
	            "No category is expanded. Expand a category before selecting subcategory."
	        );
	    }
		eleUtil.click(subCategory(expandedCategory, subCategoryName));
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
		return By.xpath("//a[@href='/brand_products/" + brandName + "']");
	}
	
	/*
	 * ├── SidebarComponent
│       container = .left-sidebar
│
├── CategoryComponent
│       container = #accordian
│
└── BrandComponent
        container = .brands_products
        
        *
	 */
}
