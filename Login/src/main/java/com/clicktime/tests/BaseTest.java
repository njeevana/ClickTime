package com.clicktime.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


//This Class contains actual Driver Object, Setup, Tear down methods.
public class BaseTest {
	
	
	public static WebDriver driver;
	
	static {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	}
	
	//setup
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://login.clicktime.com/qa/");
	}
	
	//tear down
	@AfterMethod
	public void teardown() {
		driver.close();
	}
	
}
