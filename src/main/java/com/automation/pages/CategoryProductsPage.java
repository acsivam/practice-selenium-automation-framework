package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CategoryBrandSidebar;
import com.automation.components.ProductGrid;
import com.automation.constants.AppConstants;

public class CategoryProductsPage extends BasePage{
	
	private CategoryBrandSidebar sidebar;
	private ProductGrid productGrid;
	
	public CategoryProductsPage(WebDriver driver) {
		super(driver);
		this.sidebar 		= new CategoryBrandSidebar(driver);
		this.productGrid 	= new ProductGrid(driver);
	}
	
	private By productGridLocator 	= By.cssSelector(".features_items");

	public CategoryBrandSidebar getCategoryBrandSidebar() {
		return sidebar;
	}
	
	public ProductGrid getProductGrid() {
		return productGrid;
	}
	
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.CATEGORY_PRODUCTS_PAGE_PATH)
				&& getProductGrid().isDisplayed();
	}


}
