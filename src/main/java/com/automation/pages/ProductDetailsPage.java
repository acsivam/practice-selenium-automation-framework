package com.automation.pages;

import org.openqa.selenium.WebDriver;

import com.automation.base.BasePage;
import com.automation.components.CategoryBrandSidebar;
import com.automation.components.ProductImage;
import com.automation.components.ProductInformation;
import com.automation.components.ReviewForm;

public class ProductDetailsPage extends BasePage{

	private CategoryBrandSidebar sidebar;
	private ProductImage productImage;
    private ProductInformation productInformation;
    private ReviewForm reviewForm;
    
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		
		this.sidebar = new CategoryBrandSidebar(driver);
		this.productImage = new ProductImage(driver);
        this.productInformation = new ProductInformation(driver);
        this.reviewForm = new ReviewForm(driver);
	}
	
	public CategoryBrandSidebar getSidebar() {
		return sidebar;
	}
	
    public ProductImage getProductImage() {
        return productImage;
    }

    public ProductInformation getProductInformation() {
        return productInformation;
    }

    public ReviewForm getReviewForm() {
        return reviewForm;
    }
    
    /*
	private By productName		= By.xpath("//h2[normalize-space()='Blue Top']");
	private By categoryName		= By.xpath("//p[normalize-space()='Category: Women > Tops']");
	private By price			= By.xpath("//p[normalize-space()='Category: Women > Tops']");
	private By quantityField	= By.xpath("//input[@id='quantity']");			
	private By addToCard		= By.xpath("//button[@type='button']");
	private By availablity		= By.xpath("//b[normalize-space()='Availability:']");
	private By condition		= By.xpath("//b[normalize-space()='Condition:']");
	private By brand			= By.xpath("//b[normalize-space()='Brand:']");
	
	public boolean isProductNameDisplayed() {
		return eleUtil.isDisplayed(productName);
	}

	public boolean isCategoryDisplayed() {
		return eleUtil.isDisplayed(categoryName);
	}
	
	public boolean isPriceDisplayed() {
		return eleUtil.isDisplayed(price);
	}

	public boolean isAvailabiltyDisplayed() {
		return eleUtil.isDisplayed(availablity);
	}

	public boolean isConditionDisplayed() {
		return eleUtil.isDisplayed(availablity);
	}
	
	public boolean isBrandDisplayed() {
		return eleUtil.isDisplayed(brand);
	}
	
	public boolean areProductDetailsDisplayed() {
		return isProductNameDisplayed()
		        && isCategoryDisplayed()
	            && isPriceDisplayed()
	            && isAvailabiltyDisplayed()
	            && isConditionDisplayed()
	            && isBrandDisplayed();
	}
	
	public void setQuantity(int quantity) {
		eleUtil.getElement(quantityField).clear();
		eleUtil.getElement(quantityField).sendKeys(String.valueOf(quantity));
	}
	
	public AddToCartModal addToCart() {
		eleUtil.getElement(addToCard).click();
		return new AddToCartModal(driver);
	}
	*/
}
