package com.automation.components;

import java.util.List;

public interface Address {

	String getTitle();
	
	boolean isAddressHeadingDispalyed();
	
	String getName();
	
	List<String> getAddressLines();
	
	String getCity();
	
	String getCountry();
	
	String getPhone();
}
