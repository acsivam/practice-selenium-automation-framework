package com.automation.models;

public class CreditCard {
	
	public CreditCard() {
	}
	
	public CreditCard(
			String name,
			String number,
			String cvc,
			String month,
			String year
			) {
		this.name = name;
		this.number = number;
		this.cvc = cvc;
		this.month = month;
		this.year = year;
		
	}
	
	private String name;
	private String number;
	private String cvc;
	private String month;
	private String year;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCvc() {
		return cvc;
	}
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
