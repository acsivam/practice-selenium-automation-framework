package com.automation.pages;

import java.time.Month;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.utils.ElementUtils;

public class SignupPage extends BasePage{
	
	private ElementUtils eleUtil;
	
	public SignupPage(WebDriver driver) {
		super(driver);
	}
	
	private By accountInfoHeading	= By.xpath("//b[normalize-space()='Enter Account Information']");
	private By titleMrField			= By.xpath("//label[@for='id_gender1']");
	private By titleMrsField		= By.xpath("//label[@for='id_gender2']");
	private By nameField			= By.xpath("//input[@id='name']");
	private By emailField			= By.xpath("//input[@id='email']");
	private By passwordField		= By.xpath("//input[@id='password']");
	private By dayDropdown			= By.xpath("//select[@id='days']");
	private By monthDropdown		= By.xpath("//select[@id='months']");
	private By yearDropdown			= By.xpath("//select[@id='years']");
	private By newsletterCheckbox	= By.xpath("//label[@for='newsletter']");
	private By offerCheckbox		= By.xpath("//label[@for='newsletter']");
	private By addressInfoHeading	= By.xpath("//b[normalize-space()='Address Information']");
	private By firstNameField		= By.xpath("//input[@id='first_name']");
	private By lastNameField		= By.xpath("//input[@id='last_name']");
	private By companyField			= By.xpath("//input[@id='company']");
	private By addressField1		= By.xpath("//input[@id='address1']");
	private By addressField2		= By.xpath("//input[@id='address2']");
	private By countryDropdown		= By.xpath("//select[@id='country']");
	private By stateField			= By.xpath("//input[@id='state']");
	private By cityfield			= By.xpath("//input[@id='city']");
	private By zipCodeField			= By.xpath("//input[@id='zipcode']");
	private By mobileNumberField	= By.xpath("//input[@id='mobile_number']");
	private By createAccountButton	= By.xpath("//button[normalize-space()='Create Account']");

	
	public boolean isAccountInfoHeadingDisplayed() {
		return eleUtil.isDisplayed(accountInfoHeading);
	}
	
	public String getAccountInfoHeading() {
		return eleUtil.getText(accountInfoHeading);
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
	
	public void enterEmail(String email) {
		eleUtil.enterText(emailField, email);
	}
	
	public void enterPassword(String password) {
		eleUtil.enterText(passwordField, password);
	}
	
	public void selectDateOfBirth(String day, String month, String year) {
		eleUtil.selectByVisibleText(dayDropdown, day);
		eleUtil.selectByVisibleText(monthDropdown, month);
		eleUtil.selectByVisibleText(yearDropdown, year);
	}
	
	public void selectNewsLetter(boolean value) {
		if(value) {
			eleUtil.click(newsletterCheckbox);
		}
	}
	
	public void selectOffers(boolean value) {
		if(value) {
			eleUtil.click(offerCheckbox);
		}
	}
	
	public boolean isAddressInfoHeadingDisplayed() {
		return eleUtil.isDisplayed(addressInfoHeading);
	}
	
	public String getAddressInfoHeading() {
		return eleUtil.getText(addressInfoHeading);
	}
	
	public void enterFirstName(String firstName) {
		eleUtil.enterText(firstNameField, firstName);
	}
	
	public void enterLastName(String lastName) {
		eleUtil.enterText(lastNameField, lastName);
	}
	
	public void enterCompany(String company) {
		eleUtil.enterText(companyField, company);
	}
	
	public void enterAddress1(String address) {
		eleUtil.enterText(addressField1, address);
	}
	
	public void enterAddress2(String address) {
		eleUtil.enterText(addressField2, address);
	}
	
	public void selectCountry(String country) {
		eleUtil.selectByVisibleText(countryDropdown, country);
	}
	
	public void enterState(String state) {
		eleUtil.enterText(stateField, state);
	}
	
	public void enterCity(String city) {
		eleUtil.enterText(cityfield, city);
	}
	
	public void enterZipCode(String zipCode) {
		eleUtil.enterText(zipCodeField, zipCode);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		eleUtil.enterText(mobileNumberField, mobileNumber);
	}
	
	public void clickCreateAccount() {
		eleUtil.click(createAccountButton);
	}
	
	public void fillAccountInfo(
			String name,
			String email,
			String password,
			String day,
			String month,
			String year,
			boolean newsletter,
			boolean offers) {
		enterName(name);
		enterEmail(email);
		enterPassword(password);
		selectDateOfBirth(day, month, year);
		selectNewsLetter(newsletter);
		selectOffers(offers);
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
		enterCity(city);
		enterZipCode(zipCode);
		enterMobileNumber(mobileNumber);
	}
	
	public AccountCreatedPage createAccount(
			String name,
			String email,
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
		fillAccountInfo(name, email, password, day, month, year, newsletter, offers);
		fillAddressInfo(firstName, lastName, company, address1, address2,	country, state, city, zipCode, mobileNumber);
		return new AccountCreatedPage(driver);
	}
	

}
