package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseComponent;
import com.automation.models.CartItem;
import com.automation.models.Product;

public class CartRow extends BaseComponent {

	private WebElement row;
	
	public CartRow(WebDriver driver, WebElement row) {
		super(driver);
		
		if (row == null) {
	        throw new IllegalArgumentException("Cart row cannot be null");
	    }
		this.row = row;
	}
	
	private final By name 			= By.cssSelector(".cart_description h4");
	private final By category 		= By.cssSelector(".cart_description p");
	private final By price 			= By.cssSelector(".cart_price p");
	private final By quantity 		= By.cssSelector(".cart_quantity button");
	private final By total 			= By.cssSelector(".cart_total_price");
	private final By removeButton	= By.cssSelector(".cart_quantity_delete");
	
	
	@Override
	public boolean isDisplayed() {
	    return row.isDisplayed();
	}
	
	public String getName() {
		return row.findElement(name).getText();
	}

	public String getCategory() {
		return row.findElement(category).getText();
	}

	public String getPrice() {
		return row.findElement(price).getText();
	}

	public String getQuantity() {
		return row.findElement(quantity).getText();
	}

	public String getTotal() {
		return row.findElement(total).getText();
	}
	
	public boolean canRemove() {
        return !row.findElements(removeButton).isEmpty();
    }

    public void remove() {
        if (!canRemove()) {
            throw new IllegalStateException(
                "Remove button is not available.");
        }
        eleUtil.click(row.findElement(removeButton));
    }

    private int toInteger(String rupeeString) {
    	int numericValue = Integer.parseInt(rupeeString.replaceAll("[^\\d]", ""));
    	return numericValue;
    }
    
    public Product toProduct() {
    	Product product = new Product();
    	product.setName(getName());
    	product.setCategory(getCategory());
    	product.setPrice(toInteger(getPrice()));
    	//product.setQuantity(getQuantity());
    	//product.setTotal(getTotal());
    	return product;
    }
    
    public CartItem toCartItem() {
    	Product product = new Product();
    	
    	product.setName(getName());
    	product.setCategory(getCategory());
    	product.setPrice(toInteger(getPrice()));
  
    	return  new CartItem(product, toInteger(getQuantity()));
    }
}
