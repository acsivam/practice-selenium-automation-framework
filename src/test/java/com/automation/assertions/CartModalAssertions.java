package com.automation.assertions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.automation.components.CartModal;

public class CartModalAssertions {
	
	private CartModal cartModal;
	 
	public CartModalAssertions(CartModal cartModal)	{
		this.cartModal = cartModal;
	}
	
	public static CartModalAssertions verifyThat(CartModal cartModal) {
	    return new CartModalAssertions(cartModal);
	}
	 
    public CartModalAssertions isDisplayed() {
    	Assert.assertTrue(
    			cartModal.isDisplayed(),
    			"Add to Cart Modal should be displayed");
    	return this;
    }
    
    public CartModalAssertions hasTitle() {	
    	Assert.assertEquals(	
        		cartModal.getAddedTitle(),
                "Added!",
                "Title shoud be 'Added!'."
    			);
    	return this;
    }
    
    public CartModalAssertions hasMessage() {
    	Assert.assertEquals(
            	"Your product has been added to cart.",
            	"Confirmation message should match"
    			);
    	return this;
    }
    
    public CartModalAssertions hasViewCartButton() {
    	Assert.assertTrue(
    			cartModal.isViewCartDisplayed(),
                "View Cart link should be displayed"
    			);
    	return this;
    }
    
    public CartModalAssertions  hasContinueShoppingButton() {
    	Assert.assertTrue(
    			cartModal.isContinueShoppingDisplayed(),
                "Continue Shopping button should be displayed"
    			);
    	return this;
    }
    
    public CartModalAssertions hasDefaultCartModal() {
    	SoftAssert softly = new SoftAssert();
    
    	isDisplayed();
    	softly.assertEquals(
    			cartModal.getAddedTitle(), 
    			"Added!", 
    			"Title mismatch.");
    	softly.assertTrue(
    			cartModal.isContinueShoppingDisplayed(),
                "Continue Shopping button missing"
    			);
    	softly.assertEquals(
            	"Your product has been added to cart.",
            	"Confirmation message mismatch"
    			);
    	softly.assertTrue(
    			cartModal.isViewCartDisplayed(),
                "View Cart link should be displayed"
    			);
    	softly.assertTrue(
    			cartModal.isContinueShoppingDisplayed(),
                "Continue Shopping button missing"
    			);
    	return this;
    }
    
}

    
  
