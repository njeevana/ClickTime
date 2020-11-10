package com.clicktime.componentHelper;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.clicktime.tests.BaseTest;

public class BaseCommands extends BaseTest{

	BaseTest baseTest = new BaseTest();
	
	//Use this method for unique elements
    public Boolean isElementPresent(By locator)
    {
        try {
            return findAll(locator).size() == 1;
        }
        catch (Exception ex) {
            return false;
        }
    }
    
    public void ValidateElementExists(By locator)
    {
    	Assert.assertTrue(isElementPresent(locator), "Element with locator " + locator.toString() + " does not exist in current Webpage");
    }
    
    public WebElement GetElement(By locator)
    {
        if (isElementPresent(locator))
        {
            return driver.findElement(locator);
        }
        else {
            throw new NoSuchElementException("Element Not Found " + locator.toString());
        }
    }
    
	//click
	public void click(By locator) 
	{
		waitForElementVisibility(locator);
		ScrollToElement(locator);
		driver.findElement(locator).click();
	}
	
	//find all elements
	public List<WebElement> findAll(By locator) 
	{
		waitForElementVisibility(locator);
		List<WebElement> elements = driver.findElements(locator);
		return elements;
	}
	
	//enter text
	public void enter(By locator, String text, Boolean clearField) {
		waitForElementVisibility(locator);
		if(clearField) {
			driver.findElement(locator).clear();
		}
		driver.findElement(locator).sendKeys(text);
	}
	
	//Gets Attribute Value
	public String getElementAttribute(By locator, String attributeName) {
		return driver.findElement(locator).getAttribute(attributeName);
	}

	//Validate text
	public void assertElementTxt(By locator, String expectedElementTxt, String comparisionMode) 
	{
		//Wait for the Element
		waitForElementVisibility(locator);
		
		//Get Actual Element Text
		String actualElementText = driver.findElement(locator).getText();
		
		if(comparisionMode.toLowerCase().contains("contains")) {
			//Asserting with Contains Condition
			Assert.assertEquals(actualElementText.contains(expectedElementTxt), true);
		}else{
			//Default Assertion
			Assert.assertEquals(actualElementText, expectedElementTxt);
		}	
	}
	
	//common wait for all actions
	public void waitForElementVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//common wait 
	public void wait(int seconds)
	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public WebElement ScrollToElement(By locator)
	{
	    WebElement element = driver.findElement(locator);
	    return ScrollToElement(element);
	 }
	
	public WebElement ScrollToElement(WebElement element)
	{
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(" + element.getLocation().x+ "," +(element.getLocation().y- 100) + ");");
	    return element;
	 }
	
}
