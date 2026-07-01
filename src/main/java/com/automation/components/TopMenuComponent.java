package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.pages.LoginPage;

public class TopMenuComponent {

	private WebDriver driver;
	
	public TopMenuComponent(WebDriver driver) {
		this.driver = driver;
	}
	
	private By homeMenu				= By.xpath("//a[normalize-space()='Home']'");
	private By productsMenu			= By.xpath("//a[@href='/products']");
	private By cartMenu				= By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[3]/a[1]");
	private By loginMenu			= By.xpath("//a[normalize-space()='Signup / Login']");
	private By testCasesMenu		= By.xpath("//a[contains(text(),'Test Cases')]");
	private By apiTestingMenu		= By.xpath("//a[normalize-space()='API Testing']");
	private By videoTutorialsMenu	= By.xpath("//a[normalize-space()='Video Tutorials']");
	private By contactUsMenu		= By.xpath("//a[normalize-space()='Contact us']");
	private By logoutMenu			= By.xpath("//a[normalize-space()='Logout']");
	
	
	public void goToHomePage() {
		driver.findElement(homeMenu).click();
	}
	
	public void goToProductsPage() {
		driver.findElement(homeMenu).click();
	}
	
	public void viewCart() {
		driver.findElement(cartMenu).click();
	}
	
	public void goToLoginPage() {
		driver.findElement(loginMenu).click();
	}
	
	public void goToTestCasesPage() {
		driver.findElement(testCasesMenu).click();
	}
	
	public void goToVideoTutorials() {
		driver.findElement(videoTutorialsMenu).click();
	}
	
	public void goToAPITutorailsMenu() {
		driver.findElement(apiTestingMenu).click();
	}
	
	public void goToContactUsPage() {
		driver.findElement(contactUsMenu).click();
	}
	
	public LoginPage logout() {
		return new LoginPage(driver);
	}
}
