package com.automation.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	private By cartRows 			= By.cssSelector("tr[id^='product-']");
    private By productNameLinks 	= By.xpath("//td[@class='cart_description']/h4/a");
    private By productPrice			= By.xpath(".//td[@class='cart_price']/p");
    private By productQuantity		= By.xpath(".//td[@class='cart_quantity']/button");
    private By productTotalPrice 	= By.xpath(".//td[@class='cart_total']/p");
    
    
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
	
	/*
	public List<String> getCartProductNames() {
	    List<WebElement> names = driver.findElements(By.xpath("//td[@class='cart_description']/h4/a"));
	    return names.stream().map(WebElement::getText).collect(Collectors.toList());
	}
	*/ 

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

}
