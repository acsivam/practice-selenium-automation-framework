package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class PaymentPage extends BasePage{

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	
	private By paymentHeading 			= By.xpath("//h2[@class='heading']");
	private By nameField				= By.xpath("//input[@name='name_on_card']");
	private By cardNumberField			= By.xpath("//input[@name='card_number']");
	private By cvcField					= By.xpath("//input[@placeholder='ex. 311']");
	private By expirationMonth			= By.xpath("//input[@placeholder='MM']");
	private By expirationYear			= By.xpath("//input[@placeholder='YYYY']");
	private By payButton				= By.xpath("//button[@id='submit']");
	private By paymentSuccessMessage 	=	By.xpath("//div[contains(text(),'Your order has been placed successfully!')]");
	
	
	public boolean isPaymentHeadingDisplayed() {
		return eleUtil.isDisplayed(paymentHeading);
	}
	
	public void enterName(String name) {
		eleUtil.getElement(nameField).sendKeys(name);
	}
	
	public void enterCardnumber(String cardNumber) {
		eleUtil.getElement(cardNumberField).sendKeys(cardNumber);
	}
	
	public void enterCVC(String cvc) {
		eleUtil.getElement(cvcField).sendKeys(cvc);
	}
	
	public void enterExpirationMonth(String month) {
		eleUtil.getElement(expirationMonth).sendKeys(month);
	}
	
	public void enterExpirationYear(String year) {
		eleUtil.getElement(expirationYear).sendKeys(year);
	}
	
	public void clickPay() {
		eleUtil.click(payButton);
	}
	
	public String getpaymentSuccessMessage() {
		return eleUtil.waitForVisibility(paymentSuccessMessage).getText();
	}
	
	public PaymentConfimationPage fillPyamentDetails(String name, String cardNumber, String cvc, String month, String year) {
		enterName(name);
		enterCardnumber(cardNumber);
		enterCVC(cvc);
		enterExpirationMonth(month);
		enterExpirationYear(year);
		clickPay();
		return new PaymentConfimationPage(driver);
	}
	
	public PaymentConfimationPage waitForPaymentConfirmationPage() {
		driver.getCurrentUrl().contains("payment_done");
	    return new PaymentConfimationPage(driver);
	}
}
