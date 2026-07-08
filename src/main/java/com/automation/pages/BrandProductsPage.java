package com.automation.pages;

import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CategoryBrandSidebar;
import com.automation.components.ProductGrid;

public class BrandProductsPage extends BasePage{
	
	private CategoryBrandSidebar sidebar;
	private ProductGrid productGrid;

	public BrandProductsPage(WebDriver driver) {
		super(driver);
		sidebar = new CategoryBrandSidebar(driver);
		productGrid = new ProductGrid(driver);
	}
	
	public CategoryBrandSidebar getSidebar() {
		return sidebar;
	}
	
	public ProductGrid getProductGrid() {
		return productGrid;
	}
	

}
