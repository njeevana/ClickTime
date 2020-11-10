package com.clicktime.tests;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.clicktime.entity.FeedBack;
import com.clicktime.pages.FeedBackPage;
import com.clicktime.pages.FeedBackSubmissionPage;


public class FeedBackPageTest extends BaseTest{
		
	
	//Default Variables
	private static final String DEFAULT_NAME = "Jeevana";
	private static final String DEFAULT_EMAIL = "Jeevana@gmail.com";
	private static final String DEFAULT_INVALID_EMAIL = "Jeevanagmailcom";
	private static final String DEFAULT_ZIPCODE = "45244";
	private static final String DEFAULT_COMMENT = "Test Comment";
	
	
	//Class Objects
	FeedBackPage feedBackPage = new FeedBackPage();
	FeedBackSubmissionPage feedBackSubmissionPage = new FeedBackSubmissionPage();
	

	//Test CaseC:Verify that 'Give us your feedback' header text is present.
	//TC:Verify that all fields - 'name', 'email', 'zip code', 'comments' are available in the web page.
	//TC:Verify that submit button is available to send the feedback.
	//TC:Verify that 'all fields are required' text label message is present.
	@Test
	public void ValidateFeedBackSubmissionPageObjects() {
		feedBackPage.validateFeedBackPageObjects();
	}
	

	@Test
	//TC: Verify that user will be able to submit his/her details when they enter name, email, zip and comments properly.
	//Verify that user gets "(Name of the user), your feedback has been submitted. Thanks for contacting us!" response message after submitting feedback.
	//	@Parameters({ DEFAULT_NAME, DEFAULT_EMAIL, DEFAULT_ZIPCODE, DEFAULT_COMMENT})
	public void ValidateFeedBackSubmission() {
		feedBackPage.enterName(DEFAULT_NAME,  true);
		feedBackPage.enterEmail(DEFAULT_EMAIL,  true);
		feedBackPage.enterZipCode(DEFAULT_ZIPCODE,  true);
		feedBackPage.enterComments(DEFAULT_COMMENT,  true);
		feedBackPage.clickSubmitBtn();
		feedBackSubmissionPage.assertFeedBackSubmissionTxt(DEFAULT_NAME, "equals");
	}
	
	
	@DataProvider(name="getFeedBackData") 
    public Object[][] getFeedBackData() {
        return new Object[][]{
        	{new FeedBack("", "nameBlank@gmail.com", DEFAULT_ZIPCODE, DEFAULT_COMMENT)}, 
        	{new FeedBack("emailBlank", "", DEFAULT_ZIPCODE, DEFAULT_COMMENT)}, 
        	{new FeedBack("zipCodeBlank", DEFAULT_EMAIL, "", DEFAULT_COMMENT)},
        	{new FeedBack("commentBlank", DEFAULT_EMAIL, DEFAULT_ZIPCODE, "")} 
        };
    }
	
	
	//TC:Verify that user gets error message 'Some fields were left blank. Please complete the form and try again.'  when they don't enter data in 'name' field. 
	//TC:Verify that user gets error message 'Some fields were left blank. Please complete the form and try again.'  when they don't enter data in 'email id' field. 
	//TC:Verify that user gets error message 'Some fields were left blank. Please complete the form and try again.' when they don't enter 'zip code' field.
	//TC:Verify that user gets error message 'Some fields were left blank. Please complete the form and try again.'  when they don't enter 'comments' in text area.
	@Test(dataProvider="getFeedBackData")
	public void ValidateMissingFieldsAssertion(FeedBack feedBack) {
		feedBackPage.enterName(feedBack.getName(),  true);
		feedBackPage.enterEmail(feedBack.getEmail(),  true);
		feedBackPage.enterZipCode(feedBack.getZipCode(),  true);
		feedBackPage.enterComments(feedBack.getComment(),  true);
		feedBackPage.clickSubmitBtn();
		feedBackPage.assertMissingFieldsErrorMsgTxt();
	}
	
	
	//TC: Verify that user gets error message prompt 'Please include an @ in the email address' when they don't enter '@' in email id format field.
	@Test
	public void ValidateInvalidEmailAssertion() {
		feedBackPage.enterName(DEFAULT_NAME,  true);
		feedBackPage.enterEmail(DEFAULT_INVALID_EMAIL,  true);
		feedBackPage.enterZipCode(DEFAULT_ZIPCODE,  true);
		feedBackPage.enterComments(DEFAULT_COMMENT,  true);
		feedBackPage.clickSubmitBtn();
		feedBackPage.ValidateEmail(DEFAULT_INVALID_EMAIL);
	}
	
	
	//TC:Verify that user will not be able to enter characters more than 50 in name field.
	//TC:Verify that user will not be able to enter characters more than 50 in email field.
	//TC:Verify that user will not be able to enter characters more than 15 in zip code field.
	@Test
	public void validateFeedBackFieldsLengthLimit() {
		String sampleTextWithMoreThan50Chars = "1abcdefghijklmnopqrstuvwxyz2abcdefghijklmnopqrstuvwxyz3abcdefghijklmnopqrstuvwxyz4abcdefghijklmnopqrstuvwxyz";
		feedBackPage.enterName(sampleTextWithMoreThan50Chars,  true);
		feedBackPage.enterEmail(sampleTextWithMoreThan50Chars, true);
		feedBackPage.enterZipCode(sampleTextWithMoreThan50Chars, true);
		feedBackPage.validateNameFieldLengthLimit();
		feedBackPage.validateEmailFieldLengthLimit();
		feedBackPage.validateZipCodeFieldLengthLimit();
	}
	
	

//	@Test
//	public void multiThread() {
//		
//		
//	}
	
}
