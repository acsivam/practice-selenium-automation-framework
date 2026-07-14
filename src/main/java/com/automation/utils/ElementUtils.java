package com.automation.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.base.DriverManager;
import com.automation.constants.AppConstants;

public class ElementUtils {
	
    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger;

	public ElementUtils(WebDriver driver) {
		this.driver = DriverManager.getDriver();
		this.wait	= new WebDriverWait(
				driver, 
				Duration.ofSeconds(AppConstants.DEFAULT_EXPLICIT_WAIT)
				);
		this.logger = LoggerUtil.getLogger(getClass());
	}
	
	// Get element (with wait)
	public WebElement getElement(By locator) {
		return driver.findElement(locator);
		
	}
	
	// Get elements
	public List<WebElement> getElements(By locator){
		return driver.findElements(locator);
	}
	
	// Click
	public void click(By locator) {
		// WebElement element = waitForClickable(locator);
		    try {
		    	//getElement(locator).click();
		        waitForClickable(locator);
		        return;
		    } catch (ElementClickInterceptedException e) {
		    	//waitForClickable(locator);
		    	logger.error("Couldn't click " + locator);
		    	jsClick(locator);
		    	return;
		    }
		
	}
	
	private void jsClick(By locator) {
		WebElement element = getElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);	
	}

	// Enter / Send keys
	public void enterText(By locator, String value) {
		WebElement e = waitForVisibility(locator);
		e.clear();
		e.sendKeys(value);
	}
	
	// Get text
	public String getText(By locator) {
		return waitForVisibility(locator).getText();
	}
	
	// Get elements text
	public List<String>  getElementsText(By locator) {
		List<String>  textList = new ArrayList<>();
		for(WebElement element : getElements(locator)) {
			textList.add(element.getText());
		}
		return textList;
	}
	
	// Is displayed
	public boolean isDisplayed(By locator) {
		return waitForVisibility(locator).isDisplayed();
	}
	
    // Is Element Present
    public boolean isPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }
    
    
	// Get attribute
    public String getAttribute(By locator, String attr) {
        return waitForVisibility(locator).getAttribute(attr);
    }
    
    // Count elements
    public int getCount(By locator) {
        return getElements(locator).size();
    }
    
    // Wait for presence (not visible)
    public WebElement waitForPresence(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    // Wait for visibility
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    // Wait for clickable
    public WebElement waitForClickable(By locator) {
    	return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    // upload file
    public void uploadFile(By locator, String filePath) {
    	WebElement e = waitForPresence(locator);
    	e.sendKeys(filePath);
    }
    
    public void selectByVisibleText(By locator, String value) {
        Select select = new Select(waitForVisibility(locator));
        select.selectByVisibleText(value);
    }
    
  
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
    
    public void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }
    
    public void moveToElement(By locator) {
        Actions actions = new Actions(driver);
        actions.moveToElement(waitForVisibility(locator)).perform();
    }
    
    public void scrollToElement(By locator) {
        WebElement element = waitForVisibility(locator);

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block:'center'});", element);
    }
    
    public boolean isSelected(By locator) {
        return getElement(locator).isSelected();
    }

}
