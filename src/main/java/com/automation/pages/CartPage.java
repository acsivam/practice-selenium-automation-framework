package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CartTable;
import com.automation.components.CheckoutModal;
import com.automation.components.EmptyCartMessage;
import com.automation.constants.AppConstants;

public class CartPage extends BasePage{
	
	private CartTable cartTable;
	private EmptyCartMessage emptyCartMessage;

	public CartPage(WebDriver driver) {
		super(driver);
		this.cartTable 			= new CartTable(driver);
		this.emptyCartMessage 	= new EmptyCartMessage(driver);
	}
	
	
    private By cartInfo 				= By.id("cart_info");
    private By proceedToCheckoutButton 	= By.xpath("//a[@class='btn btn-default check_out']");

    
	
    public CartTable getCartTable() {
    	return cartTable;
    }
    
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.CART_PAGE_PATH)
				&& isCartInfoDisplayed();
	}
    
    public boolean isCartInfoDisplayed() {
    	return eleUtil.isDisplayed(cartInfo);
    }
    
	public boolean isCartEmpty() {
        return emptyCartMessage.isDisplayed();
	}

	public boolean hasProducts() {
	        return cartTable.isDisplayed();
	}
	
	public CheckoutPage proceedToCheckoutAsLoggedInUser() {
	    eleUtil.click(proceedToCheckoutButton);
	    return new CheckoutPage(driver);
	}

	public CheckoutModal proceedToCheckoutAsGuest() {
	    eleUtil.click(proceedToCheckoutButton);
	    return new CheckoutModal(driver);
	}
    /*
	public int getCartItemCount() {
		List<WebElement> cartItems = eleUtil.getElements(cartRows);
	    return cartItems.size();
	}
	
	public List<String> getCartProductName(){
		return eleUtil.getElements(productNameLinks)
				.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
	}
	
	public List<String> getProductQuantyty(){
		return eleUtil.getElements(productQuantity)
				.stream()
				.map(WebElement::getText)
				.collect(Collectors.toList());
	}
	
	*/
	
	/*
	public List<String> getCartProductNames() {
	    List<WebElement> names = driver.findElements(By.xpath("//td[@class='cart_description']/h4/a"));
	    return names.stream().map(WebElement::getText).collect(Collectors.toList());
	}
	*/ 
    
    /*
	public List<String> getCartProductIds() {
	    List<WebElement> rows = eleUtil.getElements(cartRows);
	    if (rows.isEmpty()) {
	        throw new RuntimeException("No cart rows found. Check locator or page load.");
	    }
	    return rows.stream()
	               .map(row -> row.getAttribute("id").replace("product-", ""))
	               .collect(Collectors.toList());
	}

	public String getProductName(int index) {
	    return eleUtil.getElements(cartRows).get(index)
	                  .findElement(productNameLinks).getText();
	}

	public String getProductPrice(int index) {
	    return eleUtil.getElements(cartRows).get(index)
	                  .findElement(productPrice).getText();
	}

	public String getProductQuantity(int index) {
	    return eleUtil.getElements(cartRows).get(index)
	                  .findElement(productQuantity).getText();
	}

	public String getProductTotalPrice(int index) {
	    return eleUtil.getElements(cartRows).get(index)
	                  .findElement(productTotalPrice).getText();
	}
	
	*/


}
