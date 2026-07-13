package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.AccountDeletedPage;
import com.automation.pages.CartPage;
import com.automation.pages.ContactUsPage;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import com.automation.pages.TestCasesPage;

public class TopMenuComponent extends BaseComponent{

	public TopMenuComponent(WebDriver driver) {
		super(driver);
	}
	
	private By topMenu				= By.cssSelector(".nav.navbar-nav");
	private By homeMenu				= By.xpath("//a[normalize-space()='Home']'");
	private By productsMenu			= By.xpath("//a[@href='/products']");
	private By cartMenu				= By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]");
	private By loginMenu			= By.xpath("//a[normalize-space()='Signup / Login']");
	private By testCasesMenu		= By.xpath("//a[contains(text(),'Test Cases')]");
	private By apiTestingMenu		= By.xpath("//a[normalize-space()='API Testing']");
	private By videoTutorialsMenu	= By.xpath("//a[normalize-space()='Video Tutorials']");
	private By contactUsMenu		= By.xpath("//a[normalize-space()='Contact us']");
	private By logoutMenu			= By.xpath("//a[normalize-space()='Logout']");
	private By loginAs				= By.xpath("//li[10]//a[1]");
	private By deleteAccountMenu	= By.xpath("//a[normalize-space()='Delete Account']");

	
	public boolean isDisplayed() {
		return eleUtil.isDisplayed(topMenu);
	}
	
	public void goToHomePage() {
		eleUtil.click(homeMenu);
	}
	
	public ProductsPage goToProductsPage() {
		eleUtil.click(productsMenu);
		return new ProductsPage(driver);
	}
	
	public CartPage goToCartPage() {
		eleUtil.click(cartMenu);
		return new CartPage(driver);
	}
	
	public LoginPage goToLoginPage() {
		//driver.findElement(loginMenu).click();
		eleUtil.click(loginMenu);
		return new LoginPage(driver);
	}
	
	public TestCasesPage goToTestCasesPage() {
		eleUtil.click(testCasesMenu);
		return new TestCasesPage(driver);
	}
	
	public void goToVideoTutorials() {
		eleUtil.click(videoTutorialsMenu);
	}
	
	public void goToAPITutorailsMenu() {
		eleUtil.click(apiTestingMenu);
	}
	
	public ContactUsPage goToContactUsPage() {
		eleUtil.click(contactUsMenu);
		return new ContactUsPage(driver);
	}
	
	public LoginPage logout() {
		eleUtil.click(logoutMenu);
		return new LoginPage(driver);
	}
	
	public boolean isLoginAsDisplayed() {
		return eleUtil.isDisplayed(loginAs);
	}
	
	public String loggedInAs() {
		return eleUtil.getText(loginAs);
	}
	
	public AccountDeletedPage deleteAccount() {
		eleUtil.click(deleteAccountMenu);
		return new AccountDeletedPage(driver);
	}
}
