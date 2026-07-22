package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;
import com.automation.pages.ProductsPage;

public class ProductSearch extends BaseComponent{

	public ProductSearch(WebDriver driver) {
		super(driver);
	}
	
	
	private By searchBox 	= By.id("search_product");
    private By searchButton = By.id("submit_search");
	
    
	@Override
    public boolean isDisplayed() {
    	return  eleUtil.waitForVisibility(searchBox).isDisplayed()
    			&& eleUtil.waitForVisibility(searchButton).isDisplayed();
    }
	
	public void enterProduct(String product) {
		eleUtil.enterText(searchBox, product);
	}
	
	public void clickSearch() {
		eleUtil.click(searchButton);
	}
	
	//business logic
	public ProductsPage searchProduct(String product) {
		enterProduct(product);
		clickSearch();
		return new ProductsPage(driver);
	}

}
