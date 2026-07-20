package com.automation.models;

public class CartItem {

	public CartItem() {
	}
	
	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		this.total = product.getPrice() * quantity;
		}
	
	private Product product;
    private int quantity;
    private int total;
    
    
    public Product getProduct() {
    	return product;
    }
    
	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotal() {
		return total;
	}
}
