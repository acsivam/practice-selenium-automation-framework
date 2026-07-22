package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automation.base.BaseComponent;

public class Advertisement extends BaseComponent{

    public Advertisement(WebDriver driver) {
		super(driver);
	}

    private By container = By.id("advertisement");
    private By saleImage = By.id("sale_image");

    @Override
    public boolean isDisplayed() {
    	return eleUtil.waitForVisibility(container).isDisplayed();
    }
    
    public boolean isAdvertisementDisplayed() {
        return eleUtil.waitForVisibility(saleImage).isDisplayed();
    }
}
