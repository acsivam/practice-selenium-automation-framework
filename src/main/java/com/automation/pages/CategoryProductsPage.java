package com.automation.pages;

import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CategoryBrandSidebar;
import com.automation.components.ProductGrid;

public class CategoryProductsPage extends BasePage{
	
	private CategoryBrandSidebar sidebar;
	private ProductGrid productGrid;
	
	public CategoryProductsPage(WebDriver driver) {
		super(driver);
		this.sidebar 		= new CategoryBrandSidebar(driver);
		this.productGrid 	= new ProductGrid(driver);
	}
	
	
	public CategoryBrandSidebar getSidebar() {
		return sidebar;
	}
	
	public ProductGrid getProductGrid() {
		return productGrid;
	}

}
