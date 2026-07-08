package com.automation.tests;

public class ProductSearchTest {

	public ProductSearchTest() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * TC_004: Search product with valid product name

Test Data

Blue Top

Steps

Navigate to Products page
Enter product name in search box
Click Search
Verify searched product is displayed

Expected

Matching product is displayed
TC_005: Search product with partial product name

Test Data

Blue

Steps

Navigate to Products page
Search using partial name

Expected

Products containing "Blue" are displayed
TC_006: Search product with invalid product name

Test Data

XYZ123

Steps

Navigate to Products page
Search invalid product

Expected

No products displayed / empty result message
	 * 
	 *  
	 */
}
