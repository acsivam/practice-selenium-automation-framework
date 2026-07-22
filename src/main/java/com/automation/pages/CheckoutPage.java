package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CartTable;
import com.automation.components.CheckoutInformation;
import com.automation.components.OrderComment;
import com.automation.constants.AppConstants;

public class CheckoutPage extends BasePage{
	
	private CartTable cartTable;
	private CheckoutInformation checkoutInfo;
    private OrderComment orderComment;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.cartTable 		= new CartTable(driver);
		this.checkoutInfo 	= new CheckoutInformation(driver);
		this.orderComment	= new OrderComment(driver);
	}
	
	//
	private By addressdetailsHeading 	= By.xpath("//h2[normalize-space()='Address Details']");
	private By reviewOrderHeading		= By.xpath("//h2[normalize-space()='Review Your Order']");
	private By placeOderButton			= By.xpath("//a[@class='btn btn-default check_out']");
	
	 
	public CartTable getCartTable() {
		return cartTable;
	}
	
	public CheckoutInformation getCheckoutInformation() {
		return checkoutInfo;
	}
	
	public OrderComment getOrderCommentSection() {
		return orderComment;
	}
	
	public boolean isAddresDetailsHeadingDisplayed() {
		return eleUtil.waitForVisibility(addressdetailsHeading).isDisplayed();
	}
	
	public String getAddressDetailsHeading() {
		return eleUtil.getText(addressdetailsHeading);
	}
	
	public boolean isRevieworderHeadingDisplayed() {
		return eleUtil.waitForVisibility(reviewOrderHeading).isDisplayed();
	}
	
	public String getReviewOrdersHeading() {
		return eleUtil.getText(reviewOrderHeading);
	}
	
	public PaymentPage placeOder() {
		eleUtil.getElement(placeOderButton).click();
		return new PaymentPage(driver);
	}
	
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.CHECKOUT_PAGE_PATH)
				&& getCheckoutInformation().isDisplayed();
	}
}

