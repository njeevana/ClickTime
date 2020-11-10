package com.clicktime.pages;

import com.clicktime.componentHelper.BaseCommands;
import com.clicktime.maps.FeedBackSubmissionPageMap;

public class FeedBackSubmissionPage {
	//Class Object Declarations
	BaseCommands bc = new BaseCommands();
	FeedBackSubmissionPageMap feedBackSubmissionPageMap = new FeedBackSubmissionPageMap();
				
	//Asserts Feedback Submission Text
	public void assertFeedBackSubmissionTxt(String name, String comparisionMode) {
		String feedBackMsg = name + ", your feedback has been submitted. Thanks for contacting us!";
		bc.assertElementTxt(feedBackSubmissionPageMap.submissionTxt(), feedBackMsg, comparisionMode);
	}
	
}
