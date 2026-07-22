package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.SignupAddressForm;
import com.automation.components.SignupAccountForm;
import com.automation.constants.AppConstants;
import com.automation.models.User;

public class SignupPage extends BasePage{
	
	private SignupAccountForm signupAccountForm;
	private SignupAddressForm addressForm;
	
	public SignupPage(WebDriver driver) {
		super(driver);
		this.signupAccountForm = new SignupAccountForm(driver);
		this.addressForm = new SignupAddressForm(driver);
	}
	
	
	
	private By createAccountButton 		= By.cssSelector("[data-qa='create-account']");
	
	
	public SignupAccountForm getSignupAccountForm() {
		return signupAccountForm;
	}
	
	public SignupAddressForm getAddressForm() {
		return addressForm;
	}
	
	public void clickCreateAccount() {
		eleUtil.click(createAccountButton);
	}
	
	public boolean isLoaded() {
		return getCurrentUrl().contains(AppConstants.SIGNUP_PAGE_PATH)
				&& getSignupAccountForm().isDisplayed();
	}
			
	public AccountCreatedPage createAccount(User user) {
		getSignupAccountForm().fill(user);
	    getAddressForm().fill(user);
	    clickCreateAccount();
	    logger.info("User created : {}, naviagating ", user.getEmail());
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
