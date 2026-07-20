package com.automation.components;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BaseComponent;
import com.automation.pages.CartPage;

public class CartModal extends BaseComponent{
	
	public CartModal(WebDriver driver) {
		super(driver);
	}
	
	
	private By addedToCartModal 		= By.cssSelector("#cartModal.show"); 
	private By continueShoppingButton	= By.xpath("//button[@class='btn btn-success close-modal btn-block']"); 
	private By viewCartLink 			= By.xpath("//u[normalize-space()='View Cart']"); // By.linkText("View Cart"); 
	private By addedTitle				= By.cssSelector("#cartModal .modal-title");
	private By addedMessage 			= By.cssSelector("#cartModal .modal-body p");

	
	@Override
	public boolean isDisplayed() { //container itself uniquely identifies the component
		return eleUtil.waitForVisibility(addedToCartModal).isDisplayed();
	}
	
	public String getAddedTitle() {
		return eleUtil.getText(addedTitle);
	}
	
	public String getAddedMessage() {
		return eleUtil.getText(addedMessage);
	}
	
	public boolean isViewCartDisplayed() {
		return eleUtil.isDisplayed(viewCartLink);
	}
	
	public CartPage viewCart() {
		eleUtil.click(viewCartLink);
		return new CartPage(driver);
	}
	
	public boolean isContinueShoppingDisplayed() {
		return eleUtil.isDisplayed(continueShoppingButton);
	}
	
	public void continueShopping() {
		eleUtil.click(continueShoppingButton);
	}
}
