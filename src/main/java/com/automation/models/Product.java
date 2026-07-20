package com.automation.models;

public class Product {

	private String productId;
	private String name;
	private String category;
	private String subCategory;
	private String brand;
	private int price;
	private String availability;
	private String condition;
	
	public Product() {
	}
	
	public Product(String productId,
			String name,
			String category,
			String subCategory,
			String brand,
			int price,
			String availability,
			String condition) {
		
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.subCategory = subCategory;
		this.brand = brand;
		this.price = price;
		this.availability = availability;
		this.condition = condition;
	}

	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAvailability() {
		return availability;
	}
	public void setAvailability(String availability) {
		this.availability = availability;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}	
}
