package com.automation.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.base.BasePage;

public class CheckoutPage extends BasePage{

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	
	private By addressHeading 		= By.xpath("//h2[normalize-space()='Address Details']");
	private By deliveryAddressBox	= By.id("address_delivery");
	private By deliveryAddressLines = By.cssSelector("#address_delivery li:not(.address_title)");
	private By messageField			= By.xpath("//textarea[@name='message']");
	private By placeOderButton		= By.xpath("//a[@class='btn btn-default check_out']");
	
	public List<String> getDelliveryAddress(){
		return eleUtil.getElementsText(deliveryAddressLines);
	}
	
	public void enterMessage(String message) {
		eleUtil.getElement(messageField).sendKeys(message);
	}
	
	public PaymentPage placeOder() {
		eleUtil.getElement(placeOderButton).click();
		return new PaymentPage(driver);
	}
}

