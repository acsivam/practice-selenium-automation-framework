package com.automation.pages;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.base.BasePage;
import com.automation.components.AddToCartModal;
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
	
	/*
	public AddToCartModal addProductToCartViaHover(String productName){
		eleUtil.getElement(addToCart);
		return new AddToCartModal(driver);
	}
	
	/* 
	public void hoverOnProduct(String productName) {
	    By locator = By.xpath("//p[text()='" + productName +
	            "']/ancestor::div[contains(@class,'product-image-wrapper')]");
	    eleUtil.moveToElement(locator);
	}

	
	public void hoverOnProduct(String productId) {
	    By locator = By.cssSelector("a.add-to-cart[data-product-id='" + productId + "']");
	    eleUtil.moveToElement(locator);
	}
	*/ 

	private By addToCartById(String productId) {
	    return By.cssSelector("a.add-to-cart[data-product-id='" + productId + "']");
	}

	public AddToCartModal clickAddToCartByProductId(String productId) {
		WebElement btn = driver.findElement(addToCartById(productId));
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
	    return new AddToCartModal(driver);
	}
	
	public ProductDetailsPage viewProduct(String productId) {
	    //eleUtil.getElements(viewProductLinks).get(index).click();
		eleUtil.click(viewProductLinks);
	    return new ProductDetailsPage(driver);
	}
	
	/* 
	public AddToCartModal clickAddToCartOnOverlay (String productName) {
		hoverOnProduct(productName);
	    By addToCart = By.xpath("//p[text()='" + productName +
	        "']/ancestor::div[contains(@class,'product-image-wrapper')]//a[contains(text(),'Add to cart')]");

	    eleUtil.click(addToCart);
	    return new AddToCartModal(driver);
	}
	
	public AddToCartModal clickAddToCartOnOverlay (String productId) {
		hoverOnProduct(productId);
	    By addToCart = By.xpath("//p[text()='" + index +
	        "']/ancestor::div[contains(@class,'product-image-wrapper')]//a[contains(text(),'Add to cart')]");

	    eleUtil.click(addToCart);
	    return new AddToCartModal(driver);
	}
	
	
	public AddToCartModal addProductToCartViaHover(String productName){
		hoverOnProduct(productName);
		clickAddToCartOnOverlay(productName);
		return new AddToCartModal(driver);
	}	
	
	public AddToCartModal addProductToCartViaHover(int index){
		hoverOnProduct(index);
		clickAddToCartOnOverlay(index);
		return new AddToCartModal(driver);
	}	
	
	
	private By productByName(String productName) {
	    return By.xpath("//p[normalize-space()='" + productName + "']"
	            + "/ancestor::div[contains(@class,'product-image-wrapper')]");
	}
	
	private void hoverOnProduct(String productName) {
	    eleUtil.moveToElement(productByName(productName));
	}

	public AddToCartModal addToCart(String productName) {
	    hoverOnProduct(productName);
	    eleUtil.click(addToCartButton(productName));
	    return new AddToCartModal(driver);
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
	
	*/
	
	public String getProductNameByIndex(int index) {
	    return eleUtil.getElements(products)
	    		.get(index)
	    		.findElement(By.xpath(".//p")).getText();
	}

	public String getProductIdByIndex(int index) {
	    return eleUtil.getElements(products)
	                  .get(index)
	                  .findElement(By.xpath(".//a[contains(@class,'add-to-cart')]"))
	                  .getAttribute("data-product-id");
	}
	
	public boolean isProductsListDisplayed() {
	    return eleUtil.isDisplayed(productsGrid);
	}
	
	/*
	// ==================== Dynamic Locators ====================
	private By productCard(String productName) {
	    return By.xpath("//div[contains(@class,'product-image-wrapper')][.//p[normalize-space()='"
	            + productName + "']]");
	}

	private By addToCartButton(String productName) {
	    return By.xpath("//div[contains(@class,'product-image-wrapper')][.//p[normalize-space()='"
	            + productName + "']]//div[contains(@class,'product-overlay')]//a[contains(@class,'add-to-cart')]");
	}
	
	// ==================== Actions ====================

	private void hoverOnProduct(String productName) {
	    eleUtil.moveToElement(productCard(productName));
	}

	private void clickAddToCart(String productName) {
	    eleUtil.click(addToCartButton(productName));
	}
	
	// ==================== Business Method ====================

	public AddToCartModal addProductToCart(String productName) {
	    hoverOnProduct(productName);
	    clickAddToCart(productName);
	    return new AddToCartModal(driver);
	}
	
	// ==================== Dynamic Locators ====================

	private By productCard(int index) {
	    return By.xpath("(//div[contains(@class,'product-image-wrapper')])[" + index + "]");
	}


	
	private By addToCartButton(int index) {
	    return By.xpath(
	        "(//div[contains(@class,'product-image-wrapper')])[" + index + "]"
	      + "//a[contains(@class,'add-to-cart')]"
	    );
	}

	private By viewProductButton(int index) {
	    return By.xpath("(//div[contains(@class,'product-image-wrapper')])[" + index + "]"
	            + "/following-sibling::div[contains(@class,'choose')]"
	            + "//a[contains(@href,'product_details')]");
	}
	
	// ==================== Actions ====================

	private void hoverOnProduct(int index) {
		//scrollToProduct(index);
	    eleUtil.moveToElement(productCard(index));
	}

	private void clickAddToCart(int index) {
		//eleUtil.click(addToCartButton(index));
		eleUtil.waitForClickable(addToCartButton(index));
	}

	private void clickViewProduct(int index) {
	    eleUtil.click(viewProductButton(index));
	}
	
    private void scrollToProduct(int index) {
        eleUtil.scrollToElement(productCard(index));
    }
	// ==================== Business Methods ====================

	public AddToCartModal addProductToCart(int index) throws InterruptedException {
	    hoverOnProduct(index);
	    clickAddToCart(index);
	    return new AddToCartModal(driver);
	}

	public ProductDetailsPage viewProduct(int index) {
	    clickViewProduct(index);
	    return new ProductDetailsPage(driver);
	}
	
*/
}
