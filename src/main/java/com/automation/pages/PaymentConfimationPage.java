package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.constants.AppConstants;

public class PaymentConfimationPage extends BasePage{

	public PaymentConfimationPage(WebDriver driver) {
		super(driver);
	}
	
	private By paymentConfirmationContainer	= By.id("form");
	private By orderPlacedHeading 			= By.cssSelector("[data-qa='order-placed']");
	private By successMessage 				= By.cssSelector("h2[data-qa='order-placed'] + p");
	//private By successMessage 			= By.xpath("//h2[@data-qa='order-placed']/following-sibling::p[1]");
	private By downloadInvoiceButton 		= By.cssSelector("a[href*='download_invoice']");
	private By continueButton 				= By.cssSelector("[data-qa='continue-button']");
	
	
	public boolean isPaymentConfirmationContainerDisplayed() {
		return eleUtil.isDisplayed(paymentConfirmationContainer);
	}
	
	public boolean isOrderPlacedHeadingDisplayed() {
	    return eleUtil.isDisplayed(orderPlacedHeading);
	}

	public String getSuccessMessage() {
	    return eleUtil.getText(successMessage);
	}

	public void downloadInvoice() {
	    eleUtil.click(downloadInvoiceButton);
	}

	public HomePage clickContinue() {
	    eleUtil.click(continueButton);
	    return new HomePage(driver);
	}
	
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.PAYMENT_CONFIRMATION_PAGE_PATH)
				&& isPaymentConfirmationContainerDisplayed();
	}

}
