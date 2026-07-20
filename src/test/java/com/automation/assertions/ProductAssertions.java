package com.automation.assertions;


import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.automation.components.ProductCard;
import com.automation.components.ProductContainer;
import com.automation.components.ProductImage;
import com.automation.components.ProductInformation;
import com.automation.models.Product;

public class ProductAssertions {


	private ProductContainer prodContainer;
	private ProductInformation productInfo;
	private ProductImage productImg;
	/*/*/
	
	public ProductAssertions(ProductContainer productContainer) {
		this.prodContainer = productContainer;
	}
	
	public ProductAssertions(ProductImage productImg) {
		this.productImg = productImg;
	}
	
	public ProductAssertions(ProductInformation productInfo) {
		this.productInfo = productInfo;
	}
	
	public static ProductAssertions assertThat(ProductContainer container) { //hasProductGrid
		return new ProductAssertions(container);
	} 
	
	public ProductAssertions isDisplayed() { 
		Assert.assertTrue(
				prodContainer.isDisplayed(),
				"Product grid should be displayed"
				);
		return this;
	} 
	
	public ProductAssertions hasProductsDisplayed(){//change method name isDosplayingProducts
		Assert.assertTrue(
				prodContainer.getProductCount() > 0,
				"There should be atleast one product"
				);
		return this;
	} 

	public ProductAssertions hasProductCount(int expectedCount) {
		Assert.assertTrue(
				prodContainer.getProductCount() == expectedCount,
				"Should display :" + prodContainer.getProductCount()
				);
				
		return this;
	}
	
	public ProductAssertions hasProducts(Product expectedProduct) {
		Product actualProduct = prodContainer
				.getProductByName(expectedProduct.getName())
				.toProduct();

		Assert.assertEquals(
			    actualProduct.getName(),
			    expectedProduct.getName());
		Assert.assertEquals(
			    actualProduct.getPrice(),
			    expectedProduct.getPrice(),
			    "Should contain product: " + expectedProduct.getName());
		
		return this;
		/*
	    Assert.assertTrue(
	            prodContainer.getProducts()
	                .stream()
	                .map(ProductCard::toProduct)
	                .anyMatch(actual ->
	                    actual.getName().equals(expectedProduct.getName())
	                    && actual.getPrice() == expectedProduct.getPrice()
	                ),
	            "Should contain product: " + expectedProduct.getName()
	        );

	        return this;
	    */
	}
	   
	public ProductAssertions hasProducts(List<Product> expectedProducts) {
		List<Product> actualProducts = new ArrayList<>();
		
		for(ProductCard card : prodContainer.getProducts()) {
			actualProducts.add(card.toProduct());
		}

		for(Product expected : expectedProducts) {
		Assert.assertTrue(
			    actualProducts.stream().anyMatch(actual ->
			        actual.getName().equals(expected.getName()) &&
			        actual.getPrice() == expected.getPrice()
			    ),
			    "Should contain product: " + expected.getName());
		}
		
		return this;
		
	}
		
	public ProductAssertions hasProductImage(Product expectedProduct) {
		Assert.assertTrue(
				prodContainer
					.getProductByName(expectedProduct.getName())
					.isProductImageDisplayed(),
				"Product image should be displaed");
		return this;
	}
	
	public ProductAssertions hasProductName(Product expectedProduct) {
		
		Assert.assertTrue(
				prodContainer.getProductByName(expectedProduct.getName()).isNameDisplayed(),
				"Product name should be displayed"
				);
		return this;
	}
	
	public ProductAssertions hasProductPrice(Product expectedProduct) {
		
		Assert.assertTrue(
				prodContainer.getProductByName(expectedProduct.getName()).isPriceDisplayed(),
				"Product price should be displayed"
				);
		return this;
	}
	
	public ProductAssertions hasAddToCartButton(Product expectedProduct) {
				
		Assert.assertTrue(
				prodContainer.getProductByName(expectedProduct.getName()).isAddToCartButtonDisplayed(),
				"AddToCart button should be displayed"
				);
		return this;
	}
	
	public ProductAssertions hasViewDetailsButton(Product expectedProduct) {
		
		Assert.assertTrue(
				prodContainer.getProductByName(expectedProduct.getName()).isViewProductButtonDisplayed(),
				"View Product button should be displayed"
				);
		return this;
	}
	
	public ProductAssertions hasImageOverlay(Product expectedProduct) {
		
		Assert.assertTrue(
				prodContainer.getProductByName(expectedProduct.getName()).isProductOverlayDisplayed(),
				"Product card should have product overlay"
				);
		return this;
	}

	public ProductAssertions hasDefaultProductCard(Product expectedProduct)   {
		SoftAssert softly = new SoftAssert();

	    ProductCard card = prodContainer.getProductByName(expectedProduct.getName());
	    softly.assertTrue(card.isDisplayed(), "Procut card should be displayed");
	    softly.assertTrue(card.isProductImageDisplayed(), "Product image missing for " +card.getName());
	    softly.assertTrue(card.isNameDisplayed(),"Product name missing");
	    softly.assertTrue(card.isPriceDisplayed(), "Product price missing");
	    softly.assertTrue(card.isAddToCartButtonDisplayed(), "Add cart missing");
	    softly.assertTrue(card.isViewProductButtonDisplayed(),"View button missing");

	    softly.assertAll();
		return this;
	}  // combines all card assertions
	
	public ProductAssertions hasDefaultProductCards() {
		for(ProductCard prodCard : prodContainer.getProducts()) {
			Assert.assertTrue(prodCard.isProductImageDisplayed());
	        Assert.assertTrue(prodCard.isNameDisplayed());
	        Assert.assertTrue(prodCard.isPriceDisplayed());
	        Assert.assertTrue(prodCard.isAddToCartButtonDisplayed());
	        Assert.assertTrue(prodCard.isProductOverlayDisplayed());
		}
		return this;
	}

	public ProductAssertions hasRecommendedProductCard(Product expectedProduct) {
		hasProductName(expectedProduct);
		hasProductPrice(expectedProduct);
		hasAddToCartButton(expectedProduct);
		return this;
	}
	
	public ProductAssertions hasDefaultProductImage(String productId) {
		Assert.assertTrue(productImg.isProductImageDisplayed());
		Assert.assertTrue(productImg.getProductImageUrl()
				.contains("get_product_picture/" + productId));
		return this;
	}
	
	public ProductAssertions hasDefaultProductInformation(Product expected) {	
		SoftAssert softly = new SoftAssert();
		
		softly.assertEquals(
				this.productInfo.getProductName(),
				expected.getName(),
				"Product name mismatch");				;
		softly.assertEquals(
				this.productInfo.getCategory(),
				"Category: " + expected.getCategory() + " > " + expected.getSubCategory(),
				"Product category mismatch");
		softly.assertEquals(
				this.productInfo.getPrice(),
				"Rs. " + expected.getPrice(),
				"Product price mismatch");
		softly.assertTrue(
				this.productInfo.isQuantityinputDisplayed(),
				"Quantity input box is missing");
		softly.assertTrue(
				this.productInfo.isAddToCartuttonDisplayed(),
				"Add To Cart button is missing");
		softly.assertEquals(
				this.productInfo.getAvailability(),
				"Availability: " +expected.getAvailability(),
				"Product availability mismatch" + this.productInfo.getAvailability());
		softly.assertEquals(
				this.productInfo.getCondition(),
				"Condition: " + expected.getCondition(),
				"Product cndition mismatch");
		softly.assertEquals(this.productInfo.getBrand(),
				"Brand: " + expected.getBrand(),
				"Produc brand mismatch");
		softly.assertAll();
		return this;
	}
}