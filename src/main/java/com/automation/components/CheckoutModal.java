package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.CartPage;
import com.automation.pages.LoginPage;

public class CheckoutModal extends BaseComponent{

	public CheckoutModal(WebDriver driver) {
		super(driver);
	}

	private By checkoutModal			= By.cssSelector(".modal-content");
	private By checkoutHeading 			= By.xpath("//h4[@class='modal-title w-100']");
	private By checkoutBody				= By.xpath(")//p[normalize-space()='Register / Login account to proceed on checkout.']");
	private By registerLoginLink		= By.xpath("//u[normalize-space()='Register / Login']");
	private By continueOnCartButton		= By.xpath("//button[@class='btn btn-success close-checkout-modal btn-block']");
	
	public boolean isDiplayed() {
		return eleUtil.isDisplayed(checkoutModal);
	}
	
	public String getCheckoutHeading() {
		return eleUtil.getElement(checkoutHeading).getText();
	}
	
	public String getCheckoutMessage() {
		return eleUtil.getText(checkoutBody);
	}
	
	public LoginPage clickRegisterLogin() {
		eleUtil.click(registerLoginLink);
		return new LoginPage(driver);
	}
	
	public CartPage continueOnCart() {
		eleUtil.click(continueOnCartButton);
		return new CartPage(driver);
	}
}
