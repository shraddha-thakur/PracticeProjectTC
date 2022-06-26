package com.tmb.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExampleTest {

	private WebDriver driver;
	
		
	@BeforeClass 
	public void SetUp() {
//		Firefox
//		WebDriverManager.firefoxdriver().setup();
//		driver = new FirefoxDriver();
		
//		Chrome
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
//		IE
//		WebDriverManager.iedriver().setup();
//		driver = new InternetExplorerDriver();
//		org.openqa.selenium.SessionNotCreatedException: Unexpected error launching Internet Explorer. Protected Mode settings are not the same for all zones. Enable Protected Mode must be set to the same value (enabled or disabled) for all zones.

		
	}
	
	@Test
	public void SeleniumTest1() {
		System.out.println("In Test 1");
		driver.get("http://www.google.com");
		String expectedPageTitle = "Google";
		Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Test Failed");
		
	}
	
	@Test
	public void SeleniumTest2() {
		System.out.println("In Test 2");
	}
	
	@Test
	public void SeleniumTest3() {
		System.out.println("In Test 3");
		
	}
	
	@AfterClass
	public void tearDown() {
	if(driver!=null) 
		driver.quit();
	
	}
}
