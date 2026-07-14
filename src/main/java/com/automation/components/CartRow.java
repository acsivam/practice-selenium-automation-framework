package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseComponent;

public class CartRow extends BaseComponent {

	private WebElement row;
	
	public CartRow(WebDriver driver, WebElement row) {
		super(driver);
		this.row = row;
	}
	
	private By name 		= By.cssSelector(".cart_description h4");
	private By category 	= By.cssSelector(".cart_description p");
	private By price 		= By.cssSelector(".cart_price p");
	private By quantity 	= By.cssSelector(".cart_quantity button");
	private By total 		= By.cssSelector(".cart_total_price");
	private By removeButton	= By.cssSelector(".cart_quantity_delete");
	
	
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
        row.findElement(removeButton).click();
    }
}
