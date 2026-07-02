package com.automation.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {
	
    private WebDriver driver;
    private WebDriverWait wait;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
		this.wait	= new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	// 1. Get element (with wait)
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
		
	}
	
	// 2. Get elements
	public List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	// 3. Click
	public void click(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	// 4. Enter / Send keys
	public void enterText(By locator, String value) {
		WebElement e = getElement(locator);
		e.clear();
		e.sendKeys(value);
	}
	
	// 5. Get text
	public String getText(By locator) {
		return getElement(locator).getText();
	}
	
	public List<String>  getElementsText(By locator) {
		List<String>  textList = new ArrayList<>();
		
		for(WebElement element : getElements(locator)) {
			textList.add(element.getText());
		}
		
		return textList;
	}
	
	// 6. Is displayed
	public boolean isDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
    // 7. Is Element Present
    public boolean isPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
    
    
	// 8. Get attribute
    public String getAttribute(By locator, String attr) {
        return getElement(locator).getAttribute(attr);
    }
    
    // 9. Count elements
    public int getCount(By locator) {
        return getElements(locator).size();
    }
    
    // 10. Wait for presence (not visible)
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // 11. Wait for visibility
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public void uploadFile(By locator, String filePath) {
    	WebElement e = waitForPresence(locator);
    	e.sendKeys(filePath);
    }
    
    public void selectByVisibleText(By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(value);
    }
    
    public void moveToElement(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(getElement(locator)).perform();
    }

}
