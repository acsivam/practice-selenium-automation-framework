package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CategoryBrandSidebar;
import com.automation.components.HomeCarousel;
import com.automation.components.ProductGrid;
import com.automation.components.RecommendedItems;
import com.automation.constants.AppConstants;

public class HomePage extends BasePage{

	private HomeCarousel carousel;
	private CategoryBrandSidebar sidebar;
	private ProductGrid productGrid;
	private RecommendedItems recommededGrid;
	
	public HomePage(WebDriver driver) {
		super(driver);	
		this.carousel   	= new HomeCarousel(driver);
		this.sidebar		= new CategoryBrandSidebar(driver);
		this.productGrid 	= new ProductGrid(driver);
		this.recommededGrid	= new RecommendedItems(driver);
	}// //

	private By productGridLocator 	= By.cssSelector(".features_items");
	private By recommededItemsGrid	= By.cssSelector(".recommended_items");
	
	public HomeCarousel getCarousel() {
		return carousel;
	}
	
	public CategoryBrandSidebar getSidebar() {
		return sidebar;
	}
	
	public ProductGrid getProductGrid() {
		return productGrid;
	}
	
	public RecommendedItems getRecommendedItems() {
		return recommededGrid;
	}
	
	@Override
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.HOME_PAGE_PATH)
	            && getCarousel().isDisplayed();
	}
	
	/*
	/*
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
	
		@Override
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.HOME_PAGE_PATH)
	            && getCarousel().isDisplayed();
	}
	*/


}
