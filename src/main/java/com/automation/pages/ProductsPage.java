	package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.Advertisement;
import com.automation.components.CategoryBrandSidebar;
import com.automation.components.ProductGrid;
import com.automation.components.ProductSearch;
import com.automation.constants.AppConstants;

public class ProductsPage extends BasePage{
	
	private Advertisement advertisement;
	private CategoryBrandSidebar sidebar;
	private ProductSearch searchBox;
	private ProductGrid productGrid;
	
	public ProductsPage(WebDriver driver) {
		super(driver);
		
		this.sidebar = new CategoryBrandSidebar(driver);
		this.productGrid = new ProductGrid(driver);
		this.searchBox = new ProductSearch(driver);
	}
	
	private By productGridLocator = By.cssSelector(".features_items");

	
	public Advertisement getAdvertisement() {
		return advertisement;
	}
	
	public CategoryBrandSidebar getCategoryBrandSidebar() {
		return sidebar;
	}
	
	public ProductGrid getProductGrid() {
		return productGrid;
	}
	
	public ProductSearch getProductSearch() {
		return searchBox;
	}
	
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.PRODUCTS_PAGE_PATH)
				&& getAdvertisement().isDisplayed();
	}
	

	
	/*
	public int getProductCount() {
		return eleUtil.getCount(products);
	}
	
	
	public boolean isProductHeadingDisplayed() {
		return eleUtil.isDisplayed(productHeading);
	}
	
	public String getProductHeading() {
		return eleUtil.getText(productHeading);
	}
	*/
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

	/*
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
	*/
	
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
	
	/*
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
	*/
	
	
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
