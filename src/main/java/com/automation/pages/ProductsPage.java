package com.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.ElementUtils;

public class ProductsPage extends BasePage{
	
	public ProductsPage(WebDriver driver) {
		super(driver);
	}
	
	private By saleImage 				= By.xpath("//img[@id='sale_image']");
	private By searchProductField		= By.xpath("//input[@id='search_product']");
	private By searchButton				= By.xpath("//button[@id='submit_search']");
	private By categoryHeading			= By.xpath("//h2[normalize-space()='Category']");
	private By categoryNames 			= By.cssSelector("#accordian .panel-title a");
	//	private By womenSubCategories 		= By.cssSelector("#Women li");
	//   private By menSubCategories 		= By.cssSelector("#Men li");
	//   private By kidsSubCategories 		= By.cssSelector("#Kids li");
	private By brandHeading				= By.xpath("//h2[normalize-space()='Brands']");
	private By brandNames				= By.cssSelector(".brands-name");
	//	private By poloSubCategories		= By.cssSelector("a[href='/brand_products/Polo']");
	//	private By hnmSubCategories			= By.cssSelector("a[href='/brand_products/H&M']");
	//	private By madameSubCategories		= By.cssSelector("a[href='/brand_products/Madame']");
	//	private By mastHarbourSubCategories	= By.cssSelector("a[href='/brand_products/Mast & Harbour']");
	//	private By babyhugSubCategories		= By.cssSelector("a[href='/brand_products/Babyhug']");
	//	private By allenSolySubCategories	= By.cssSelector("a[href='/brand_products/Allen Solly Junior']");
	//	private By kookieSubCategories		= By.cssSelector("a[href='/brand_products/Kookie Kids']");
	//	private By bibaSubCategories		= By.cssSelector("a[href='/brand_products/Biba']");
	private By productHeading			= By.xpath("//h2[@class='title text-center']");
	private By products 				= By.cssSelector(".product-image-wrapper");
	private By viewProductLinks 		= By.cssSelector("a[href*='product_details']");
	private By productsGrid 			= By.cssSelector(".features_items");
	
	public boolean isSaleImageDisplayed() {
		return eleUtil.isDisplayed(saleImage);
	}
	
	public void enterProduct(String product) {
		eleUtil.enterText(searchProductField, product);
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
	
	public int getProductCount() {
		return eleUtil.getCount(products);
	}
	
	
	public boolean isProductHeadingDisplayed() {
		return eleUtil.isDisplayed(productHeading);
	}
	
	public String getProductHeading() {
		return eleUtil.getText(productHeading);
	}
	
	public void hoverOnProduct(String productName) {
	    By locator = By.xpath("//p[text()='" + productName +
	            "']/ancestor::div[contains(@class,'product-image-wrapper')]");
	    eleUtil.moveToElement(locator);
	}

	public void addProductToCart(String productName) {
		hoverOnProduct(productName);
	    By addToCart = By.xpath("//p[text()='" + productName +
	        "']/ancestor::div[contains(@class,'product-image-wrapper')]//a[contains(text(),'Add to cart')]");

	    eleUtil.click(addToCart);
	}

	public ProductDetailsPage viewProduct(String productName) {
	    By locator = By.xpath("//p[text()='" + productName + "']" +
	        "/ancestor::div[contains(@class,'product-image-wrapper')]" +
	        "//a[contains(text(),'View Product')]");

	    eleUtil.click(locator);
	    return new ProductDetailsPage(driver);
	}
	
	public ProductDetailsPage viewProduct(int index) {
	    eleUtil.getElements(viewProductLinks).get(index).click();
	    return new ProductDetailsPage(driver);
	}
	
	public boolean isProductsListDisplayed() {
	    return eleUtil.isDisplayed(productsGrid);
	}
	
}
