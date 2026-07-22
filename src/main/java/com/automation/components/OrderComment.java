package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;

public class OrderComment extends BaseComponent{	
	
	public OrderComment(WebDriver driver) {
		super(driver);
	}


	private By container 	= By.id("ordermsg");
	private By label    	= By.tagName("label");
	private By commentField = By.name("message");
	// or By.cssSelector("textarea[name='message']");
	
	
	@Override
	public boolean isDisplayed() {
		return eleUtil.waitForVisibility(container).isDisplayed();
	}

	public String getLabel() {
		return eleUtil.getText(label);
	}

	public void enterComment(String comment) {
		eleUtil.enterText(commentField, comment);
	}

	public String getComment() {
		return eleUtil.getAttribute(commentField, "value");
	}
}
