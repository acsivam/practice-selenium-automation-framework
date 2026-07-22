package com.automation.assertions;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.automation.components.CartRow;
import com.automation.components.CartTable;
import com.automation.models.CartItem;
import com.automation.models.Product;
import com.automation.pages.CartPage;
import com.automation.utils.LoggerUtil;

public class CartAssertions { 
	
	//public static void  	public CartAssertions hasProducts
	private Logger logger = LoggerUtil.getLogger(getClass());
	private CartTable cartTable;
	private CartPage cartPage;
	
    public CartAssertions(CartTable cartTable) {
        this.cartTable = cartTable;
    }
	
    public CartAssertions(CartPage cartPage) {
        this.cartPage = cartPage;
    }
    
    public static CartAssertions verifyThat (CartTable cartTable) {
    	return new CartAssertions (cartTable);
    }
	
    public static CartAssertions verifyThat (CartPage cartPage) {
    	return new CartAssertions (cartPage);
    }
    public CartAssertions isCartTableDisplayed() {
    	Assert.assertTrue(cartTable.isDisplayed(), 
    			"Cart table shoudl be dispaleyd");
    	return this;
    }
    
    public CartAssertions isCartEmpty() {
    	Assert.assertTrue(cartPage.isCartEmpty(),
    			"Cart should be empty");
    	return this;
    }
    
    public CartAssertions hasEmptyMessage() {
    	Assert.assertEquals(cartTable.getEmptyMessage(),
    			"Cart is empty! Click here to buy products.");
    	return this;
    }
    
	public CartAssertions hasTableHeaders(List<String> expectedHeaders) {
		Assertions.assertThat(cartTable.getHeaders())
	            .containsExactlyElementsOf(expectedHeaders);
	    return this;
	}
	
	public CartAssertions hasProduct(CartItem expectedItem) {
	    return hasProducts(List.of(expectedItem));
	}

	public CartAssertions hasProducts(List<CartItem> expectedItems) {
		SoftAssert softly = new SoftAssert();
		
		List<CartRow> actualRows = cartTable.getCartRows();
	
		logger.info("Actual count: {}, expected count: {} ",actualRows.size(), expectedItems.size());
		

		Assert.assertEquals(actualRows.size(), expectedItems.size(),
			   "Cart item count does not match"
	   			);
	  
		for(CartRow row : actualRows) {
		   CartItem expectedItem = null;
		   
		   for(CartItem item : expectedItems) {
			   if (item.getProduct().getName().equals(row.getName())) {
	                expectedItem = item;
	                break;
	            }
		}
		   
		if (expectedItem == null) {
		    softly.fail("Product not found in expected cart items: " + row.getName());
		    continue;
		}
		   
		softly.assertNotNull(expectedItem, 
				"Product not found in expected cart items: " + row.getName());

		softly.assertEquals(row.getName(),
	            expectedItem.getProduct().getName(),
	            "Product name mismatch");

		softly.assertEquals(row.getCategory(),
	            expectedItem.getProduct().getCategory() + " > " + expectedItem.getProduct().getSubCategory(),
	            "Product category mismatch for: " + row.getName());

		softly.assertEquals(row.getPrice(),
	            "Rs. " + expectedItem.getProduct().getPrice(),
	            "Product price mismatch for: " + row.getName());

		softly.assertEquals(Integer.parseInt(row.getQuantity()),
	            expectedItem.getQuantity(),
	            "Product quantity mismatch for: " + row.getName());

	    softly.assertEquals(row.getTotal(),
	    		"Rs. " + expectedItem.getTotal(),
	            "Product total mismatch for: " + row.getName());
	   }
	   
	   softly.assertAll();
	   
	   return this;
	}

	public CartAssertions hasProductCount(int expectedCount) {
	    Assert.assertEquals(cartTable.getProductCount(),
	    		expectedCount );
	    return this;
	}

	public CartAssertions hasGrandTotal(String expectedGrandTotal) {
	    Assert.assertEquals(cartTable.getGrandTotal(),
	    		expectedGrandTotal );
	    /*
		Assertions.assertThat(cartTable.getGrandTotal())
	            .isEqualTo(expectedGrandTotal); 
	    */
	    return this;
	}
	
	
	// Helper methods 
	
}
