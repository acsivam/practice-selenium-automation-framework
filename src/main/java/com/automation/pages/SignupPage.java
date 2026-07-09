package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.AddressForm;
import com.automation.components.SignupAccountForm;
import com.automation.models.User;

public class SignupPage extends BasePage{
	
	private SignupAccountForm signupAccountForm;
	private AddressForm addressForm;
	
	public SignupPage(WebDriver driver) {
		super(driver);
		this.signupAccountForm = new SignupAccountForm(driver);
		this.addressForm = new AddressForm(driver);
	}
	
	private By signupForm 			= By.cssSelector(".login-form");
	private By createAccountButton 	= By.cssSelector("[data-qa='create-account']");
	
	
	public SignupAccountForm getSignupAccountForm() {
		return signupAccountForm;
	}
	
	public AddressForm getAddressForm() {
		return addressForm;
	}
	
	public boolean isDisplayed() {
		return eleUtil.isDisplayed(signupForm);
	}
	
	public void clickCreateAccount() {
		eleUtil.click(createAccountButton);
	}
	
	public AccountCreatedPage createAccount(User user) {
		getSignupAccountForm().fill(user);
	    getAddressForm().fill(user);
	    clickCreateAccount();
	    return new AccountCreatedPage(driver);
	}
	/**/
	/*
	public void fillAccountInfo(
			String name,
			String password,
			String day,
			String month,
			String year,
			boolean newsletter,
			boolean offers) {
		enterName(name);
		enterPassword(password);
		selectDateOfBirth(day, month, year);
		subscribeToNewsletter(newsletter);
		receiveSpecialOffers(offers);
	}
	
	public void fillAddressInfo(
			String firstName,
			String lastName,
			String company,
			String address1,
			String address2,
			String country,
			String state,
			String city,
			String zipCode,
			String mobileNumber) {
		enterFirstName(firstName);
		enterLastName(lastName);
		enterCompany(company);
		enterAddress1(address1);
		enterAddress2(address2);
		selectCountry(country);
		enterState(state);
		enterCity(city);
		enterZipCode(zipCode);
		enterMobileNumber(mobileNumber);
	}
	
	public AccountCreatedPage createAccount(
			String name,
			String password,
			String day,
			String month,
			String year,
			boolean newsletter,
			boolean offers,
			String firstName,
			String lastName,
			String company,
			String address1,
			String address2,
			String country,
			String state,
			String city,
			String zipCode,
			String mobileNumber) {
		fillAccountInfo(name, password, day, month, year, newsletter, offers);
		fillAddressInfo(firstName, lastName, company, address1, address2,	country, state, city, zipCode, mobileNumber);
		clickCreateAccount();
		return new AccountCreatedPage(driver);
	}
	
	*/
}
