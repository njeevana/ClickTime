package com.clicktime.pages;

import org.testng.Assert;

import com.clicktime.componentHelper.BaseCommands;
import com.clicktime.maps.FeedBackPageMap;

public class FeedBackPage {
	
	//Class Object Declarations
	BaseCommands bc = new BaseCommands();
	FeedBackPageMap feedBackPageMap = new FeedBackPageMap();
			
	public void validateFeedBackPageObjects() {
		bc.waitForElementVisibility(feedBackPageMap.pageTitleTxt());
		bc.ValidateElementExists(feedBackPageMap.nameField());
		bc.ValidateElementExists(feedBackPageMap.emailField());
		bc.ValidateElementExists(feedBackPageMap.zipCodeField());
		bc.ValidateElementExists(feedBackPageMap.commentsTxtArea());
		bc.ValidateElementExists(feedBackPageMap.submitBtn());
		bc.ValidateElementExists(feedBackPageMap.allFieldsRequiredTxt());
	}
	
	//Enters Name
	public void enterName(String name, boolean clearField) {
		bc.enter(feedBackPageMap.nameField(), name, clearField);
	}
	
	//Validates Name Field Length
	public void validateNameFieldLengthLimit() {
		String existingNameValue = bc.getElementAttribute(feedBackPageMap.nameField(), "value");
		if(null != existingNameValue) {
			Assert.assertTrue(existingNameValue.length() <= 50, "Name Field Limit is 50, but the existing value " + existingNameValue + " exceeded the limit.");
		}
	}
	
	//Enters Email
	public void enterEmail(String email, boolean clearField) {
		bc.enter(feedBackPageMap.emailField(), email, clearField);
	}
	
	//Validates Email Field Length
	public void validateEmailFieldLengthLimit() {
		String existingEmailValue = bc.getElementAttribute(feedBackPageMap.emailField(), "value");
		if(null != existingEmailValue) {
			Assert.assertTrue(existingEmailValue.length() <= 50, "Email Field Limit is 50, but the existing value " + existingEmailValue + " exceeded the limit.");
		}
	}
	
	//Enters Email
	public void ValidateEmail(String email) {
		String actualMessage = bc.getElementAttribute(feedBackPageMap.emailField(), "validationMessage");
		Assert.assertEquals(actualMessage, "Please include an '@' in the email address. '" + email + "' is missing an '@'.");
	}
		
	
	//Enters ZipCode
	public void enterZipCode(String zipCode, boolean clearField) {
		bc.enter(feedBackPageMap.zipCodeField(), zipCode, clearField);
	}
	
	//Validates Zip Code Field Length
	public void validateZipCodeFieldLengthLimit() {
		String existingZipCodeValue = bc.getElementAttribute(feedBackPageMap.zipCodeField(), "value");
		if(null != existingZipCodeValue) {
			Assert.assertTrue(existingZipCodeValue.length() <= 15, "Zip Code Field Limit is 15, but the existing value " + existingZipCodeValue + " exceeded the limit.");
		}
	}
		
	//Enters Comments
	public void enterComments(String comments, boolean clearField) {
		bc.enter(feedBackPageMap.commentsTxtArea(), comments, clearField);
	}
	
	//clicks Submit Button
	public void clickSubmitBtn() {
		bc.click(feedBackPageMap.submitBtn());
	}
		
	
	//Asserts Feedback Submission Error Text
	public void assertMissingFieldsErrorMsgTxt() {
		bc.assertElementTxt(feedBackPageMap.missingFieldsErrorMsgTxt(), "Some fields were left blank. Please complete the form and try again.", "equals");
	}
}
