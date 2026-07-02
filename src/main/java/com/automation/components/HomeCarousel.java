package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeCarousel extends BaseComponent{

	public HomeCarousel(WebDriver driver) {
		super(driver);
	}
	
	private By carousel 		= By.cssSelector(".carousel-inner");
	private By activeSlide 		= By.cssSelector(".carousel-inner .item.active");
	private By nextButton 		= By.cssSelector(".left-control");
	private By previousButton 	= By.cssSelector(".right-control");
	private By testCasesButton 	= By.cssSelector(".test_cases_list");
	private By apiListButton 	= By.cssSelector(".apis_list");

	public boolean isDisplayed() {
		return eleUtil.isDisplayed(carousel);
	}

	public int getSlideCount() {
		return eleUtil.getCount(carousel);
	}

	public String getActiveHeading() {
		return eleUtil.getText(activeSlide);
	}

	public String getActiveSubHeading() {
		return "save";
	}

	public String getActiveDescription() {
		return "save";
	}
	
	public void next() {
		eleUtil.click(nextButton);
	}

	public void previous() {
		eleUtil.click(previousButton);
	}

	/*
	public TestCasesPage clickTestCases() {
		return new TestCasesPage(driver);
	}

	public ApiPage clickApiList() {
		
	}
	*/
}
