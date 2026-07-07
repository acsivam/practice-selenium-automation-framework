package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.pages.TestCasesPage;

public class HomeCarousel extends BaseComponent{

	public HomeCarousel(WebDriver driver) {
		super(driver);
	}
	
	private By carousel 			= By.cssSelector(".carousel-inner");
	private By carouselSlides 		= By.cssSelector(".carousel-inner .item");
	private By activeSlide			= By.cssSelector(".carousel-inner .item.active");
	private By heading 				= By.tagName("h1"); //By.cssSelector(".carousel-inner .item.active h1");
	private By subHeading 			= By.tagName("h2");
	private By description 			= By.tagName("p");
	private By nextButton 			= By.cssSelector(".left-control");
	private By previousButton 		= By.cssSelector(".right-control");
	private By testCasesButton 		= By.cssSelector(".test_cases_list");
	private By apiListButton 		= By.cssSelector(".apis_list");

	public boolean isDisplayed() {
		return eleUtil.isDisplayed(carousel);
	}

	public int getCarouselSlideCount() {
		return eleUtil.getCount(carouselSlides);
	}

	private WebElement getActiveSlide() {
	    return eleUtil.getElement(activeSlide);
	}
	
	public String getActiveSlideHeading() {
		return getActiveSlide().findElement(heading).getText();
	}

	public String getActiveSlideSubHeading() {
		return getActiveSlide().findElement(subHeading).getText();
	}

	public String getActiveSlideDescription() {
		return getActiveSlide().findElement(description).getText();
	}
	
	public void moveToNextSlide() {
		eleUtil.click(nextButton);
	}

	public void moveTPpreviousSlide() {
		eleUtil.click(previousButton);
	}

	public TestCasesPage clickTestCases() {
		eleUtil.click(testCasesButton);
		return new TestCasesPage(driver);
	}

	/*
	public ApiPage clickApiList() {
		
	}
	*/
	

}
