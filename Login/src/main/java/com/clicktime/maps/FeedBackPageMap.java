package com.clicktime.maps;

import org.openqa.selenium.By;

public class FeedBackPageMap {
	
	public By pageTitleTxt() {
		return By.cssSelector("#main h2");
	}
	
	public By nameField() {
		return By.cssSelector("#fullName");
	}
	
	public By emailField() {
		return By.cssSelector("#email");
	}
	
	public By zipCodeField() {
		return By.cssSelector("#zipcode");
	}
	
	public By commentsTxtArea() {
		return By.cssSelector("#comments");
	}

	public By submitBtn() {
		return By.cssSelector("#Submit1");
	}

	public By allFieldsRequiredTxt() {
		return By.cssSelector(".required");
	}

	public By missingFieldsErrorMsgTxt() {
		return By.cssSelector("span.oops");
	}
	
}
