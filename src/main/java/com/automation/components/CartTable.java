package com.automation.components;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartTable extends BaseComponent{

	public CartTable(WebDriver driver) {
		super(driver);
	}

	private By table 		= By.id("cart_info");
	private By rows 		= By.cssSelector("tbody tr[id^='product-']");
	private By grandTotal 	= By.xpath("//h4/b[text()='Total Amount']/../../following-sibling::td//p");
	private By emptyCart    = By.id("empty_cart");
	
	
    public boolean isDisplayed() {
    	return eleUtil.isDisplayed(table);
    }

    public int getProductCount() {
    	return eleUtil.getElements(rows).size();
    }

    public List<CartRow> getProducts(){
        List<CartRow> products = new ArrayList<>();

        for (WebElement row : eleUtil.getElements(rows)) {
            products.add(new CartRow(driver, row));
        }

        return products;
    }

    public CartRow getProductByName(String name) {
    	for (CartRow product : getProducts()) {
            if (product.getName().equals(name)) {
                return product;
            }
        }

        throw new NoSuchElementException(
                "Product not found: " + name);
    }

    public boolean isEmpty() {
    	return eleUtil.isDisplayed(emptyCart);
    }

    public String getEmptyMessage() {
    	return eleUtil.getText(emptyCart);
    }

    public boolean hasGrandTotal() {
    	return eleUtil.isDisplayed(grandTotal);
    }

    public String getGrandTotal() {
    	return eleUtil.getText(grandTotal);
    }
}
