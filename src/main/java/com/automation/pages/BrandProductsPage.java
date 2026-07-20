package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CategoryBrandSidebar;
import com.automation.components.ProductGrid;
import com.automation.constants.AppConstants;

public class BrandProductsPage extends BasePage{
	
	private CategoryBrandSidebar sidebar;
	private ProductGrid productGrid;

	public BrandProductsPage(WebDriver driver) {
		super(driver);
		sidebar = new CategoryBrandSidebar(driver);
		productGrid = new ProductGrid(driver);
	}
	
	private By productGridLocator 	= By.cssSelector(".features_items");

	
	public CategoryBrandSidebar getSidebar() {
		return sidebar;
	}
	
	public ProductGrid getProductGrid() {
		return productGrid;
	}
	
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.BRAND_PRODUCT_PAGE_PATH)
				&& getProductGrid().isDisplayed();
	}

}
