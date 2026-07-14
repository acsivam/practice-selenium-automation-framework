package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.BaseTest;
import com.automation.driver.DriverManager;
import com.automation.pages.HomePage;
import com.automation.pages.ProductDetailsPage;
import com.automation.pages.ProductsPage;

@Test
public class ProductsPageTest extends BaseTest{
	
	
	@Test
	public void TC001_Verify_Products_Page_Is_Displayed() {
		logger.info("*** Starting TC001_Verify_Products_Page_Is_Displayed");
		
		HomePage homePage = new HomePage(DriverManager.getDriver());
		ProductsPage productsPage = homePage.getTopMenu().goToProductsPage();
		System.out.println(productsPage.getProductGrid().getHeading());
		Assert.assertEquals(
				productsPage.getProductGrid().getHeading(), "ALL PRODUCTS");
		
		Assert.assertTrue(
				productsPage.getProductGrid().isDisplayed(), "ProductGrid is not displaying");
		
		logger.info("*** Finished TC001_Verify_Products_Page_Is_Displayed");
	}
	
	
	@Test
	public void TC002_Verify_Total_Products_Displayed() {

		HomePage homePage = new HomePage(DriverManager.getDriver());
		ProductsPage productsPage = homePage.getTopMenu().goToProductsPage();
		
		Assert.assertTrue(
				productsPage.getProductGrid().getProductCount() > 0, "No products displayed");
	}
	
	
	@Test
	public void TC003_Verify_Product_Information_Is_Displayed() {
		
		SoftAssert softAssert = new SoftAssert();
		HomePage homePage = new HomePage(DriverManager.getDriver());
		
		ProductsPage productsPage = 
				homePage.getTopMenu().goToProductsPage();
		
		ProductDetailsPage productDetailsPage = 
				productsPage.getProductGrid().getProductById("1").clickViewProduct();
		
		softAssert.assertEquals(
				productDetailsPage.getProductInformation().getProductName(), "Blue Top");
		softAssert.assertEquals(
				productDetailsPage.getProductInformation().getPrice(), "Rs. 500");
		
		softAssert.assertTrue(
				productDetailsPage.getProductImage().isProductImageDisplayed(), "No image displauyed");
		
		softAssert.assertAll();
	}
	

}
