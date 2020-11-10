package com.clicktime.entity;

public class FeedBack {
	public String name;
	public String email;
	public String zipCode;
	public String comment;
	
	public FeedBack(String name, String email, String zipCode, String comment) {
        this.name = name;
        this.email = email;
        this.zipCode = zipCode;
        this.comment = comment;
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
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getComment() {
		return comment;
	}
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
