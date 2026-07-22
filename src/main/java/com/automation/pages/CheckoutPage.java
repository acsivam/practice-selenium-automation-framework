package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CartTable;
import com.automation.components.CheckoutInformation;
import com.automation.components.OrderCommentComponent;
import com.automation.constants.AppConstants;

public class CheckoutPage extends BasePage{
	
	private CartTable cartTable;
	private CheckoutInformation checkoutInfo;
    private OrderCommentComponent orderComment;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.cartTable 		= new CartTable(driver);
		this.checkoutInfo 	= new CheckoutInformation(driver);
	}
	
	
	//private By reviewOrderHeading	= By.xpath("//h2[normalize-space()='Review Your Order']");
	private By placeOderButton		= By.xpath("//a[@class='btn btn-default check_out']");
	
	 
	
	public CartTable getCartTable() {
		return cartTable;
	}
	
	public CheckoutInformation getCheckoutInformation() {
		return checkoutInfo;
	}
	
	public OrderCommentComponent getOrderCommentSection() {
		return orderComment;
	}
	
	public PaymentPage placeOder() {
		eleUtil.getElement(placeOderButton).click();
		return new PaymentPage(driver);
	}
	
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.CHECKOUT_PAGE_PATH)
				&& getCheckoutInformation().isDisplayed();
	}
	
	/*
	public List<String> getDelliveryAddress(){
		return eleUtil.getElementsText(deliveryAddressLines);
	}
	*/
}

