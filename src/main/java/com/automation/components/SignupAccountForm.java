package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupAccountForm extends BaseComponent{

	public SignupAccountForm(WebDriver driver) {
		super(driver);
	}
	
	private By heading 			= By.xpath("//h2[.='Enter Account Information']");

	private By titleMrField    	= By.id("id_gender1");
	private By titleMrsField   	= By.id("id_gender2");

	private By nameField       	= By.cssSelector("[data-qa='name']");
	private By emailField      	= By.cssSelector("[data-qa='email']");
	private By passwordField  	= By.cssSelector("[data-qa='password']");

	private By dayDropdown     	= By.cssSelector("[data-qa='days']");
	private By monthDropdown   	= By.cssSelector("[data-qa='months']");
	private By yearDropdown   	= By.cssSelector("[data-qa='years']");

	private By newsletter   	= By.id("newsletter");
	private By specialOffers	= By.id("optin");
	
	
	public boolean isHeadingDisplayed() {
		return eleUtil.isDisplayed(heading);
	}
	
	public String getHeading() {
		return eleUtil.getText(heading);
	}
	
	public void selectTitle(String title) {
		if(title.equalsIgnoreCase("mr")) {
			eleUtil.click(titleMrField);
		}else {
			eleUtil.click(titleMrsField);
		}
	}
	
	public void enterName(String name) {
		eleUtil.enterText(nameField, name);
	}
	
	public void enterPassword(String password) {
		eleUtil.enterText(passwordField, password);
	}
	
	public void selectDateOfBirth(String day, String month, String year) {
		eleUtil.selectByVisibleText(dayDropdown, day);
		eleUtil.selectByVisibleText(monthDropdown, month);
		eleUtil.selectByVisibleText(yearDropdown, year);
	}
	
	public void subscribeToNewsletter(boolean value) {
		if(value) {
			eleUtil.click(newsletter);
		}
	}
	
	public void receiveSpecialOffers(boolean value) {
		if(value) {
			eleUtil.click(specialOffers);
		}
	}
}
