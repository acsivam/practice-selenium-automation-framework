package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;

public class PaymentConfimationPage extends BasePage{

	public PaymentConfimationPage(WebDriver driver) {
		super(driver);
	}
	
	
	private By confirmationHeading 	= By.xpath("//b[normalize-space()='Order Placed!']");
	

}
