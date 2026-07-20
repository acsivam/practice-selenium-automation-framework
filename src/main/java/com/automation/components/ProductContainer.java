package com.automation.components;

import java.util.List;

public interface ProductContainer {
	
    List<ProductCard> getProducts();
    
    ProductCard getProductByName(String name);

    int getProductCount();

    boolean isDisplayed();
 
}
