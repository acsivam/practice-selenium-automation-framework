package com.automation.models;

public class User {
	
	public User(){
	}

	public User(
	        String title,
	        String name,
	        String email,
	        String password,
	        String day,
	        String month,
	        String year,
	        boolean newsletter,
	        boolean specialOffers,
	        String firstName,
	        String lastName,
	        String company,
	        String address1,
	        String address2,
	        String country,
	        String state,
	        String city,
	        String zipcode,
	        String mobile) {

	    this.title = title;
	    this.name = name;
	    this.email = email;
	    this.password = password;

	    this.day = day;
	    this.month = month;
	    this.year = year;

	    this.newsletter = newsletter;
	    this.specialOffers = specialOffers;

	    this.firstName = firstName;
	    this.lastName = lastName;
	    this.company = company;

	    this.address1 = address1;
	    this.address2 = address2;
	    this.country = country;

	    this.state = state;
	    this.city = city;
	    this.zipcode = zipcode;
	    this.mobile = mobile;
	}
	
    private String title;
    private String name;
    private String email;
    private String password;

    private String day;
    private String month;
    private String year;

    private boolean newsletter;
    private boolean specialOffers;
    
    private String firstName;
    private String lastName;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String state;
    private String city;
    private String zipcode;
    private String mobile;
    
    // getters & setters
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
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
	public boolean isNewsletter() {
	    return newsletter;
	}
	public void setNewsletter(boolean newsletter) {
	    this.newsletter = newsletter;
	}
	public boolean isSpecialOffers() {
	    return specialOffers;
	}
	public void setSpecialOffers(boolean specialOffers) {
	    this.specialOffers = specialOffers;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
