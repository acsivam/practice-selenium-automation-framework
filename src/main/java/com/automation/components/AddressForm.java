package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.models.User;

public class AddressForm extends BaseComponent{

	public AddressForm(WebDriver driver) {
		super(driver);
	}
	
	private By heading 		= By.xpath("//h2[.='Address Information']");
	
	private By firstNameField    = By.cssSelector("[data-qa='first_name']");
	private By lastNameField     = By.cssSelector("[data-qa='last_name']");
	private By companyField      = By.cssSelector("[data-qa='company']");
	private By addressField1     = By.cssSelector("[data-qa='address']");
	private By addressField2     = By.cssSelector("[data-qa='address2']");
	private By countryDropdown   = By.cssSelector("[data-qa='country']");
	private By stateField        = By.cssSelector("[data-qa='state']");
	private By cityField         = By.cssSelector("[data-qa='city']");
	private By zipcodeField      = By.cssSelector("[data-qa='zipcode']");
	private By mobileNumberField = By.cssSelector("[data-qa='mobile_number']");
	
	
	public boolean isHeadingDisplayed() {
		return eleUtil.isDisplayed(heading);
	}
	
	public String getAddressInfoHeading() {
		return eleUtil.getText(heading);
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
		eleUtil.enterText(cityField, city);
	}
	
	public void enterZipCode(String zipCode) {
		eleUtil.enterText(zipcodeField, zipCode);
	}
	
	public void enterMobileNumber(String mobileNumber) {
		eleUtil.enterText(mobileNumberField, mobileNumber);
	}
	
	public void fill(User user) {
	    enterFirstName(user.getFirstName());
	    enterLastName(user.getLastName());

	    enterCompany(user.getCompany());

	    enterAddress1(user.getAddress1());
	    enterAddress2(user.getAddress2());

	    selectCountry(user.getCountry());

	    enterState(user.getState());
	    enterCity(user.getCity());
	    enterZipCode(user.getZipcode());

	    enterMobileNumber(user.getMobile());
	}

}
