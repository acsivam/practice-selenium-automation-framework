package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CartTable;
import com.automation.components.CheckoutInformation;

public class CheckoutPage extends BasePage{
	
	private CartTable cartTable;
	private CheckoutInformation checkoutInfo;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.cartTable 		= new CartTable(driver);
		this.checkoutInfo 	= new CheckoutInformation(driver);
	}
	
	private By addressHeading 		= By.xpath("//h2[normalize-space()='Address Details']");
	//private By deliveryAddressBox	= By.id("address_delivery");
	//private By deliveryAddressLines = By.cssSelector("#address_delivery li:not(.address_title)");
	
	private By reviewOrderHeading	= By.xpath("//h2[normalize-space()='Review Your Order']");
	private By messageField			= By.xpath("//textarea[@name='message']");
	private By placeOderButton		= By.xpath("//a[@class='btn btn-default check_out']");
	
	
	
	public CartTable getCartTable() {
		return cartTable;
	}
	
	public CheckoutInformation getCheckoutInformation() {
		return checkoutInfo;
	}
	
	public boolean isAddresseadingDisplayed() {
		return eleUtil.isDisplayed(addressHeading);
	}
	
	public String getAddressHeading() {
		return eleUtil.getText(addressHeading);
	}
	
	public boolean isReviewOrderHeadingDisplayed() {
		return eleUtil.isDisplayed(reviewOrderHeading);
	}
	
	public String getReviewOrderHeading() {
		return eleUtil.getText(reviewOrderHeading);
	}
	
	public void enterMessage(String message) {
		eleUtil.getElement(messageField).sendKeys(message);
	}
	
	public PaymentPage placeOder() {
		eleUtil.getElement(placeOderButton).click();
		return new PaymentPage(driver);
	}
	
	/*
	public List<String> getDelliveryAddress(){
		return eleUtil.getElementsText(deliveryAddressLines);
	}
	*/
}

