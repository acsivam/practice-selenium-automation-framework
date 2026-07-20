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
import com.automation.utils.LoggerUtil;

public class CartAssertions { 
	
	//public static void  	public CartAssertions hasProducts
	private Logger logger = LoggerUtil.getLogger(getClass());
	private CartTable cartTable;
	
    public CartAssertions(CartTable cartTable) {
        this.cartTable = cartTable;
    }
    
    public static CartAssertions verifyThat (CartTable cartTable) {
    	return new CartAssertions (cartTable);
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
	
		Assert.assertTrue(
			   actualRows.size() == expectedItems.size(),
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
		Assertions.assertThat(cartTable.getProductCount())
	            .isEqualTo(expectedCount);
	    return this;
	}

	
	public CartAssertions hasGrandTotal(String expectedGrandTotal) {
		Assertions.assertThat(cartTable.getGrandTotal())
	            .isEqualTo(expectedGrandTotal);
	    return this;
	}
	
	
	// Helper methods 
	
}
