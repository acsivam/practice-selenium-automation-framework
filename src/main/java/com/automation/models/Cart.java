package com.automation.models;

import java.util.List;

public class Cart {

	public Cart() {}
	
	public Cart(List<CartItem> cartItems, String grandTotal) {
		this.cartItems = cartItems;
		this.grandTotal = grandTotal;
	}

	private List<CartItem> cartItems;
	private String grandTotal;
	
	public List<CartItem> getCartItems(){
		return cartItems;
	}
	
	public String getGrandTotal() {
		return grandTotal;
	}
}
