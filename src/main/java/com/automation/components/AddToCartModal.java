package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.CartPage;

public class AddToCartModal extends BaseComponent{
	
	public AddToCartModal(WebDriver driver) {
		super(driver);
	}
	
	
	private By addedToCartModal 		= By.cssSelector("#cartModal.show"); 
	private By continueShoppingButton	= By.xpath("//button[@class='btn btn-success close-modal btn-block']"); 
	private By viewCartLink 			= By.xpath("//u[normalize-space()='View Cart']");
	private By addedTitle				= By.cssSelector("#cartModal .modal-title");
	private By addedMessage 			= By.cssSelector("#cartModal .modal-body p");

	
	public boolean isDisplayed() {
		return eleUtil.isDisplayed(addedToCartModal);
	}
	
	public String getAddedTitle() {
		return eleUtil.getText(addedTitle);
	}
	
	public String getAddedMessage() {
		return eleUtil.getText(addedMessage);
	}
	
	public void continueShopping() {
		eleUtil.click(continueShoppingButton);
	}
	
	public CartPage viewCart() {
		eleUtil.click(viewCartLink);
		return new CartPage(driver);
	}
}
