package com.automation.assertions;

import java.util.List;

import org.testng.Assert;

import com.automation.components.Address;
import com.automation.models.User;

public class AddressAssertions {
	
	private Address address;
	
	public AddressAssertions(Address address) {
		this.address = address;
	}

	
	public static AddressAssertions verifyThat(Address address) {
		return new AddressAssertions(address);
	}
	
	public AddressAssertions hasHeader(String expectedHeader) {
		Assert.assertTrue(
				address.isAddressHeadingDispalyed(),
				"Header should be displayed"
				);
				
		Assert.assertEquals(
				address.getTitle(), expectedHeader,
				"Header mismatch"
				);
		
		return this;
	}
	
	public AddressAssertions hasFullName(User user) {
		String expectedName = 
				user.getTitle() 
				+ ". " + user.getFirstName() 
				+ " " + user.getLastName();
						
		Assert.assertEquals(
				address.getName(),expectedName,
				"Customer name mismatch"
				);
		return this;
	}
	
	public AddressAssertions hasAddressLines(User user) {
		List<String> expextedAddressLines = List.of(
						user.getCompany(),
						user.getAddress1(),
						user.getAddress2()
						);	
						
		Assert.assertEquals(
				address.getAddressLines(),
				expextedAddressLines,
				"Address lines mismatch"
				);
		return this;
	}
	
	public AddressAssertions hasCity(User user) {
		String expextedCity = 
				user.getCity() 
				+ " " + user.getState() 
				+ " " + user.getZipcode();
		
		Assert.assertEquals(
				address.getCity(), 
				expextedCity, 
				"City mismatch"
				);
		return this;
	}
	
	public AddressAssertions hasCountry(User user) {
		String expectedCountry = user.getCountry();
		
		Assert.assertEquals(
				address.getCountry(), 
				expectedCountry, 
				"Country mismatch"
				);
		return this;
	}
	
	public AddressAssertions hasDefaultAddressInfo (User user) {
		hasFullName(user);
		hasAddressLines(user);
		hasCity(user);
		hasCountry(user);
		hasPhone(user);
		return this;
	}

	public AddressAssertions hasPhone(User user) {
		String expectedPhone = user.getMobile();
		
		Assert.assertEquals(
				address.getPhone(), 
				expectedPhone, 
				"Phone number mismatch"
				);
		return this;
	}
	
}
